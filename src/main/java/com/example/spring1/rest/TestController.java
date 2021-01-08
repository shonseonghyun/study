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

//jsp���� �並 ��ȯ�ϴ� ���� �ƴ϶� JSON,XML ���� �����͸� �������� �����ϴ� ��Ʈ�ѷ��� @Restcontroller�� ����
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
		vo.setName("�ռ���");
		vo.setEmail("@naver.com");
		vo.setPwd("7895");
		return vo;
	} //MemberVO ��ü�� �Ӽ� ���� ������ �� JSON���� ����
	
	@RequestMapping("/memberlist")
	public List<MemberVO> memberlist(){
		List<MemberVO> list=new ArrayList<MemberVO>();
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("son"+i);
			vo.setName("�ռ���"+i);
			vo.setEmail("@naver.com"+i);
			vo.setPwd("7895"+i);
			list.add(vo);
		}
		return list;
	}//List���� �÷����� JSON���� ����� ����
	
	@RequestMapping("/membermap")
	public Map<Integer,MemberVO> memberMap(){
		Map<Integer,MemberVO> map=new HashMap<>();
		for(int i=0;i<10;i++) {
			MemberVO vo=new MemberVO();
			vo.setId("son"+i);
			vo.setName("�ռ���"+i);
			vo.setEmail("@naver.com"+i);
			vo.setPwd("7895"+i);
			map.put(i, vo);
		}
		return map;
	}//Map�� ����� ������ ����
	
	@RequestMapping("/notice/{num}")
	public int pathv(@PathVariable("num") int n) {
		return n;
	}
	
	@RequestMapping(value="/info",method = RequestMethod.POST)
	public void in(@RequestBody MemberVO vo) {
		System.out.println(vo);
	}
	
	
	
}
