package Dao;

import java.util.List;

import entity.Profession;

public interface ProfessionDao {
	// 查找所有的用户信息
	public List<Profession> getAllProfession();
	//// 根据ID更新指定用户
	public boolean updateProById(int id,Profession pro);
	// 添加用户
	public boolean addProfession(Profession pro);
	// 根据用户名删除指定用户
	public boolean delProById(int id);
}
