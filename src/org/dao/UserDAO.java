package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bean.User;
import org.db.DBConnection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class UserDAO {
	Connection conn;
	private String DBTableName = "user";
	private String idInDB = "id";
	private String nameInDB = "name";
	private String passwordInDB = "password";
	private String emailInDB = "email";
	private String captchaInDB = "captcha";
	private String isCapthcha = "isVerify";
	public UserDAO() {
		conn = null;
	}
	public User getUserByName( String name ) {
		User user = null;
		conn = DBConnection.getConnection();
		String sql = "select * from " + DBTableName + " where " + nameInDB + "=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString( 1, name );
			ResultSet res = (ResultSet) ps.executeQuery();
			if ( res.next() ) {
				user = generateUser( res );
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public User getUserByEmail( String email ) {
		User user = null;
		conn = DBConnection.getConnection();
		String sql = "select * from " + DBTableName + " where " + emailInDB + "=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString( 1, email );
			ResultSet res = (ResultSet) ps.executeQuery();
			if ( res.next() ) {
				user = generateUser( res );
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean insertUser( User user ) {
		conn = DBConnection.getConnection();
		String sql = "insert into " + DBTableName + "(" + nameInDB + "," + passwordInDB + "," + emailInDB + "," + captchaInDB + "," + isCapthcha + ") values(?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString( 1, user.getName() );
			ps.setString( 2, user.getPassword() );
			ps.setString( 3, user.getEmailAddress() );
			ps.setString( 4, user.getCaptcha() );
			ps.setBoolean( 5, user.isCaptchaFlag() );
			// 还是用 ps.execute() ?
			// 返回的 int 哪个是表示成功？
			if ( ps.executeUpdate() == 1 ) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteUserByName( String name ) {
		conn = DBConnection.getConnection();
		// TODO 未测试 从数据库删除用户到的方法
		String sql = "delete from " + DBTableName + " where " + nameInDB + "=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString( 1, name );
			// 还是用 ps.execute() ?
			// 返回的 int 哪个是表示成功？
			if ( ps.executeUpdate() == 1 ) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateUser( User user ) {
		conn = DBConnection.getConnection();
		// TODO 更新用户信息到的方法
//		String sql = "insert * from user where name=?";
		return false;
	}
	private User generateUser( ResultSet result ) throws SQLException {
		User user = new User();
		user.setName( result.getString(nameInDB) );
		user.setPassword( result.getString(passwordInDB) );
		user.setEmailAddress( result.getString(emailInDB) );
		user.setId( result.getInt(idInDB) );
		user.setCaptcha( result.getString(captchaInDB) );
		user.setCaptchaFlag( result.getBoolean(isCapthcha) );
		return user;
	}
}
