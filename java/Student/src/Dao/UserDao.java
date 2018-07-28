package Dao;

import java.util.List;

import entity.User;


public interface UserDao {
	// 查找所有的用户信息
	public List<User> getAllUser();

	// 根据用户名查找用户信息
	public User getUserByUserName(String username);

	// 根据动态参数查找用户信息
	public List<User> getUserByDynamicWhere(String sql, String[] sqlParams);
	// 添加用户
	public boolean addUser(User user);
	// 根据ID更新指定用户
	public boolean updateUserById(int id,User user);
	// 根据用户名删除指定用户
	public boolean delUserById(int id);

}
