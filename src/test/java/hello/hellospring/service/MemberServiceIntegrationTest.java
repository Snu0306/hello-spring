package hello.hellospring.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@SpringBootTest
@Transactional //수행하고 트랜젝션 rollback 해줌
public class MemberServiceIntegrationTest {


	@Autowired MemberService2 memberService;
	@Autowired MemberRepository memberRepository;

	
	@Test
	void 회원가입() {
		//given
		Member member = new Member(); 
		member.setName("123129993122223");
		
		
		//when
		
		Long saveId = memberService.join(member);
		
		//then
		Member findMember = memberService.findOne(saveId).get();
		assertThat(member.getName()).isEqualTo(findMember.getName());
	}
	
	@Test
	public void 중복_회원_예외 () {
		
		//given
		Member member1 = new Member();
		member1.setName("asdfasdf");
		
		Member member2 = new Member();
		member2.setName("sprin12312g2");
		
		 
		// when
		memberService.join(member1);
		//IllegalStateException e = 	assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
//		System.out.println(e.getMessage());
		
		//assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");		
		/*
		 * 
		try {
			
			memberService.join(member2);
			fail();
			
			
		}catch (IllegalStateException e) {
			// TODO: handle exception
			Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
			
		}
		 * */
		
		
		//then
		
	}
	
	

}
