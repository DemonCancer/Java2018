package com.zsh.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zsh.pojo.Admin;

public class TestJson {

	public static void main(String[] args) {
		
		List<Admin> list = new ArrayList<>();
		for(int i = 0; i<5; i++){
			Admin admin = new Admin();
			admin.setName(i + "");
			list.add(admin);
		}
		
//		Map<String, List> map = new HashMap<String, List>();
//		map.put("data", list);
		
		String json = JSON.toJSONString(list);
		System.out.println(json);
		
		
		List<Admin> list2 = JSON.parseArray(json, Admin.class);
		for (Admin admin : list2) {
			System.out.println(admin.getName());
		}
		
	}
	
}
