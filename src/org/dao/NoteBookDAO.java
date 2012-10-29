package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bean.NoteBook;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.db.DBConnection;


public class NoteBookDAO {
	Connection conn;
	private String DBTableName = "notebook";
	private String idInDB = "id";
	private String nameInDB = "name";
	private String descirptionInDB = "descirptionInDB";
	private String notesNumInDB = "notesNum";
	private String ownerIdInDB = "ownerId";
	public NoteBookDAO() {
		conn = DBConnection.getConnection();
	}
	public ArrayList<NoteBook> getNoteBooksByUserId( int userId) {
		ArrayList<NoteBook> noteBooks = new ArrayList<NoteBook>();
		conn = DBConnection.getConnection();
		String sql = "select * from " + DBTableName + " where " + ownerIdInDB + "=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt( 1, userId );
			ResultSet resultSet = ps.executeQuery();
			while ( resultSet.next() ) {
				noteBooks.add( generateNoteBook(resultSet) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noteBooks;
	}
	public NoteBook getNoteBookByName( String name ) {
		conn = DBConnection.getConnection();
		String sql = "select * from " + DBTableName + " where " + name + "=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString( 1, name );
			ResultSet res = ps.executeQuery();
			if ( res.next() ) {
				return generateNoteBook( res );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean insertNoteBook( NoteBook noteBook ) {
		conn = DBConnection.getConnection();
		// TODO 未测试 增加笔记本到数据库的方法
		String sql = "insert into " + DBTableName + "(" + ownerIdInDB + "," + notesNumInDB + "," + nameInDB + "," + descirptionInDB + ") value(?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt( 1, noteBook.getOwnerId() );
			ps.setInt( 2, noteBook.getNotesNum() );
			ps.setString( 3, noteBook.getName() );
			ps.setString( 4, noteBook.getDescirption() );
			// 还是用 ps.execute() ?
			// 返回的 int 哪个是表示成功？
			if ( ps.executeUpdate() == 1 ) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteNoteBookById( int id ) {
		conn = DBConnection.getConnection();
		// TODO 未测试 从数据库删除笔记本的方法
		String sql = "delete from " + DBTableName + " where " + idInDB + "=?";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt( 1, id );
			// 还是用 ps.execute() ?
			// 返回的 int 哪个是表示成功？
			if ( ps.executeUpdate() == 1 ) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateNoteBook( NoteBook noteBook ) {
		conn = DBConnection.getConnection();
		// TODO 更新笔记本信息的方法
		String sql = "";
		return false;
	}
	private NoteBook generateNoteBook( ResultSet result ) throws SQLException {
		NoteBook noteBook = new NoteBook();
		noteBook.setId( result.getInt(idInDB) );
		noteBook.setName( result.getString(nameInDB) );
		noteBook.setNotesNum( result.getInt(notesNumInDB) );
		noteBook.setOwnerId( result.getInt(ownerIdInDB) );
		noteBook.setDescirption( result.getString(descirptionInDB) );
		return noteBook;
	}
}
