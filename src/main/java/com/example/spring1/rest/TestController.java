package com.example.spring1.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//jsp같은 뷰를 반환하는 것이 아니라 JSON,XML 같은 데이터를 브라우저로 전송하는 컨트롤러인 @Restcontroller를 설정
@RestController
@RequestMapping("/test/*")
public class TestController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello Rest";
	}
	
	@RequestMapping("/member")
	public MemberVO mem() {
		MemberVO vo=new MemberVO();
		vo.setId("son");
		vo.setName("손성현");
		vo.setEmail("@naver.com");
		vo.setPwd("7895");
		return vo;
	} //MemberVO 객체의 속성 값을 저장한 후 JSON으로 전송
	
	@RequestMapping("/memberlist")
	public List<MemberVO> memberlist(){
		List<MemberVO> list=new ArrayList<MemberVO>();
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("son"+i);
			vo.setName("손성현"+i);
			vo.setEmail("@naver.com"+i);
			vo.setPwd("7895"+i);
			list.add(vo);
		}
		return list;
	}//List같은 컬렉션을 JSON으로 만들어 전송
	
	@RequestMapping("/membermap")
	public Map<Integer,MemberVO> memberMap(){
		Map<Integer,MemberVO> map=new HashMap<>();
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("son"+i);
			vo.setName("손성현"+i);
			vo.setEmail("@naver.com"+i);
			vo.setPwd("7895"+i);
			map.put(i, vo);
		}
		return map;
	}//Map에 저장된 데이터 전송
	
	@RequestMapping("/notice/{num}")
	public int pathv(@PathVariable("num") int n) {
		return n;
	}
	
	@RequestMapping(value="/info",method = RequestMethod.POST)
	public void in(@RequestBody MemberVO vo) {
		System.out.println(vo);
	}
	
	
	
}
