package com.ly.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author leiyuan
 *
 */
public interface GatherService {
/**
 * 找到未汇总的表头
 * @return list集合
 */
	@SuppressWarnings("rawtypes")
	public List findungather();

/**
 * 
 * @param time 库存时间
 * @return map集合 String为key代表表头 List为value代表数值
 */
@SuppressWarnings("rawtypes")
public Map<String, List> hasgather(String time);
	
}
