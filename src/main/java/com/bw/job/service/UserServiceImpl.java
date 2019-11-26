package com.bw.job.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.job.dao.ScoreMapper;
import com.bw.job.dao.UserMapper;
import com.bw.job.domain.Position;
import com.bw.job.domain.Score;
import com.bw.job.domain.User;
import com.bw.job.vo.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private ScoreMapper scoreMapper;

	@Override
	public PageInfo<User> selects(UserVo vo, int page, int pageSize) {
		
		PageHelper.startPage(page, pageSize);
		List<User> list = userMapper.selects(vo);	
		
		return new PageInfo<User>(list);
	}

	@Override
	public void insert(User user, List<Score> list) {
		
		try {
			userMapper.insertSelective(user);
			for (Score score : list) {
				score.setUid(user.getId());
				scoreMapper.insertSelective(score);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("添加失败");
		}
		
	}

	@Override
	public User select(Integer uid) {
		
		return userMapper.select(uid);
	}

	@Override
	public List<Position> selectsPosition() {

		return userMapper.selectsPosition();
	}
}
