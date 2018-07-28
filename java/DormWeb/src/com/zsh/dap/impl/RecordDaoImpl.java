package com.zsh.dap.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.zsh.dao.RecordDao;
import com.zsh.pojo.Record;
import com.zsh.util.DBUtil;

public class RecordDaoImpl extends DBUtil implements RecordDao{

	String  SQL_SELECT= "select recordId,studentNumber,studentName,dormBuildId,date,detail from t_record ";
	String SQL_INSERT = "insert into t_record(studentNumber,studentName,dormBuildId,date,detail) values ( ?, ?, ?, ?, ? )";
	String SQL_UPDATE = "update t_record set "
			+ "studentNumber = ?, studentName = ?, dormBuildId = ? , detail = ?  "
			+ " where recordId = ? ";
	String SQL_DELETE = "delete from t_record where recordId = ?";
	@Override
	public List<Record> getRecordByDynamicWhere(String sql, String[] sqlParams) {
		
		//类名调用，静态方法
		DBUtil.getConnection();
		List<Record> rclist=new ArrayList<Record>();
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		System.out.println(SQL);
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				Record rc=new Record();
				rc.setRecordId(rs.getInt("recordId"));
				rc.setStudentNumber(rs.getString("studentNumber"));
				//rc.setDormName(rs.getString(""));
				rc.setDormBuildId(rs.getInt("dormBuildId"));
				rc.setStudentName(rs.getString("studentName"));
				rc.setDate(rs.getDate("date"));
				rc.setDetail(rs.getString("detail"));
				rclist.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return rclist;
	}

	@Override
	public List<Record> getAllRecord() {
		DBUtil.getConnection();
		List<Record> rclist=new ArrayList<Record>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				Record rc=new Record();
				rc.setRecordId(rs.getInt("recordId"));
				rc.setStudentNumber(rs.getString("studentNumber"));
				//rc.setDormName(rs.getString(""));
				rc.setDormBuildId(rs.getInt("dormBuildId"));
				rc.setStudentName(rs.getString("studentName"));
				rc.setDate(rs.getDate("date"));
				rc.setDetail(rs.getString("detail"));
				rclist.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return rclist;
	}

	@Override
	public Record getRecordByRecordName(String username) {
		
		return null;
	}

	@Override
	public boolean addRecord(Record rc) {
		
		DBUtil.getConnection();
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String dateString = formatter.format(rc.getDate());
		 System.out.println(dateString);
		////创建动态参数
		String[] param={rc.getStudentNumber(),rc.getStudentName(),rc.getDormBuildId()+"",
				dateString,rc.getDetail()};
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
	public boolean updateRecordById(int id, Record rc) {
		DBUtil.getConnection();
		String[] param={rc.getStudentNumber(),rc.getStudentName(),rc.getDormBuildId()+"",
				rc.getDetail(),id+""};
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
	public boolean updateRecordPWDById(int id, Record rc) {
		return false;
	}

	@Override
	public boolean delRecordById(int id) {
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

	@Override
	public List<Record> getAllRecordAndDormName() {
		DBUtil.getConnection();
		List<Record> rclist=new ArrayList<Record>();
		String sql="select r.recordId,r.studentNumber,r.studentName,r.dormBuildId,s.dormName,r.date,r.detail"
				+ " from t_record r left join t_student s on r.studentNumber=s.stuNum ";
		ResultSet rs = this.executeQuery(sql, new String[] {});
		try {
			while (rs.next()){
				Record rc=new Record();
				rc.setRecordId(rs.getInt("recordId"));
				rc.setStudentNumber(rs.getString("studentNumber"));
				rc.setDormName(rs.getString("dormName"));
				rc.setDormBuildId(rs.getInt("dormBuildId"));
				rc.setStudentName(rs.getString("studentName"));
				rc.setDate(rs.getDate("date"));
				rc.setDetail(rs.getString("detail"));
				rclist.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return rclist;
	}

	@Override
	public List<Record> getRecordAndDormNameByDynamicWhere(String sql,
			String[] sqlParams) {
		//类名调用，静态方法
		DBUtil.getConnection();
		List<Record> rclist=new ArrayList<Record>();
		String Sql="select r.recordId,r.studentNumber,r.studentName,r.dormBuildId,s.dormName,r.date,r.detail"
				+ " from t_record r ,t_student s where r.studentNumber=s.stuNum";
		String SQL=Sql+" and 1=1 "+sql;
		System.out.println(SQL);
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				Record rc=new Record();
				rc.setRecordId(rs.getInt("recordId"));
				rc.setStudentNumber(rs.getString("studentNumber"));
				rc.setDormName(rs.getString("dormName"));
				rc.setDormBuildId(rs.getInt("dormBuildId"));
				rc.setStudentName(rs.getString("studentName"));
				rc.setDate(rs.getDate("date"));
				rc.setDetail(rs.getString("detail"));
				rclist.add(rc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return rclist;
	}

}
