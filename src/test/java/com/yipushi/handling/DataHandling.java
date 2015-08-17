package com.yipushi.handling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DataHandling {

	private static DataSource dataSource;
	private static int succeed = 1;		//成功状态
	private static int Lose = 2;		//失败状态

	public static void setDataSource(DataSource dataSource) {
		DataHandling.dataSource = dataSource;
	}

	/**
	 * 删除数据
	 */
	public static void deleteById(int id) throws Exception {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from student2 where id=?");
			ps.setInt(1, id);
			ps.execute();
			System.out.println("删除成功");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 更新成功
	 */
	public static void succeedUpdateById(int id) throws Exception {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("update student set state=? where id=?");
			ps.setInt(1, succeed);
			ps.setInt(2, id);
			ps.execute();
			System.out.println("修改成功:succeedUpdateById");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 更新失败
	 */
	public static void LoseUpdateById(int id) throws Exception {
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement("update student set state=? where id=?");
			ps.setInt(1, Lose);
			ps.setInt(2, id);
			ps.execute();
			System.out.println("修改成功:LoseUpdateById");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
