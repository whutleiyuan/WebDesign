package com.ly.service;

import java.util.List;
import java.util.Map;

import com.ly.model.TableName;

/**
 * 归一化处理操作的业务逻辑组件的接口，实现对归一化的具体处理
 * 
 * @author leiyuan
 *
 */

public interface NorService {
	/**
	 * 抽取出数据表的表头
	 * 
	 * @param tableitem
	 *            代表选择的表，值分别为1、2、3、4
	 * @param tablesort
	 *            代表选择的排序方式，值分别为1、2、3
	 */
	@SuppressWarnings("rawtypes")
	public List findTableHeader();

	/**
	 * 
	 * @param tableheader
	 *            页面中所有的表头
	 * @param checkbox
	 *            在页面选中的表头值对应的复选框的值为自然数
	 * @param strings
	 *            对选中的表头的设置排序的优先级 值从1开始递增
	 * @return list 返回选中的表头组成的list集合
	 */
	@SuppressWarnings("rawtypes")
	public List tableheadernor(String[] tableheader, int[] checkbox, String[] strings);

	/**
	 * 为归一化后对应的表头填充数据
	 * 
	 * @param String
	 *            对应key值（为表头）
	 * @param List
	 *            对应value值（为表头对应的数据）
	 * @return map
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, List> fulfillData(String[] tableheader);

	/**
	 * 
	 * @param tablename
	 *            代表表名
	 * @param tableheader
	 *            代表表头
	 * @return 整数(大于0表示创建成功，小于0则失败)
	 */
	public int savaTable(String tablename, String[] tableheader);
	
    /**
     * 将归一化所得的表名保存到数据库中
     * @param tn 表名
     */
	public void saveTableName(TableName tn);

	/**
	 * 
	 * @param checkbox 存放所选择表的表头
	 * @return 
	 */
	@SuppressWarnings("rawtypes")
	public List findTableHeader(String[] checkbox);

	/**
	 * 
	 * @param tableheader
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List tablesort(String[] tableheader);

	/**
	 * 
	 * @param tableheader
	 * @return
	 */
	public int createTable(String[] tableheader);
	

}
