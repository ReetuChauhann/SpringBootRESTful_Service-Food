package com.reetu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Food;

@Repository
public class FoodRepo {
	                    @Autowired
	                    JdbcTemplate jdbctemplate;
	                    
	                    //to add food
	                    public String addfood(Food f, MultipartFile image) {
	                    	try {
	                    		String query="insert into fooddetail values(?,?,?,?)";
		                    	int x= jdbctemplate.update(query, new Object[] {f.getFid(), f.getName(), f.getPrice(), image.getInputStream()});
		                    	if(x!=0) {
		                    		return "success";
		                    	}else {
		                    		return "failed";
		                    	}
								
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
								return "failed";
							}
	                    	
	                    }
	                    
	                    // to get like name
	                    public List<Food> getsamenamefood(String name){
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									Food f = new Food();
									f.setFid(rs.getInt("fid"));
									f.setName(rs.getString("name"));
									f.setPrice(rs.getInt("price"));
									return f;
								}
	                    		
	                    	}
	                    	try {
	                    		  final String query = "select * from fooddetail where name like?";
	                    		  List<Food> f=jdbctemplate.query(query, new DataMapper(), new Object[] {"%"+name+"%"});
	                    		  return f;
								
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}
	                    }
	                    
	                    //to get all clothes
	                    public List<Food> getallfood(){
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									Food f= new Food();
									f.setFid(rs.getInt("fid"));
									f.setName(rs.getString("name"));
									f.setPrice(rs.getInt("price"));
									return f;
									
								}
	                    		
	                    	}
	                    try {
	                    	  final String query="select * from fooddetail";
	                    	  List<Food> f = jdbctemplate.query(query, new DataMapper());
	                    	  return f;
							
						} catch (Exception e) {
							e.printStackTrace();
						    return null;
						}
	                   }
	                    
	                   //get all ids only
	                    public List<Integer> gteallids(){
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									
									return rs.getInt("fid");
								}
	                    		
	                    	}
	                    	try {
	                    		final String query="select fid from fooddetail";
	                    		List<Integer> ids=jdbctemplate.query(query, new DataMapper());
	                    		return ids;
								
							} catch (Exception e) {
								e.printStackTrace();
								return null;
							}
	                    }
	                    
	                    //delete food by ids
	                    public String deletefood(int fid) {
	                    	try {
	                    		 String query="delete from fooddetail where fid=?";
	                    		 int x=jdbctemplate.update(query, new Object[] {fid});
	                    		 if(x!=0) {
	                    			 return "success";
	                    		 }else {
	                    			 return "failed";
	                    		 }
								
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
					}
	                    }
	                    
	                   //get image
	                    public byte [] getimage(int fid) {
	                    	class DataMapper implements RowMapper{

								@Override
								public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
									
									return rs.getBytes("image");
								}
	                    		
	                    	}
	                    try {
							  String query="select image from fooddetail where fid=?";
							  byte [] b = (byte []) jdbctemplate.queryForObject(query, new DataMapper(), new Object[] {fid});
							  return b;
							  
						} catch (Exception e) {
							e.printStackTrace();
							return null;
						}
	                    }
	                    
	                    //update food
	                    public String updatefood(Food f) {
	                    	try {
	                    		String query = "update fooddetail set name=?, price=? where fid=?";
	                    		int x=jdbctemplate.update(query, new Object[] {f.getName(), f.getPrice(), f.getFid()});
	                    		if(x!=0) {
	                    			return "success";
	                    		}else {
	                    			return "failed";
	                    		}
								
							} catch (Exception e) {
								e.printStackTrace();
								return "failed";
							}
	                    }
	                    
	                    //updateimage
	                    public String updateimage(int fid, MultipartFile image) {
	                    	try {
	                    		  String query="update fooddetail set image=? where fid=?";
	                    		  int x = jdbctemplate.update(query, new Object[] {image.getInputStream(), fid});
								
	                    		  if(x!=0) {
		                    			return "success";
		                    		}else {
		                    			return "failed";
		                    		}
									
								} catch (Exception e) {
									e.printStackTrace();
									return "failed";
								}
	                    }

}
