package hello.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService2;

@Configuration
public class SpringConfig {
	
	@Bean
	public MemberService2 memberService() {
		return new MemberService2(memberRepository());
		
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
		
	}
	
}
