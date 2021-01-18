package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import study.rest.Mem;

@Controller(value="StudtController")
public class HomeController {
	
	
	@RequestMapping("/echo")
	public String v() {
		return "study/echoinput";
	}
	
	@RequestMapping(value = "/echoouput",method = RequestMethod.POST)
	public ModelAndView vv(EchoForm f) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("f",f);
		mav.setViewName("study/echoouput");
		return mav;
	}
	
	
	@RequestMapping("a/{id}")
	public String s(@PathVariable("id") String id,Model model) {
		System.out.println(id);
		model.addAttribute("id", id);
		return "study/id";
	}
	
	@RequestMapping(value="/checkbox",method = RequestMethod.GET)
	public String checkbox() {
		return "study/checkbox";
	}
	
	@RequestMapping(value="/checkbox",method = RequestMethod.POST)
	public void checkbox1(@RequestParam String[] fruit) {
		List<String> a=new ArrayList<>(Arrays.asList(fruit));
		for(String i:a)System.out.println(i);
	}
	
	
	@RequestMapping(value="/frm",method = RequestMethod.GET)
	public String frm(@ModelAttribute UserVO uservo) {
		return "study/frm";
	}
	
	@RequestMapping(value="/frm",method = RequestMethod.POST)
	public String frmf(@ModelAttribute @Valid UserVO uservo,BindingResult result) {
		if(result.hasErrors()) {
//			List<ObjectError> list=result.getAllErrors();
//			for(ObjectError o:list) System.out.println(o);
			return "study/frm";
		}
		return "study/checkbox";
	}
	
	
	
	
	//validationy검사
	@RequestMapping(value="/hh",method = RequestMethod.GET)
	public String hh(@ModelAttribute MemberDTO dto) {
		return "study/hh";
	}
	
	@RequestMapping(value="/hh",method = RequestMethod.POST)
	public String gg(@ModelAttribute @Valid MemberDTO dto,BindingResult result) {
		if(result.hasErrors()) {
			List<ObjectError> list=result.getAllErrors();
			return "study/hh";
		}
		return "study/gg";
	}
	
	
	@RequestMapping("/study")
	public String sud() {
		return "rest/rest";
	}
	
	
	
	@RequestMapping("/study/hard")
	public List<Mem> ssasdasd() {

		List<Mem> list =new ArrayList<>();
		for(int i=0;i<2;i++) {
			Mem m=new Mem();
			m.setId("sonny");
			m.setName("아무개"+i);
			m.setAge(11);
			m.setEmail("213@naver.cim");
			list.add(m);
		}
		return list;
	}
	
	@RequestMapping("/study/hardd")
	@ResponseBody
	public List<Mem> ssassddasd() {

		List<Mem> list =new ArrayList<>();
		for(int i=0;i<2;i++) {
			Mem m=new Mem();
			m.setId("sonny");
			m.setName("아무개"+i);
			m.setAge(11);
			m.setEmail("213@naver.cim");
			list.add(m);
		}
		return list;
	}
	
		
	@RequestMapping("/study/entity")
	public ResponseEntity entitys(){
		HttpHeaders h= new HttpHeaders();
		h.add("Content-Type", "text/html; charset=utf-8");
		String message="<script>";
		message+="alert('새 회원을 등록합니다');";
		message+="location.href='/test/memberlist2'";
		message+="</script>";
		
		return new ResponseEntity(message,h,HttpStatus.CREATED);
	}
	
	
	//모든 글 가져오기
	@RequestMapping(value="/bboard/all",method = RequestMethod.GET)
	public ResponseEntity<List<ArticelVo>> getAllBoard(){
		//일단 임시로 생성했다.
		//우리가 만든 service를 가져와 꽂아넣어 활용하면 된다.
		List<ArticelVo> list= new ArrayList<ArticelVo>();
		for(int i=0;i<10;i++) {
			ArticelVo article=new ArticelVo();
			article.setArticleNo(i);
			article.setWriter("작성자");
			article.setTitle("제목");
			list.add(article);
		}
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	
	//특정 글 가져오기
	@RequestMapping(value="/bboard/{number}",method = RequestMethod.GET)
	public ResponseEntity<ArticelVo> getboardd(@PathVariable("number") int number){
		//일단 임시로 생성
		ArticelVo article=new ArticelVo();
		article.setArticleNo(number);
		article.setWriter("작성자");
		article.setTitle("제목");
		return new ResponseEntity(article, HttpStatus.OK);
	}
	
	//글쓰기
	//1. 글 쓰는 폼 보여주기
	@RequestMapping(value="/bboard/" ,method = RequestMethod.GET)
	public String boardwritefrm() {
		return "rest/write"; 	
	}
	
	//2.받아온 데이터 출력
	@RequestMapping(value="/bboard")
	public ResponseEntity<String> boardwrite(@RequestBody ArticelVo article){
		ResponseEntity<String> res=null;
		try {
			System.out.println(article);
			res=new ResponseEntity<String>("succeed", HttpStatus.OK);
		}catch (Exception e) {
			res=new ResponseEntity<String>("Bad request", HttpStatus.BAD_REQUEST);
		}
		return res;
	}
	
	
	@RequestMapping("/redirect1")
	public String getredi(RedirectAttributes re) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("p", "redirec1");
		map.put("w", "redirec2");
		re.addFlashAttribute("map", map);
		return "redirect:/redirect2";
	}
	
	@RequestMapping("/redirect2")
	public String getre() {
//		System.out.println(p);
//		System.out.println(w);
		return "test/redirect";
	}
	
	
		

}
