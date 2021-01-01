package model.shop.controller.product;



import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.shop.dto.product.ProductDTO;
import model.shop.service.product.ProductSerivce;


@Controller //현재 클래스를 스프링에서 관리하는 Controller Bean으로 설정
@RequestMapping("/shop/product")
public class ProductController {
	
	@Autowired //의존관계
	ProductSerivce productservice; //스프링에서 만든 서비스 객체를 연결
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		mav.setViewName("shop/product_list");
		mav.addObject("list", productservice.listProduct()); //데이터 저장
		return mav; //페이지 이동 및 오브젝트전달
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(ModelAndView mav,@RequestParam int id) {
		mav.addObject("detail", productservice.detailProduct(id));
		mav.setViewName("shop/product_detail");
		return mav;
	}
	
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String register() {
		return "shop/product_register";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String registerr(@ModelAttribute ProductDTO product,MultipartFile file) throws IOException {
		String url=file.getOriginalFilename();
		product.setPicture_url(url);
		String uploadpath="C:\\Users\\comon\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\study\\WEB-INF\\resources\\images";
		File target=new File(uploadpath,url);
		//파일의 내용,파일의위치와이름
		FileCopyUtils.copy(file.getBytes(),target );
		productservice.insertProduct(product);
		return "redirect:/shop/product/list";
	}
}
 