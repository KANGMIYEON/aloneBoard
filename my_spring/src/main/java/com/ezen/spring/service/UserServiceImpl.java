package com.ezen.spring.service;

import javax.inject.Inject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ezen.spring.dao.UserDAO;
import com.ezen.spring.domain.UserVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userDao;
	@Inject
	BCryptPasswordEncoder passwordEncoder; // 비밀번호 암호화
	
	@Override
	public boolean signUp(UserVO user) {
		log.info(">>> signup check2");
		
		UserVO tmpUser = userDao.getUser(user.getId());
		
		if(tmpUser != null) {
			return false;
		}
		
		if(user.getId() == null || user.getId().length() == 0) {
			return false;
		}
		
		String pw = user.getPw();
		String encodePw = passwordEncoder.encode(pw);
		user.setPw(encodePw);
		
		int isOk = userDao.insertUser(user);
		
		return true;
	}

	@Override
	public UserVO isUser(String id, String pw) {
		UserVO user = userDao.getUser(id); // 앞에서 했던 메서드 호출
		
		// user가 없을 때
		if(user == null) {return null;}
		
		// 가져온 User 객체의 비밀번호와 입력받은 비밀번호가 같은지 확인
		// matches(원래비번, 암호화된비번)
		if(passwordEncoder.matches(pw, user.getPw())) {
			return user;			
		} else {
			return null;			
		}
		
	}
}
