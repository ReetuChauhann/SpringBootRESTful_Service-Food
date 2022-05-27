package com.reetu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Food;
import com.reetu.dao.FoodRepo;

@Service
public class service1 implements Myservice {
	                                          @Autowired
	                                          FoodRepo   fr;

	@Override
	public String addfood(Food f, MultipartFile image) {
		// TODO Auto-generated method stub
		return fr.addfood(f, image);
	}

	@Override
	public List<Food> getsamenamefood(String name) {
		// TODO Auto-generated method stub
		return fr.getsamenamefood(name);
	}

	@Override
	public List<Food> getallfood() {
		// TODO Auto-generated method stub
		return fr.getallfood();
	}

	@Override
	public List<Integer> gteallids() {
		// TODO Auto-generated method stub
		return fr.gteallids();
	}

	@Override
	public String deletefood(int fid) {
		// TODO Auto-generated method stub
		return fr.deletefood(fid);
	}

	@Override
	public byte[] getimage(int fid) {
		// TODO Auto-generated method stub
		return fr.getimage(fid);
	}

	@Override
	public String updatefood(Food f) {
		// TODO Auto-generated method stub
		return fr.updatefood(f);
	}

	@Override
	public String updateimage(int fid, MultipartFile image) {
		// TODO Auto-generated method stub
		return fr.updateimage(fid, image);
	}

}
