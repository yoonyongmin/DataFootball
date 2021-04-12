package com.yoon.df.service;

import java.io.File;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yoon.df.model.UploadFile;
import com.yoon.df.model.User;
import com.yoon.df.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	FileRepository fileRepository;
	
	
	public Collection<UploadFile> findAll() {
		Collection<UploadFile> list = fileRepository.findAll();
		return list;
	}
	
	public void deleteFile(MultipartFile file) {
		fileRepository.deleteAll();
	}
	
	public void updateFile(UploadFile uploadFile) {
		fileRepository.save(uploadFile);
	}

	@Transactional
	public UploadFile save(UploadFile uploadFile) {
		fileRepository.save(uploadFile);
		return uploadFile;
	}
}
