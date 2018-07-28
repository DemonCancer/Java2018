package com.zsh.dao;

import java.util.List;

import com.zsh.pojo.Dorm;

public interface DormDao {
	// 根据动态参数查找用户信息
		public List<Dorm> getDormByDynamicWhere(String sql, String[] sqlParams);
		// 查找所有的用户信息
		public List<Dorm> getAllDorm();

		// 根据用户名查找用户信息
		public Dorm getDormByName(String username);

		// 添加用户
		public boolean addDorm(Dorm dm);
		
		// 根据ID更新指定用户
		public boolean updateDormById(int id,Dorm dm);
		
		// 根据用户名删除指定用户
		public boolean delDormById(int id);
}
