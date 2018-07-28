package com.zsh.dao;

import java.util.List;

import com.zsh.pojo.DormBuild;
import com.zsh.pojo.DormManager;

public interface DMDao {
	// 根据动态参数查找用户信息
	public List<DormManager> getDormManagerByDynamicWhere(String sql, String[] sqlParams);
	// 查找所有的用户信息
	public List<DormManager> getAllDormManager();
	//修改dormBuildId
	public boolean updateDBIDById(int id,DormManager dm);
	// 根据用户名查找用户信息
	public DormManager getDMByName(String username);

	// 添加用户
	public boolean addDormManager(DormManager dm);
	
	// 根据ID更新指定用户
	public boolean updateDMById(int id,DormManager dm);
	// 根据ID更新指定用户
	public boolean updateDMPWDById(int id,DormManager dm);
	
	// 根据用户名删除指定用户
	public boolean delDMById(int id);
}
