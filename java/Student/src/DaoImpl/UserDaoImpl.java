package DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import Dao.UserDao;
import util.DBUtil;

public class UserDaoImpl extends DBUtil implements UserDao{
	String  SQL_SELECT= "select id,username,userpass,role from userdetail ";
	String SQL_INSERT = "insert into userdetail(username,userpass,role) values ( ?, ?, ? )";
	String SQL_UPDATE = "update userdetail set "
			+ "username = ?, userpass = ?, role = ? "
			+ " where id = ? ";
	String SQL_DELETE = "delete from userdetail where id = ?";

	@Override
	public List<User> getAllUser() {
		DBUtil.getConnection();
		List<User> userList=new ArrayList<User>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setRole(rs.getBoolean("role"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return userList;
	}

	@Override
	public User getUserByUserName(String username) {
		
		return null;
	}

	@Override
	public List<User> getUserByDynamicWhere(String sql, String[] sqlParams) {
		DBUtil.getConnection();
		List<User> userList=new ArrayList<User>();
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		System.out.println(SQL);
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				User user=new User();
				user.setRole(rs.getBoolean("role"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return userList;
	}

	@Override
	public boolean addUser(User user) {
		DBUtil.getConnection();
		String[] param={user.getUsername(),user.getUserpass(),0+""};
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
	public boolean updateUserById(int id, User user) {
		
		DBUtil.getConnection();
		int role;
		if(user.isRole()==true){
			role=1;
		}else{
			role=0;
		}
		String[] param={user.getUsername(),user.getUserpass(),role+"",id+""};
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
	public boolean delUserById(int id) {
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
