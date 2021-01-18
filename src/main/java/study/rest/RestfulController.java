package study.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import oracle.net.aso.m;
import portfolio.dto.board.BoardDTO;
import portfolio.dto.board.PageMaker;
import portfolio.service.board.PfBoardService;

@RestController
@RequestMapping("/test/")
public class RestfulController {

	
	@RequestMapping("hello")
	public String hellooo() {
		System.out.println("asd");
		return "hello";
	}
	
	@RequestMapping("user")
	public Mem userr() {
		Mem m=new Mem();
		m.setId("sonny");
		m.setName("아무개");
		m.setAge(11);
		m.setEmail("213@naver.cim");
		return m;
	}
	
	@RequestMapping("user/map")
	public Map<Integer,Mem> userrr() {
		Map<Integer,Mem> map=new HashMap<Integer, Mem>();
		
		for(int i=0;i<10;i++) {
			Mem m=new Mem();
			m.setId("sonny");
			m.setName("아무개");
			m.setAge(11);
			m.setEmail("213@naver.cim");
			map.put(i, m);
		}
		return map;
	}
	
	@RequestMapping(value="notice/{num}")
	public int s(@PathVariable("num") int num) {
		return num;
	}
	
	
	
	@Autowired
	PfBoardService service;
	
	//json형식으로 데이터 내보내기
	@RequestMapping("board")
	public List<BoardDTO> pfboard(ModelAndView mav,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "title") String f,
			@RequestParam(defaultValue = "") String q
			){
		int count=service.countboard(f,q);
		PageMaker pagemaker=new PageMaker(count,page);
		mav.addObject("p",pagemaker );
		List<BoardDTO> list=service.getAllboard(page,f,q);
		return list;
	}
	
	//
	@RequestMapping("info")
	//@RequestBody는 json으로 전송된 데이터를 특정객체의 속성에 자동으로 설정해준다.
	public Mem asdasd(@RequestBody Mem mem) {
//		System.out.println(mem);
		return mem;
	}
	
	@RequestMapping("memberlist2")
	public ResponseEntity<List<Mem>> listmember2(){
		
		List<Mem> list =new ArrayList<>();
		
		for(int i=0;i<2;i++) {
			Mem m=new Mem();
			m.setId("sonny");
			m.setName("아무개"+i);
			m.setAge(11);
			m.setEmail("213@naver.cim");
			list.add(m);
		}
		return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping("study/entityy")
	public ResponseEntity<String> entity(){
		System.out.println("ss");
		return new ResponseEntity("study/echoinput", HttpStatus.ACCEPTED);
	}
	
}

