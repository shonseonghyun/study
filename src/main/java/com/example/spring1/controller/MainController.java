package com.example.spring1.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring1.entity.Product;
import com.example.spring1.entity.Student;

@Controller
@RequestMapping("/main")
public class MainController {
	@RequestMapping("/")
	public String main(Model model) {
		System.out.println("�Ե�.");
		model.addAttribute("name", "�ռ���");
		return "main";
	}
	
	
/*�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�RequestParam�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	
	//������
	@RequestMapping("/gugu")
	public String gugudo() {
		System.out.println("gugu");
		return "test/gugu";
	}
	
	@RequestMapping("/guguresult")
	public String gugu_result(@RequestParam int v,Model model) {
		String result="";
		for(int i=1;i<10;i++) {
			result+=v+"x"+i+"="+(v*i)+"<br/>";
		}
		model.addAttribute("value",result);
		return "test/gugu_result";
	}
	
/*�ѤѤѤѤѤѤѤѤѤѤѤ�ModelAttribute�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	
	//����
	@RequestMapping("/point")
	public String point() {
		return "test/point";
	}
	
	@RequestMapping("/pointresult")
	public String pointresult(@ModelAttribute Student st,Model model) {
		st.setTotal(st.getKor()+st.getMath()+st.getCom());
		st.setAvg(st.getTotal()/3);
		model.addAttribute("st", st);
		return "test/point_result";	
	}
	
	/*�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�redirect�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	
	// redirect //
	@RequestMapping("/move")
	public String move() {
		return "redirect:result"; /* /main/move ->/main/result */
	}
	
	@RequestMapping("/result")
	public String result(@RequestParam(defaultValue ="������")  String name,@RequestParam(defaultValue = "10") int age,Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "test/result";
	}
	
	/*�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�ModelAndview�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	@RequestMapping("/mav")
	public ModelAndView mav() {
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("product", new Product("����",1000));
		return new ModelAndView("test/mav", "map", map);
	}
	
	/*�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѺ񵿱�� ȣ�� ajax�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	@RequestMapping("/ajax")
	public String ajax() {
		return "test/ajax";
	}
	
	@RequestMapping("/background")
	public @ResponseBody Product prd() {
		return new Product("����",100);
	}
	
	/*�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѺ񵿱�� ȣ�� ajax�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	@RequestMapping("/ajaxlogin")
	public String loggin() {
		return "test/ajaxlogin";
	}
	@RequestMapping("/backlogin")
	public  String backloggin(String id,String pw,Model model) {
		String result="";
		if(id.equals("son") && pw.equals("1234")) {
			result="ȯ���մϴ�"+id;
		}
		else result="�ùٸ��� ���� ��";
		model.addAttribute("result", result);
		return "test/login_result";
	}
	/*�ѤѤѤѤѤѤѤѤѤѤѤѤѤѱ����� ȣ�� ajax�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	*/	
	@RequestMapping("/ajaxgugu")
	public String gugugu() {
		return "test/ajaxgugu";
	}
	
	@RequestMapping("/ajaxguguresult")
	public String ajaxgugugu(@RequestParam int v,Model model) {
		String result="";
		for(int i=1;i<10;i++) {
			result+=v+"x"+i+"="+(v*i)+"<br/>";
		}
		model.addAttribute("result",result);
		return "test/ajaxgugu_result";
	}
	
	@RequestMapping("/l")
	public String l() {
		return "login";
	}
	
	@RequestMapping("/a")
	public ModelAndView a(@RequestParam String i) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("i", i);
		mav.setViewName("a");
		return mav;
	}
	
}
