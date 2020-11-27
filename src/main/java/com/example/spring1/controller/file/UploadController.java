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
	
	//get������� ���� ���
	@RequestMapping(value = "/upload",method = RequestMethod.GET)
	public String uploadForm() {
		return "file/uploadform";
	}
	
	//���������� ����
	//@Resource(name = "uploadPath")
	//String uploadPath
	public String uploadPath="C:\\Users\\comon\\Desktop\\upload";
	
	//post������� ���� ���
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public ModelAndView uploadFormm(MultipartFile file,ModelAndView mav) throws IOException, Exception {
		String savedName=file.getOriginalFilename();
		System.out.println("�����̸�: " +savedName);
		System.out.println("����ũ��: "+file.getSize());
		System.out.println("���� ������Ÿ��: " +file.getContentType());
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
		//�ӽ� ���丮�� ����� ���ε�� ������ ������ ���丮�� ����
		FileCopyUtils.copy(fileData,target);
		return savedName;
	}
}
