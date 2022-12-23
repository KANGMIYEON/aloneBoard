package com.ezen.spring.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.spring.domain.UserVO;
import com.ezen.spring.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/member/*")
@Controller
public class MemberController {
	
	@Inject
	private UserService usv;
	
	@GetMapping("/signup")
	public String signUpGet() {
		return "/user/signup";
	}
	
	@PostMapping("/signup")
	public String signUpPost(Model model, UserVO user) {
		log.info(user.toString());
		boolean isUp = usv.signUp(user);
		if(isUp) {
			return "/user/login";
		}else {
			model.addAttribute("msg", "0");
			return "/user/signup";
		}
	}
	
	@GetMapping("/login")
	public String loginGet() {
		return "/user/login";
	}
	
	@PostMapping("/login")
	public String loginPost(Model model, String id, String pw, HttpServletRequest req) {
		log.info(">>> id : " + id + " >>> pw : " + pw);
		UserVO isUser = usv.isUser(id,pw);
		
		if(isUser != null) {
			HttpSession session = req.getSession();
			session.setAttribute("ses", isUser);
			
			model.addAttribute("user", isUser);
			model.addAttribute("msg", "1");
			return "redirect:/main";
		} else {
			model.addAttribute("msg", "0");
			return "/user/login";			
		}
	}
	
	@GetMapping("/logout")
	public String logoutGet(Model model, HttpServletRequest req) {
		req.getSession().removeAttribute("ses");
		req.getSession().invalidate();
		return "redirect:/";
	}

}
