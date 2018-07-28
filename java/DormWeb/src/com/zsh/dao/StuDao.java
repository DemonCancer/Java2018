package com.zsh.dao;

import java.util.List;

import com.zsh.pojo.Student;

public interface StuDao {
	// 根据动态参数查找用户信息
	public List<Student> getStudentByDynamicWhere(String sql, String[] sqlParams);
	// 查找所有的用户信息
	public List<Student> getAllStudent();

	// 根据用户名查找用户信息
	public List<Student> getStuByNumer(String num);

	// 添加用户
	public boolean addStudent(Student stu);
	
	// 根据ID更新指定用户
	public boolean updateStuById(int id,Student stu);
	// 根据ID更新指定用户
	public boolean updateStuPWDById(int id,Student stu);
	
	// 根据用户名删除指定用户
	public boolean delStuById(int id);
}
