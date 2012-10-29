package org.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.bean.Note;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import org.db.DBConnection;

public class NoteDAO {
	Connection conn;
	private String DBTableName = "note";
	private String idInDB = "id";
	private String titleInDB = "title";
	private String contentInDB = "content";
	private String createDateInDB = "createDate";
	private String modifyDateInDB = "modifyDate";
	private String noteBookIdInDB = "noteBookId";
	public NoteDAO() {
		conn = DBConnection.getConnection();
	}
	public ArrayList<Note> getNotesByNoteBookId( int noteBookId ) {
		ArrayList<Note> notes = new ArrayList<Note>();
		String sql = "select * from " + DBTableName + " where " + noteBookIdInDB + "=?";
		conn = DBConnection.getConnection();
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt( 1, noteBookId );
			ResultSet resultSet = ps.executeQuery();
			while ( resultSet.next() ) {
				notes.add( generateNoteBook(resultSet) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}
	public boolean insertNote( Note note ) {
		conn = DBConnection.getConnection();
		// TODO 未测试 增加笔记到数据库的方法
		String sql = "insert into " + DBTableName + "(" + noteBookIdInDB + "," + titleInDB + "," + contentInDB + "," + createDateInDB + "," + modifyDateInDB + ") value(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt( 1, note.getNoteBookId() );
			ps.setString( 2, note.getTitle() );
			ps.setString( 3, note.getContent() );
			ps.setString( 4, note.getCreateDate() );
			ps.setString( 5, note.getModifyDate() );
			// 还是用 ps.execute() ?
			// 返回的 int 哪个是表示成功？
			if ( ps.executeUpdate() == 1 ) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteNoteById( int id ) {
		// TODO 未测试 从数据库删除笔记的方法
		String sql = "delete from " + DBTableName + " where " + idInDB + "=?";
		conn = DBConnection.getConnection();
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
	public boolean updateNote( Note note ) {
		// TODO 更新笔记信息的方法
		String sql = "";
		conn = DBConnection.getConnection();
		return false;
	}
	private Note generateNoteBook( ResultSet result ) throws SQLException {
		Note note = new Note();
		note.setTitle( result.getString(titleInDB) );
		note.setContent( result.getString(contentInDB) );
		note.setNoteID( result.getInt(idInDB) );
		note.setCreateDate( result.getString(createDateInDB) );
		note.setModifyDate( result.getString(modifyDateInDB) );
		return note;
	}
}
