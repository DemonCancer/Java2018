package DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Profession;
import Dao.ProfessionDao;
import util.DBUtil;

public class ProfessionDaoImpl extends DBUtil implements ProfessionDao{
	String  SQL_SELECT= "select "
			+ "id,profession "
			+ "from professiondetail";
	String SQL_UPDATE = "update professiondetail set "
			+ "profession=? "
			+ " where id = ? ";
	String SQL_INSERT = "insert into "
			+ "professiondetail(profession)"
			+ " VALUES (?)";
	String SQL_DELETE = "delete from professiondetail where id = ?";
	@Override
	public List<Profession> getAllProfession() {
		DBUtil.getConnection();
		List<Profession> proList=new ArrayList<Profession>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				Profession pro=new Profession();
				pro.setId(rs.getInt("id"));
				pro.setProfession(rs.getString("profession"));
				proList.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return proList;
	}
	@Override
	public boolean updateProById(int id, Profession pro) {
		System.out.println(id);
		DBUtil.getConnection();
		
		String[] param={pro.getProfession(),id+""};
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
	public boolean addProfession(Profession pro) {
		DBUtil.getConnection();
		String[] param={pro.getProfession()};
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
	public boolean delProById(int id) {
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
