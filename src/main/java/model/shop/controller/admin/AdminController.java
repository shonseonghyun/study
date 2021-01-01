package model.shop.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.shop.dto.member.MemberDTO;
import model.shop.dto.product.ProductDTO;
import model.shop.service.admin.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@RequestMapping(value="/admin/logindo",method = RequestMethod.GET)
	public String logindodo() {
		return "admin/dologin";
	}
	
	@RequestMapping(value="/admin/logindo",method = RequestMethod.POST)
	public ModelAndView logingdod(@ModelAttribute MemberDTO admin,HttpSession session) {
		String name=adminservice.login_check(admin);
		ModelAndView mav=new ModelAndView();
		if(name!=null) {
			session.setAttribute("name","관리자");
			session.setAttribute("id", admin.getId());
			mav.setViewName("redirect:/shop/product/list");
			return mav;
		}
		else {
			mav.setViewName("admin/dologin");
			mav.addObject("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return mav;
		}
	}
	
	@RequestMapping(value="/shop/product/admin/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int id,ModelAndView mav) {
		ProductDTO product=adminservice.detailProduct(id);
		
		mav.addObject("detail", product);
		mav.setViewName("admin/product_detail_edit");
		return mav;
	}
	
	@RequestMapping(value="/shop/product/admin/edit",method = RequestMethod.POST)
	public String modify(@ModelAttribute ProductDTO product,@RequestParam MultipartFile file) {
		String uploadpath="C:\\Users\\comon\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\study\\WEB-INF\\resources\\images";
		String beforefilename=adminservice.file_name(product.getProduct_id());
		//있던 파일 삭제 
		File beforefile=new File(uploadpath, beforefilename);
		if(beforefile.exists()) {beforefile.delete();}
		
		//새로 올라온 파일 저장
		String filename=file.getOriginalFilename();
		File savedfile=new File(uploadpath,filename);
		try {
			FileCopyUtils.copy(file.getBytes(), savedfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		product.setPicture_url(filename);
		System.out.println(product);
		adminservice.update(product);
		return "redirect:/shop/product/list";
	}

	
	
	
}
