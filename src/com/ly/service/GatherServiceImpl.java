package com.ly.service;

import java.util.List;
import java.util.Map;

import com.ly.dao.GatherDao;
import com.ly.dao.NorDao;

public  class GatherServiceImpl implements GatherService {
	//注入查找所有表头的DAO组件
	private NorDao ndl;
	//注入汇总的DAO组件
	private GatherDao gdl;

	public GatherDao getGdl() {
		return gdl;
	}


	public void setGdl(GatherDao gdl) {
		this.gdl = gdl;
	}


	public NorDao getNdl() {
		return ndl;
	}


	public void setNdl(NorDao ndl) {
		this.ndl = ndl;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public List findungather() {
		System.out.println("开始汇总");
		//查找出所有表头
		List allheaderlist=ndl.findAllHeader();
		System.out.println("开始汇总123"+allheaderlist.size());
		//查询出归一化之后的所有表头
		List norheaderlist=gdl.findnorTable(gdl.findTableName());
		System.out.println("开始汇总456"+norheaderlist.size());
		//找出未汇总的表头
		for(int i=0;i<allheaderlist.size();i++){
			for(int j=0;j<norheaderlist.size();j++){
				if(norheaderlist.get(j).equals(allheaderlist.get(i))){
					allheaderlist.remove(i);
				}
			}
		}
		return allheaderlist;
	}


	@SuppressWarnings({ "rawtypes", "unused" })
	@Override
	public Map<String, List> hasgather(String time) {
		 Map<String, List> map=gdl.hasgather(time);
		return null;
	}

}
