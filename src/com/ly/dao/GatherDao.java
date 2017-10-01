package com.ly.dao;

import java.util.List;
import java.util.Map;

import com.ly.model.TableName;

public interface GatherDao {
	/**
	 * 查找出归一化后所得的表名
	 * @return
	 */
	public List<TableName> findTableName();
	/**
	 * 查找出归一化之后的所有表头
	 * @param tablename表名
	 * @return
	 */
    @SuppressWarnings("rawtypes")
	public List findnorTable( List<TableName> tablename);
    
    /**
     * 
     * @param time 库存时间
     * @return map集合 String为key代表表头 List为value代表数值
     */
	@SuppressWarnings("rawtypes")
	public Map<String, List> hasgather(String time);
}
