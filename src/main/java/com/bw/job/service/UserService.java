package com.bw.job.service;

import java.util.List;

import com.bw.job.domain.Position;
import com.bw.job.domain.Score;
import com.bw.job.domain.User;
import com.bw.job.vo.UserVo;
import com.github.pagehelper.PageInfo;

public interface UserService {

	PageInfo<User> selects(UserVo vo, int page, int pageSize);

	void insert(User user, List<Score> list);

	User select(Integer uid);

	List<Position> selectsPosition();

}
