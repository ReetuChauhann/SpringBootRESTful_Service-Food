package com.reetu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Food;

public interface Myservice {
	 public String addfood(Food f, MultipartFile image);
	 public List<Food> getsamenamefood(String name);
	 public List<Food> getallfood();
	 public List<Integer> gteallids();
	 public String deletefood(int fid);
	 public byte [] getimage(int fid);
	 public String updatefood(Food f);
	 public String updateimage(int fid, MultipartFile image);

}
