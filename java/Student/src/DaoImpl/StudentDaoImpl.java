package DaoImpl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import Dao.StudentDao;
import util.DBUtil;

public class StudentDaoImpl extends DBUtil implements StudentDao {
	String  SQL_SELECT= "select "
			+ "id,username,userpass,userno,role,age,sex,birthday,profession "
			+ "from studetail";
	String SQL_UPDATE = "update studetail set "
			+ "userno = ?, username = ?, userpass = ?, age = ?, sex= ?,"
			+ "  birthday= ?, profession=? "
			+ " where id = ? ";
	String SQL_DELETE = "delete from studetail where id = ?";
	String SQL_INSERT = "insert into "
			+ "studetail(userno,username,userpass,age,sex,birthday,profession,role)"
			+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
	
	/*String SQL_SELECT="SELECT `id`, `role`, `userno`, `username`, `userpass`, `age`, `sex`, `birthday`, `profession` "
			+ "FROM `userdetail`";*/

	//获取所有学生
	@Override
	public List<Student> getAllStudent() {
		DBUtil.getConnection();
		List<Student> stuList=new ArrayList<Student>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				//实例化stu对象
				Student stu=new Student();
				//将从数据库查询到的信息封装到stu对象里
				stu.setId(rs.getInt("id"));
				stu.setRole(rs.getBoolean("role"));
				stu.setUserno(rs.getString("userno"));
				stu.setUsername(rs.getString("username"));
				stu.setUserpass(rs.getString("userpass"));
				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getBoolean("sex"));
				stu.setBirthday(rs.getDate("birthday"));
				stu.setProfession(rs.getString("profession"));
				//将stu对象的信息放到stuList里
				stuList.add(stu);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		
		return stuList;
	}

	@Override
	public Student getStudentByUserName(String username) {
		
		return null;
	}
	//动态条件查询
	@Override
	public List<Student> getStudentByDynamicWhere(String sql, String[] sqlParams) {
		DBUtil.getConnection();
		List<Student> stuList=new ArrayList<Student>();
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				//实例化stu对象
				Student stu=new Student();
				//将从数据库查询到的信息封装到stu对象里
				stu.setId(rs.getInt("id"));
				stu.setRole(rs.getBoolean("role"));
				stu.setUserno(rs.getString("userno"));
				stu.setUsername(rs.getString("username"));
				stu.setUserpass(rs.getString("userpass"));
				stu.setAge(rs.getInt("age"));
				stu.setSex(rs.getBoolean("sex"));
				stu.setBirthday(rs.getDate("birthday"));
				stu.setProfession(rs.getString("profession"));
				//将stu对象的信息放到stuList里
				stuList.add(stu);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		
		return stuList;
	}
	//更新数据
	@Override
	public boolean updateStudentById(int id, Student stu) {
		System.out.println(id);
		DBUtil.getConnection();
		int sex;
		if(stu.isSex()==false){
			 sex=0;
		}else{
			sex=1;
		}
		String[] param={stu.getUserno(),stu.getUsername(),
				stu.getUserpass(),stu.getAge()+"",sex+"",
				stu.getBirthday()+"",stu.getProfession(),id+""};
		int x=this.executeUpdate(SQL_UPDATE,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}
	//删除
	@Override
	public boolean delStudentById(int id) {
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
	///添加用户

	@Override
	public boolean addStudent(Student stu) {
		DBUtil.getConnection();
		int sex;
		if(stu.isSex()==false){
			 sex=0;
		}else{
			sex=1;
		}
		String[] param={stu.getUserno(),stu.getUsername(),stu.getUserpass(),stu.getAge()+"",
				sex+"",stu.getBirthday()+"",stu.getProfession(),0+""};
		int x=this.executeUpdate(SQL_INSERT,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}	
	}
	

	

}
