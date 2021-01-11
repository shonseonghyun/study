package portfolio.controller.board;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	//저장경로
	private String uploadpath="C:\\Users\\comon\\Documents\\workspace-spring-tool-suite-4-4.8.1.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\study\\WEB-INF\\resources\\images\\pf";
	
	@RequestMapping(value= "/write",method = RequestMethod.POST)
	public String pfboardwritep(@ModelAttribute BoardDTO dto,HttpSession session,RedirectAttributes rttr,@RequestParam MultipartFile file) throws Exception {
		//file의 고유이름 가져오기
		String savedfilename=file.getOriginalFilename();
		//uploadFile을 구현하기
		savedfilename=uploadFile(savedfilename,file.getBytes());
		//BoardDTO dto에 넣기
		dto.setFiles(savedfilename);
		//이 부분은 여기서 다루진 않지만 세션의 value값을 가져온 후 
		String id=(String) session.getAttribute("id");
		//BoardDTO dto에 넣기
		dto.setWriter_id(id);
		//WrtieBoard method 호출
		service.WriteBoard(dto);
		return "redirect:/pf/board";
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(@RequestParam int id,ModelAndView mav) {
		mav.addObject("detail", service.getboard(id));
		mav.setViewName("pf/board/board_detail");
		return mav;
	}
	
	
	private String uploadFile(String filename,byte[] fileData) throws Exception {
		UUID uid=UUID.randomUUID();
		String savedname=uid.toString()+"_"+filename;
		File savedDir=new File(uploadpath);
		if(!savedDir.exists()) savedDir.mkdirs();
		File target=new File(uploadpath,savedname);
		FileCopyUtils.copy(fileData, target);
		return savedname;
	}
	
	
	//게시판 글 삭제
	@RequestMapping("/delete")
	public String deleteboard(@RequestParam int id) {
		System.out.println(id);
		service.deleteboard(id);
		return "redirect:/pf/board";
	}
	
}
