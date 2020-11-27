package com.example.spring1.controller.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	
	//get방식으로 들어올 경우
	@RequestMapping(value = "/upload",method = RequestMethod.GET)
	public String uploadForm() {
		return "file/uploadform";
	}
	
	//공통적으로 사용시
	//@Resource(name = "uploadPath")
	//String uploadPath
	public String uploadPath="C:\\Users\\comon\\Desktop\\upload";
	
	//post방식으로 들어올 경우
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public ModelAndView uploadFormm(MultipartFile file,ModelAndView mav) throws IOException, Exception {
		String savedName=file.getOriginalFilename();
		System.out.println("파일이름: " +savedName);
		System.out.println("파일크기: "+file.getSize());
		System.out.println("파일 컨텐츠타입: " +file.getContentType());
		savedName=uploadFile(savedName,file.getBytes());
		mav.setViewName("file/upload_result");
		mav.addObject("savedName", savedName);
		return mav;
	}
	
	private String uploadFile(String filename,byte[] fileData) throws Exception {
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString()+"_"+filename;
		File savedDir=new File(uploadPath);
		if(!savedDir.exists()) savedDir.mkdir();
		File target=new File(uploadPath, savedName);
		//임시 디렉토리에 저장된 업로드된 파일을 지정된 디렉토리에 복사
		FileCopyUtils.copy(fileData,target);
		return savedName;
	}
}
