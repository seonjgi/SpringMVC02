package com.my.multiweb;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.model.NotUserException;
import com.user.model.UserVO;
import com.user.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class LoginController {
	
	
	@Inject
	private UserService userService;
	
	@PostMapping("/login")
	public String loginProcess(HttpSession session, @ModelAttribute("user") UserVO user)
	throws NotUserException {
		log.info("user===="+user);
		if (user.getUserid().trim().isEmpty()||user.getPwd().trim().isEmpty()) {
			return "redirect:index";
		}
		UserVO loginUser = userService.loginCheck(user.getUserid(), user.getPwd());
		if (loginUser!=null) {
			//로그인 인증을 받았다면
			session.setAttribute("loginUser", loginUser);
		}
		return "redirect:index";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
	
	//예외처리하는 메서드앞에 @ExceptionHandler를 붙이고 구체적인 예외 클래스를 지정한다
	@ExceptionHandler(NotUserException.class)
	public String exceptionHandler(Exception ex) {
		log.error(ex);
		return "login/errorAlert";
	}
	
}
