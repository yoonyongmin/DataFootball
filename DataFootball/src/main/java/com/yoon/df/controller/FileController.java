package com.yoon.df.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yoon.df.model.UploadFile;
import com.yoon.df.model.User;
import com.yoon.df.service.FileService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FileController {
	
	@Autowired
	FileService fileService;
	
	@RequestMapping("file/save")
	public String FileSave() {
		return "file/save";
	}
		
	@GetMapping(value = "/api/fileList")
	public Collection<UploadFile> findAll() {
		Collection<UploadFile> list = fileService.findAll();
		System.out.println(list);
		return list;
	}
	
	@PutMapping(value = "/api/fileUpdate")
	public void fileUpdate(@RequestParam(name = "file") MultipartFile file) throws IllegalStateException, IOException  {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		
		String origFilename = file.getOriginalFilename();
		String fileType = origFilename.substring(origFilename.indexOf("."));
		String filename = sdf.format(new Date()) + fileType;
		String filePath = "C:/Users/new/Desktop/YM/Angular/datafooball-project/src/assets/images/" + filename;
		
		file.transferTo(new File(filePath));
		
		UploadFile uploadFile = new UploadFile(origFilename, filename, filePath);
		fileService.updateFile(uploadFile);
	}
	
	
}















