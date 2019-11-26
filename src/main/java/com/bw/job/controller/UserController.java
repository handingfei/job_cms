package com.bw.job.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.job.domain.Position;
import com.bw.job.domain.Score;
import com.bw.job.domain.User;
import com.bw.job.service.UserService;
import com.bw.job.util.PageUtil;
import com.bw.job.vo.UserVo;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@GetMapping("users")
	public String selects( HttpServletRequest request,Model m,UserVo vo,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "3")int pageSize) {
		
		PageInfo<User> info  = userService.selects(vo,page,pageSize);
		PageUtil.page(request, "/users", pageSize, info.getList(), (int)info.getTotal(), page);
		
		request.setAttribute("info", info.getList());
//		m.addAttribute("info", info);
		
		return "users";
	}
	
	
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("user", new User());
		
		return "add";
	}
	
	@PostMapping("add")
	public String add(HttpServletRequest request, 
			@Valid @ModelAttribute User user,
			BindingResult result,MultipartFile file,
			Integer[] scores, Integer[] pids) {
		
		if (result.hasErrors()) {
			return "add";
		}
		
		if (!file.isEmpty()) {
			
			String path = request.getSession().getServletContext().getRealPath("/resource/pic/");
			
			String oldfilename = file.getOriginalFilename();
			
			String newfilename = UUID.randomUUID() + oldfilename.substring(oldfilename.lastIndexOf("."));
			
			File f = new File(path,newfilename);
			
			try {
				file.transferTo(f);
				user.setPicUrl(newfilename);
			
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//封装应聘者的信息
		ArrayList<Score> list = new ArrayList<Score>();
		
		for (int i = 0; i < pids.length; i++) {
			Score score = new Score();
			score.setPid(pids[i]);
			score.setScore(scores[i]);
			list.add(score);
		}
		
		userService.insert(user,list);
		return "redirect:/users";
	}
	
	@RequestMapping("select")
	public String select(Model m,Integer id) {
		User user = userService.select(id);
		m.addAttribute("user", user);
		
		return "user";
	}
	
	
	@GetMapping("selectsPosition")
	@ResponseBody
	public List<Position>  selectsPosition(){
		
		return userService.selectsPosition();
	}
	
	
	
	
	
	
	
	
	
	
}
