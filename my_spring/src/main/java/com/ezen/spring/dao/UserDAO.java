package com.ezen.spring.dao;

import com.ezen.spring.domain.UserVO;

public interface UserDAO {

	UserVO getUser(String id);

	int insertUser(UserVO user);

}
