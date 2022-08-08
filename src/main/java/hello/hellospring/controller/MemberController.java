package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hello.hellospring.service.MemberService2;

@Controller
public class MemberController {
	
	
	
	private final MemberService2 memberService;
	
	@Autowired
	public MemberController(MemberService2 memberService) {
		this.memberService = memberService;
		
	}
	
	
	

}
