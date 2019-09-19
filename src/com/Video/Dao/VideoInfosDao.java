package com.Video.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Video.action.Sql;
import com.Video.entity.VideoInfo;
import com.Video.util.Sqlcn;

public class VideoInfosDao {
	
	/**
	 * ��ȡ�����Ű˸���Ƶ
	 * @return 8����Ƶ�����list
	 
	 */
	public List<VideoInfo> findHotVidoes() {
		Sqlcn dt = new Sqlcn();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<VideoInfo> list=new ArrayList<VideoInfo>();
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT * FROM V order by Cnum desc limit ?";			
			ps = conn.prepareStatement(sql);
			//5.ִ��sql��� 
			ps.setInt(1, 8);
			rs = ps.executeQuery();
			while(rs.next()){
				VideoInfo video = new VideoInfo();
				video.VID = rs.getInt(1);
				video.Title = rs.getString(2);
				video.Jj = rs.getString(3);
				video.Cnum = rs.getInt(4);
				video.Url = rs.getString(5);
				video.Cat = rs.getString(6);
				list.add(video);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
			
		return list;
	}
	/**
	 * ��ȡ���µ�9����Ƶ
	 * @return ����Ƶ�����list
	 * @throws SQLException 
	 */
	public List<VideoInfo> findNewVidoes() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sqlcn dt = new Sqlcn();
		List<VideoInfo> list=new ArrayList<VideoInfo>();
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT * FROM V order by VID desc limit ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 9);
			//5.ִ��sql��� 
			rs = ps.executeQuery();
			while(rs.next()){
				VideoInfo video = new VideoInfo();
				video.VID = rs.getInt(1);
				video.Title = rs.getString(2);
				video.Jj = rs.getString(3);
				video.Cnum = rs.getInt(4);
				video.Url = rs.getString(5);
				video.Cat = rs.getString(6);
				list.add(video);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
			
		return list;
		
	
	}
	
	/**
	 * ��ȡcat������Ƶ 
	 * @param cat
	 * @return 10��cat����video���list 
	 * @throws SQLException 
	 */
	public List<VideoInfo> findCatVideos(String cat) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sqlcn dt = new Sqlcn();
		List<VideoInfo> list=new ArrayList<VideoInfo>();
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT * FROM V where Cat=? order by VID desc limit 10";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cat);
			//5.ִ��sql��� 
			rs = ps.executeQuery();
			while(rs.next()){
				VideoInfo video = new VideoInfo();
				video.VID = rs.getInt(1);
				video.Title = rs.getString(2);
				video.Jj = rs.getString(3);
				video.Cnum = rs.getInt(4);
				video.Url = rs.getString(5);
				video.Cat = rs.getString(6);
				list.add(video);
				
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
			
		return list;
		
	}
	
	/**
	 * ��ȡ���µ�VID
	 * @return ����һ��video��¼��VID
	 * @throws SQLException 
	 */
	public int findVideoC(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		VideoInfo video = null;
		Sqlcn dt = new Sqlcn();
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT VID FROM V order by VID desc limit ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			//5.ִ��sql��� 
			rs = ps.executeQuery();
			if(rs.next()){
				video = new VideoInfo();
				video.VID = rs.getInt(1);
				video.Title = rs.getString(2);
				video.Jj = rs.getString(3);
				video.Cnum = rs.getInt(4);
				video.Url = rs.getString(5);
				video.Cat = rs.getString(6);
				
			}
			rs.close();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
		if(video==null){
			return 0;
		}
		else{
		return video.VID;
		}
	}
	
	/**
	 * ����һ��video���
	 * @param Video
	 * @return ����״̬
	 
	 */
	public int insert(VideoInfo Video) {  
		Connection conn = null;
		PreparedStatement ps = null;
		
		Sqlcn dt = new Sqlcn();
		int p = 0;
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "insert into V values(null ,? ,?,0,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, Video.Title);
			ps.setString(2, Video.Jj);
			ps.setString(3, Video.Url);
			ps.setString(4, Video.Cat);
			p = ps.executeUpdate();
			
			
			ps.close();
			conn.close();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
		
		return p;
	}
	/**
	 * ͨ��VID����һ����Ƶ��Ϣ��
	 * @param a ��Ƶ��VID
	 * @return
	 */
	
	public VideoInfo findVideo(int a){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sqlcn dt = new Sqlcn();
		VideoInfo video = null;
		try {
			//1.����ݿ����ӳ��л�ȡ ���Ӷ���
			conn = dt.conn();
			//4.׼��sql���
			String sql = "SELECT * FROM V where VID=?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, a);
			//5.ִ��sql��� 
			rs = ps.executeQuery();
			while(rs.next()){
				video = new VideoInfo();
				video.VID = rs.getInt(1);
				video.Title = rs.getString(2);
				video.Jj = rs.getString(3);
				video.Cnum = rs.getInt(4);
				video.Url = rs.getString(5);
				video.Cat = rs.getString(6);
				
				rs.close();
				ps.close();
				conn.close();
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			
		}
			
		return video;
	}
	
}


