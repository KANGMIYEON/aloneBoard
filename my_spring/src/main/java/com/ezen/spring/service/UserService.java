package com.ezen.spring.service;

import com.ezen.spring.domain.UserVO;

public interface UserService {

	boolean signUp(UserVO user);

	UserVO isUser(String id, String pw);

}
