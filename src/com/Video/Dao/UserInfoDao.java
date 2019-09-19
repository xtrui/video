package com.Video.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Video.entity.VideoInfo;
import com.Video.util.Sqlcn;

public class UserInfoDao {
	public int findUser(String u,String p){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sqlcn dt = new Sqlcn();
		
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT * FROM U where Username=? and Password=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, u);
			ps.setString(2, p);
			//5.ִ��sql��� 
			rs = ps.executeQuery();
			while(rs.next()){
				
				return rs.getInt(1);
				
				
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
		
		return 0;
	}
	
	public int findUser(String u){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sqlcn dt = new Sqlcn();
		int r=0;
		
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT * FROM U where Username=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, u);
			//5.ִ��sql��� 
			rs = ps.executeQuery();
			while(rs.next()){
				
				r = rs.getInt(1);
				
				
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
		
		return r;
	}
	
	public int insertu(String u,String p){
		Connection conn = null;
		PreparedStatement ps = null;
		int r = 0;
		
		Sqlcn dt = new Sqlcn();
		
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "insert into u values(null,?,?,1234165);";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, u);
			ps.setString(2, p);
			//5.ִ��sql��� 
			 if(ps.executeUpdate()!=0){
				 r=1;
			 }
			
			
			
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
		
		return r;
		
	}
}
