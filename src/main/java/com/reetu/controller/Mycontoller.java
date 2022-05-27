package com.reetu.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Food;
import com.reetu.service.Myservice;

@RestController
public class Mycontoller {
	
	                        @Autowired
	                         Myservice  service;
	                        
	                    @RequestMapping("/")
	                    public String home() {
	                    	return "Welcome Honey";
	                    }
	                    
	                    @GetMapping("/getallFood")
	                    public List<Food> getallfood(){
	                    	List<Food> f = service.getallfood();
	                    	return f;
	                    }
	                    
	                    @GetMapping("/samename/{name}")
	                    public List<Food> getsamename(@PathVariable("name") String name){
	                    	List<Food> f= service.getsamenamefood(name);
	                    	return f;
	                    }
	                    
	                    @PostMapping("/addFood")
	                    public ResponseEntity<String> addfood(@RequestPart("image") MultipartFile image, @RequestPart("Food") Food f) {
	                    	String s = service.addfood(f, image);
	                    	if(s=="success") {
	                    		return new ResponseEntity<String>(s, HttpStatus.OK);
	                    	}else {
	                    		return new ResponseEntity<String>(s, HttpStatus.NOT_MODIFIED);
	                    	}
	                    }
	                    
	                    @GetMapping("/getallids")
	                    public List<Integer> getallids(){
	                    	List<Integer> l = service.gteallids();
	                    	return l;
	                    }
	                    
	                    @PutMapping("/update")
	                    public String updatefood(@RequestBody Food f) {
	                    	String s= service.updatefood(f);
	                    	if(s=="success") {
	                    		return "Success";
	                    	}else {
	                    		return "Failed";
	                    	}
	                    	
	                    }
	                    
	                    @DeleteMapping("delete/{fid}")
	                    public String delete(@PathVariable("fid") int fid) {
	                    	String s = service.deletefood(fid);
	                    	if(s=="success") {
	                    		return "Success";
	                    	}else {
	                    		return "Failed";
	                    	}
	                    }
	                    
	                    @GetMapping("/getImage/{fid}")
	                    public byte [] getphoto(@PathVariable("fid") int fid) {
	                    	byte [] b = service.getimage(fid);
	                    	if(b!=null) {
	                    		return b;
	                    	}else {
	                    		return null;
	                    	}
	                    }
	                    
	                    @PutMapping("/updateImage")
	                    public ResponseEntity<String> updateimage(@RequestPart("fid") int fid, @RequestPart("image") MultipartFile image){
	                    	String r=service.updateimage(fid, image);
	                    	if(r=="success") {
	                    		return new ResponseEntity<String>(r,HttpStatus.OK);
	                    	}else {
	                    		return new ResponseEntity<String>(r, HttpStatus.NOT_MODIFIED);
	                    	}
	                    }
	                    
}
