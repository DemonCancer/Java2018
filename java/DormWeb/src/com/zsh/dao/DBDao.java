package com.zsh.dao;

import java.util.List;

import com.zsh.pojo.DormBuild;
import com.zsh.pojo.DormBuild;

public interface DBDao {
	// 根据动态参数查找用户信息
		public List<DormBuild> getDormBuildByDynamicWhere(String sql, String[] sqlParams);
		// 查找所有的用户信息
		public List<DormBuild> getAllDormBuild();
		
		// 添加用户
		public boolean addDormBuild(DormBuild db);
		
		// 根据ID更新指定用户
		public boolean updateDBById(int id,DormBuild db);
		
		// 根据用户名删除指定用户
		public boolean delDBById(int id);
}
