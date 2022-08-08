package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;


public class MemberService2 {
private final MemberRepository memberRepository;
	
	// 사용하는 쪽에서 memberRepository 를 넣어준다 . -> dependency Injection
	
	public MemberService2(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	/*
	 * 회원가입
     */
	public Long join (Member member) {
		
		//같은 이름이 있는 중복 회원 x
		
		validateDuplicateMember(member);
		
		memberRepository.save(member);
		
		return member.getId();
		
	}

	private void validateDuplicateMember(Member member) {
		memberRepository.findByName(member.getName())
			.ifPresent(m ->{
				
				throw new IllegalStateException("이미 존재하는 회원 입니다.");
				
			});
	}
	
	/*
	 * 전체 회원 조회
     */
	public List<Member> findMembers(){
		
		return memberRepository.findAll(); 
	}
	
	
	public Optional<Member> findOne(Long memberId){
		
		return memberRepository.findById(memberId);
	}
}
