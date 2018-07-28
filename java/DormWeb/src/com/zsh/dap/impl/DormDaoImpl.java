package com.zsh.dap.impl;

import java.util.List;

import com.zsh.dao.DormDao;
import com.zsh.pojo.Dorm;
import com.zsh.util.DBUtil;

public class DormDaoImpl extends DBUtil implements DormDao{

	@Override
	public List<Dorm> getDormByDynamicWhere(String sql, String[] sqlParams) {
		return null;
	}

	@Override
	public List<Dorm> getAllDorm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dorm getDormByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDorm(Dorm dm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDormById(int id, Dorm dm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delDormById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
