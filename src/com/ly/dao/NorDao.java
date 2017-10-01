package com.ly.dao;

import java.util.List;
import java.util.Map;

import com.ly.model.TableName;

/**
 * 归一化处理的Dao层接口,定义出对数据库操作的方法并返回处理结果
 * 
 * @author leiyuan
 *
 */
public interface NorDao {

	/**
	 * 对数据进行归一化处理的方法
	 * 
	 * @author leiyuan
	 * @param tableitem
	 *            代表所选择的表，值分别为字符1、2、3、4
	 * @param tablesort
	 *            代表选择的排序方式，值分别为1、2、3
	 */
	@SuppressWarnings("rawtypes")
	public List findAllHeader();

	/**
	 * 将归一化之后所得表头对应的数据存入Map集合中
	 * 
	 * @param tableheader
	 *            归一化之后所的表的表头
	 * @param MapMap<String,
	 *            List> 表头为key，表头对应的数据组成的List集合为value
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, List> tableData(String[] tableheader);

	/**
	 * 根据归一化得到的表头创建表
	 * @param tablename
	 *            代表归一化之后所得表的表名
	 * @param tableheader
	 *            归一化之后所的表的表头
	 * @param mapdata
	 *            表头对应的数据存放在用表头为key，对应数据组成的List集合为value的Map中
	 * @return (true代表成功，false代表失败)
	 */
	@SuppressWarnings("rawtypes")
	public boolean savaTable(String tablename, String[] tableheader, Map<String, List> mapdata);	
	/**
	 * 向创建的表中填入数据
	 * @param tablename
	 *            代表归一化之后所得表的表名
	 * @param tableheader
	 *            归一化之后所的表的表头
	 * @param mapdata
	 *            表头对应的数据存放在用表头为key，对应数据组成的List集合为value的Map中
	 * @return (true代表成功，false代表失败)
	 */
	@SuppressWarnings("rawtypes")
	public int insertData(String tablename,String[] tableheader,Map<String, List> mapdata);

	/**
	 * 将归一化所得的表名保存到数据库中
	 * @param tn 表名
	 */
	public void saveTableName(TableName tn);


	/**
	 * 
	 * @param sql SQL語句
	 * @param list 存放所有表頭的List結合
	 * @return 表頭集合
	 */
	@SuppressWarnings("rawtypes")
	public List findAllHeader(String sql,List list);

	/**
	 * 
	 * @param second 表名
	 * @param tableheader 表头
	 * @return
	 */
	public boolean createTable(String second, String[] tableheader);

}
