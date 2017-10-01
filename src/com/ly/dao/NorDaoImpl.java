package com.ly.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ly.model.TableName;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class NorDaoImpl extends BaseDao implements NorDao {
	private NorDao ndl;

	public NorDao getNdl() {
		return ndl;
	}

	public void setNdl(NorDao ndl) {
		this.ndl = ndl;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findAllHeader() {
		Connection conn = JdbcConfigImpl.getConnection();
		if (conn != null) {
			System.out.println("数据库连接成功");
		}
		String sql = "select * from datatotal";
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			List list = new ArrayList();
			ResultSetMetaData data = rs.getMetaData();
			for (int i = 1; i <= data.getColumnCount(); i++) {
				// 获得指定列的列名
				String columnName = data.getColumnName(i);
				/* System.out.println(columnName); */
				list.add(columnName);
			}
			/*
			 * //打印出查询出来的表头 ListIterator lit=list.listIterator();
			 * while(lit.hasNext()){ System.out.println(lit.next()); }
			 */
			stmt.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, List> tableData(String[] tableheader) {
		Connection conn = JdbcConfigImpl.getConnection();
		if (conn != null) {
			System.out.println("数据库连接成功了");
		}
		PreparedStatement ptmt;
		ResultSet rs;
		Map<String, List> map = new HashMap<String, List>();

		try {
			for (int i = 0; i < tableheader.length; i++) {
				ptmt = conn.prepareStatement("select " + tableheader[i] + " from datatotal");
				rs = ptmt.executeQuery();
				// 将查询出的对应数据放在List集合中
				List list = new ArrayList();
				while (rs.next()) {
					int k = 1;
					list.add(rs.getObject(k++));
				}
				// 以表头为key，表头对应列数据为value存进Map中
				map.put(tableheader[i], list);
				rs.close();
				ptmt.close();

			}
			conn.close();
			return map;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean savaTable(String tablename, String[] tableheader, Map<String, List> mapdata) {
		String sql = " id int auto_increment primary key,";
		int count;//返回执行DDL后的值 为0
		Connection conn = JdbcConfigImpl.getConnection();
		if (conn != null) {
			System.out.println("数据库连接成功了啊");
		}
		Statement stmt;
		for (int i = 0; i < tableheader.length - 1; i++) {
			// 获得创建表的sql语句
			sql +=tableheader[i] + " varchar(255) DEFAULT 0 , ";
		}
		sql += tableheader[tableheader.length - 1] + " varchar(255) DEFAULT 0";
		String sqlstr = "create table " + tablename + " ( " + sql + " );";

		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate(sqlstr);
			System.out.println("创建成功！");
			stmt.close();
			conn.close();
	        if(count==0){
	        	return true;
	        }
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	// 给归一化后的表插入数据
	@SuppressWarnings("rawtypes")
	public int insertData(String tablename, String[] tableheader, Map<String, List> mapdata) {
		// 向tablename中插入数据
		for (int j = 0; j < tableheader.length; j++) {
			for (Map.Entry<String, List> entry : mapdata.entrySet()) {
				Connection conn = JdbcConfigImpl.getConnection();
				String tablekey = entry.getKey();
				if (tablekey.equals(tableheader[j])) {
					List listTest = entry.getValue();
					try {
						
						conn.setAutoCommit(false);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					for (int data = 0; data < listTest.size(); data++) {
						try {
							Statement stmt = conn.createStatement();
							if(j==0){
							stmt.executeUpdate("insert into " +tablename+" ( "+ tablekey +" ) values (" + "'"+ listTest.get(data) + "'" + ");");
							}else{							
									stmt.executeUpdate("update " +tablename+" set " + tablekey + "= " + "'"+ listTest.get(data) + "'" + "where id ="+"'"+ (data+1)+"'"+ ";");
							}
									if(data==499){
								conn.commit();
								stmt.close();
								System.out.println("update " +tablename+" set " + tablekey + "= " + "'"+ listTest.get(data) + "'" + "where "+tablekey + "= 0"+ ";");
/*								System.out.println("update " +tablename+" set " + tablekey + " =REPLACE( "+tablekey+"") );*/

							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return 2;

	}

	@Override
	public void saveTableName(TableName tn) {
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//保存用户
	     session.save(tn);	
	     System.out.println("1234556777"+tn.getName());
			tx.commit();//提交session
		    session.close();//关闭session
		
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List findAllHeader(String sql,List list) {		
		Connection conn = JdbcConfigImpl.getConnection();
		if (conn != null) {
			System.out.println("数据库连接成功");
		}
		PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);			
			ResultSetMetaData data = rs.getMetaData();
			for (int i = 1; i <= data.getColumnCount(); i++) {
				// 获得指定列的列名
				String columnName = data.getColumnName(i);
				/* System.out.println(columnName); */
				list.add(columnName);
			}
			/*
			 * //打印出查询出来的表头 ListIterator lit=list.listIterator();
			 * while(lit.hasNext()){ System.out.println(lit.next()); }
			 */
			stmt.close();
			conn.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public boolean createTable(String second, String[] tableheader) {
		String sql = " id int auto_increment primary key,";
		int count;//返回执行DDL后的值 为0
		Connection conn = JdbcConfigImpl.getConnection();
		if (conn != null) {
			System.out.println("数据库连接成功了啊");
		}
		Statement stmt;
		for (int i = 0; i < tableheader.length - 1; i++) {
			// 获得创建表的sql语句
			sql +=tableheader[i] + " varchar(255) DEFAULT 0 , ";
		}
		sql += tableheader[tableheader.length - 1] + " varchar(255) DEFAULT 0";
		String sqlstr = "create table " + second + " ( " + sql + " );";

		try {
			stmt = conn.createStatement();
			count=stmt.executeUpdate(sqlstr);
			System.out.println("创建成功！");
			stmt.close();
			conn.close();
	        if(count==0){
	        	return true;
	        }
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

}
