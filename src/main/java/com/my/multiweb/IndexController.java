package com.my.multiweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	//뷰네임을 반환하지 않으면 (void) @RequestMapping으로 등록한 "/top" ==> 뷰네임이 된다.
	@RequestMapping("/top")
	public void top() {
		// "/WEB-INF/views/top.jsp
	}
	
	@RequestMapping("/foot")
	public void foot() {
		// "/WEB-INF/views/foot.jsp
	}
	
	@RequestMapping("/index")
	public void showIndex() {
		// "/WEB-INF/views/index.jsp
	}
}
