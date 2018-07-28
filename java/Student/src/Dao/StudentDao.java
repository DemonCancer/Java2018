package Dao;

import java.util.List;
import entity.Student;

public interface StudentDao {
		// 查找所有的用户信息
		public List<Student> getAllStudent();

		// 根据用户名查找用户信息
		public Student getStudentByUserName(String username);

		// 根据动态参数查找用户信息
		public List<Student> getStudentByDynamicWhere(String sql, String[] sqlParams);
		
		// 根据ID更新指定用户
		public boolean updateStudentById(int id,Student stu);
		
		// 根据用户名删除指定用户
		public boolean delStudentById(int id);

		// 添加用户
		public boolean addStudent(Student stu);
		/*
		// 根据用户名删除指定用户
		public boolean delStudentByUserName(String username);

		// 根据用户名更新指定用户
		public boolean updateStudentByUserName(String username,User user);*/

}
