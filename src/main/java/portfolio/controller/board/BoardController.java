package portfolio.controller.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import portfolio.dto.board.BoardDTO;
import portfolio.dto.board.PageMaker;
import portfolio.service.board.PfBoardService;

@Controller
@RequestMapping("/pf/board")
public class BoardController {
	
	@Autowired
	PfBoardService service;

	@RequestMapping("")
	public ModelAndView pfboard(ModelAndView mav,
			@RequestParam(defaultValue = "1")int page,
			@RequestParam(defaultValue = "title") String f,
			@RequestParam(defaultValue = "") String q
			){
		
		int count=service.countboard(f,q);
		PageMaker pagemaker=new PageMaker(count,page);
		mav.addObject("p",pagemaker );
		
		List<BoardDTO> list=service.getAllboard(page,f,q);
		mav.addObject("list", list);
		mav.setViewName("pf/board/board");
		return mav;
	}
	
	@RequestMapping(value= "/write",method = RequestMethod.GET)
	public String pfboardwrite() {
		return "pf/board/board_wirte";
	}
	
	@RequestMapping(value= "/write",method = RequestMethod.POST)
	public String pfboardwritep(@ModelAttribute BoardDTO dto,HttpSession session,@RequestParam MultipartFile file) {
		dto.setFiles(file.getName());
		String id=(String) session.getAttribute("id");
		dto.setWriter_id(id);
		service.WriteBoard(dto);
		return "redirect:/pf/board";
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int id) {
		System.out.println(service.getboard(id));
		return null;
	}
	
	
}
