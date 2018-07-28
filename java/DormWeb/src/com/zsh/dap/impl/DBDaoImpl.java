package com.zsh.dap.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsh.dao.DBDao;
import com.zsh.pojo.DormBuild;
import com.zsh.util.DBUtil;

public class DBDaoImpl extends DBUtil implements DBDao{
	String  SQL_SELECT= "select dormBuildId,dormBuildName,dormBuildDetail from t_dormbuild ";
	String SQL_INSERT = "insert into t_dormbuild(dormBuildName,dormBuildDetail) values ( ?, ?)";
	String SQL_UPDATE = "update t_dormbuild set "
			+ "dormBuildName = ?, dormBuildDetail = ? "
			+ " where dormBuildId = ? ";
	String SQL_DELETE = "delete from t_dormbuild where dormBuildId = ?";

	@Override
	public List<DormBuild> getDormBuildByDynamicWhere(String sql,
			String[] sqlParams) {
		DBUtil.getConnection();
		List<DormBuild> dblist=new ArrayList<DormBuild>();
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		System.out.println(SQL);
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				DormBuild db=new DormBuild();
				db.setDormBuildId(rs.getInt("dormBuildId"));
				db.setDormBuildName(rs.getString("dormBuildName"));
				db.setDormBuildDetail(rs.getString("dormBuildDetail"));
				dblist.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return dblist;
	}

	@Override
	public List<DormBuild> getAllDormBuild() {
		
		DBUtil.getConnection();
		List<DormBuild> dblist=new ArrayList<DormBuild>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				DormBuild db=new DormBuild();
				db.setDormBuildId(rs.getInt("dormBuildId"));
				db.setDormBuildName(rs.getString("dormBuildName"));
				db.setDormBuildDetail(rs.getString("dormBuildDetail"));
				dblist.add(db);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return dblist;
	}

	@Override
	public boolean addDormBuild(DormBuild db) {
		DBUtil.getConnection();
		////创建动态参数
		String[] param={db.getDormBuildName(),db.getDormBuildDetail()};
		///执行更新，返回int
		int x=this.executeUpdate(SQL_INSERT,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}	
	}

	@Override
	public boolean updateDBById(int id, DormBuild db) {
		DBUtil.getConnection();
		String[] param={db.getDormBuildName(),db.getDormBuildDetail(),id+""};
		int x=this.executeUpdate(SQL_UPDATE,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean delDBById(int id) {
		DBUtil.getConnection();
		String[] param={id+""};
		int x=this.executeUpdate(SQL_DELETE,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}

}
