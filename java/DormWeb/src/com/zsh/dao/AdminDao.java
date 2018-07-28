package com.zsh.dao;

import java.util.List;

import com.zsh.pojo.Admin;

public interface AdminDao{
	// 根据动态参数查找用户信息
	public List<Admin> getAdminByDynamicWhere(String sql, String[] sqlParams);
	
	// 查找所有的用户信息
	public List<Admin> getAllAdmin();

	// 根据用户名查找用户信息
	public Admin getAdminByAdminName(String username);

	// 添加用户
	public boolean addAdmin(Admin Admin);
	
	// 根据ID更新指定用户
	public boolean updateAdminById(int id,Admin Admin);
	// 根据ID更新指定用户
	public boolean updateAdminPWDById(int id,Admin Admin);
	
	// 根据用户名删除指定用户
	public boolean delAdminById(int id);

}
