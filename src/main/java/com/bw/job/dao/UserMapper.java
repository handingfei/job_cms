package com.bw.job.dao;

import java.util.List;

import com.bw.job.domain.Position;
import com.bw.job.domain.User;
import com.bw.job.vo.UserVo;

public interface UserMapper {

	List<User> selects(UserVo vo);

	int insertSelective(User user);

	User select(Integer uid);

	List<Position> selectsPosition();

}
