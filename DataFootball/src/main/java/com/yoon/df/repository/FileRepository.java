package com.yoon.df.repository;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yoon.df.model.UploadFile;
import com.yoon.df.model.User;

@Repository
public interface FileRepository extends JpaRepository<UploadFile, Integer> {


}
