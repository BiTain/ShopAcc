package com.shopacc.dao.imp;

import com.shopacc.dao.GenericDAO;
import com.shopacc.mapper.RowMapper;

import java.beans.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDAO<T>{
	public Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;DatabaseName=dbshopacc;encrypt=true;trustServerCertificate=true";
			String userName = "lequocbao";
			String passWord = "Bao@26072003";
			System.out.println(userName);
			System.out.println(passWord);
			conn = DriverManager.getConnection(url,userName,passWord);
			System.out.println(conn);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		List<T> results = new ArrayList<T>();
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stm = conn.prepareStatement(sql);
			setParameter(stm,parameters);
			rs = stm.executeQuery();
			while(rs.next()) {
				results.add(rowMapper.mapRow(rs));
			}
			return results;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stm!=null) {
					stm.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void setParameter(PreparedStatement stm, Object... parameters) {
		try {
			for(int i=0; i<parameters.length;i++) {
				Object parameter = parameters[i];
				int index = i+1;
				if(parameter instanceof String) {
					stm.setString(index, (String)parameter);
				}else if(parameter instanceof Integer) {
					stm.setInt(index, (Integer)parameter);
				}else if(parameter instanceof BigDecimal) {
					stm.setBigDecimal(index, (BigDecimal)parameter);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public int insert(String sql, Object... parameters) {
		ResultSet rs = null;
		int id = 0;
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			setParameter(stm, parameters);
			stm.executeUpdate();
			rs = stm.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				if(conn != null ) {
				conn.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return 0;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stm!=null) {
					stm.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			int count = 0;
			conn = getConnection();
			stm = conn.prepareStatement(sql);
			setParameter(stm,parameters);
			rs = stm.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stm!=null) {
					stm.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			setParameter(stm, parameters);
			stm.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				if(conn != null ) {
				conn.rollback();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(stm!=null) {
					stm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
