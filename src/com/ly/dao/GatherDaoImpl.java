package com.ly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ly.model.TableName;

public class GatherDaoImpl extends BaseDao implements GatherDao {

	@Override
	public List<TableName> findTableName() {
		String hql="from TableName ";
		//获得Hibernatte Session
		Session session=(Session)getSession();
		//开始事务
		Transaction tx=session.beginTransaction();
		//开始查询并把查询结果放在List集合中
		@SuppressWarnings("unchecked")
		List<TableName> list=session.createQuery(hql).list();		
        if(list.size()!=0){
		return list;
	}else{
		tx.commit();//提交session
        session.close();//关闭session
        return null;
		
	}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List findnorTable(List<TableName> tablename) {
		List list = new ArrayList();
		for(int i=0;i<tablename.size();i++){
			TableName tn=tablename.get(i);
			Connection conn = JdbcConfigImpl.getConnection();
			if (conn != null) {
				System.out.println("数据库连接成功le a ");
			}
			String sql = "select * from "+tn.getName();
			PreparedStatement stmt;
			try {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery(sql);
				ResultSetMetaData data = rs.getMetaData();
				for (int j = 1; j <= data.getColumnCount(); j++) {
					// 获得指定列的列名
					String columnName = data.getColumnName(j);
					list.add(columnName);
				}
				/*
				 * //打印出查询出来的表头 ListIterator lit=list.listIterator();
				 * while(lit.hasNext()){ System.out.println(lit.next()); }
				 */
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, List> hasgather(String time) {
		return null;
	}




}
