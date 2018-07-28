package com.zsh.dao;

import java.util.List;

import com.zsh.pojo.Record;



public interface RecordDao {

		// 根据动态参数查找用户信息
		public List<Record> getRecordByDynamicWhere(String sql, String[] sqlParams);
		// 根据动态参数查找用户信息
		public List<Record> getRecordAndDormNameByDynamicWhere(String sql, String[] sqlParams);
		
		// 查找所有的用户信息
		public List<Record> getAllRecord();
		
		// 查找所有的用户信息
		public List<Record> getAllRecordAndDormName();

		// 根据用户名查找用户信息
		public Record getRecordByRecordName(String username);

		// 添加用户
		public boolean addRecord(Record Record);
		
		// 根据ID更新指定用户
		public boolean updateRecordById(int id,Record Record);
		// 根据ID更新指定用户
		public boolean updateRecordPWDById(int id,Record Record);
		
		// 根据用户名删除指定用户
		public boolean delRecordById(int id);
}
