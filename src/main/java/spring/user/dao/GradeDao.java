package spring.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import springbook.user.domain.Grade;
import springbook.user.process.GradeProcess;

public class GradeDao {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void rankUpdate(ArrayList<Grade> list) throws ClassNotFoundException, SQLException{
		// rank update
		Connection c = dataSource.getConnection();
		GradeProcess gp = new GradeProcess();
		PreparedStatement ps = null;
		for(int i=0; i<list.size(); i++){
			ps = c.prepareStatement("update grade set rank=? where snumber=?");
			ps.setInt(1, gp.rankProcess(list).get(i).getRank());
			ps.setInt(2, list.get(i).getSnumber());
			ps.executeUpdate();
		}
		ps.close();
		c.close();
	}
	
	public void insertGrade(Grade grade) throws SQLException{
		// insert
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement("insert into grade(snumber, name, korean,"
				+ "english, math, sum, avr, grade, rank) values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1, grade.getSnumber());
		ps.setString(2, grade.getName());
		ps.setInt(3, grade.getKorean());
		ps.setInt(4, grade.getEnglish());
		ps.setInt(5, grade.getMath());
		ps.setInt(6, grade.getSum());
		ps.setFloat(7, grade.getAvr());
		ps.setString(8, grade.getGrade());
		ps.setInt(9, grade.getRank());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public ArrayList<Grade> getStudent() throws ClassNotFoundException,SQLException{
		// select
		Connection c = dataSource.getConnection();
		ArrayList<Grade> list = new ArrayList<Grade>();
		PreparedStatement ps = c.prepareStatement("select * from grade");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Grade gd = new Grade();
			gd.setSnumber(rs.getInt("snumber"));
			gd.setName(rs.getString("name"));
            gd.setKorean(rs.getInt("korean"));
            gd.setEnglish(rs.getInt("english"));
            gd.setMath(rs.getInt("math"));
            gd.setSum(rs.getInt("sum"));
            gd.setAvr(rs.getFloat("avr"));
            gd.setGrade(rs.getString("grade"));
            gd.setRank(rs.getInt("rank"));
            list.add(gd);
		}
		rs.close();
		ps.close();
		c.close();
		
		return list;
	}
	
	public void deleteAll() throws SQLException{
		// delete all
		Connection c = dataSource.getConnection();
		PreparedStatement pst = c.prepareStatement("delete from grade");
		pst.executeUpdate();
		System.out.println("successfully all deleted");
		pst.close();
		c.close();
		
	}
}
