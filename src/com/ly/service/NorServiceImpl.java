package com.ly.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ly.dao.NorDao;
import com.ly.model.TableName;

public class NorServiceImpl implements NorService {
	// 业务逻辑组件需要的NorDao实例
	private NorDao ndl;
	//保存表名所需要的TableNmae实例
	private TableName tn;

	public TableName getTn() {
		return tn;
	}

	public void setTn(TableName tn) {
		this.tn = tn;
	}

	public NorDao getNdl() {
		return ndl;
	}

	public void setNdl(NorDao ndl) {
		this.ndl = ndl;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findTableHeader() {
		// TODO Auto-generated method stub
		// 调用Dao层的findAll方法来找到对应表所选择的对应排序方式的表头
		List list = ndl.findAllHeader();
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List tableheadernor(String[] tableheader, int[] checkbox, String[] headersort) {
		/*
		 * for(int k=0;k<checkbox.length;k++){
		 * System.out.println("在业务逻辑组件中获得的选中的表头为："+tableheader[checkbox[k]]); }
		 */
		// 创建一个List集合用来存放表头
		List list = new ArrayList();
		// 找到选中的表头
		for (int i = 0; i < checkbox.length; i++) {
			/*
			 * System.out.println("在业务逻辑组件中获得的选中的表头为："+tableheader[checkbox[i]])
			 * ;
			 */
			// 对找到的表头根据headersort得到的优先级进行排序
			if (headersort[checkbox[i]] != "") {
				for (int j = 0; j < checkbox.length; j++) {
					int flag = Integer.parseInt(headersort[checkbox[j]]);
					if (flag == (i + 1)) {
						list.add(tableheader[checkbox[j]]);
						/*
						 * System.out.println("自定义排序的表头为："+tableheader[checkbox[
						 * j]]);
						 */
					} else {
						System.out.println("没有进入自定义排序：" + tableheader[checkbox[j]]);
					}
				}
			} else {
				// 采用默认排序
				list.add(tableheader[checkbox[i]]);
				/* System.out.println("默认排序的表头为："+tableheader[checkbox[i]]); */
			}
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<String, List> fulfillData(String[] tableheader) {
		// 调用Dao组件查出所有表头对应的数据
		Map<String, List> map = ndl.tableData(tableheader);
		return map;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int savaTable(String tablename, String[] tableheader)  {
		//获取到表头对应的数据并以表头为key，数据组成的List集合为value放进Map中
		Map<String,List> mapdata=ndl.tableData(tableheader);
		System.out.println("创建表时查询到表头");
		for(int i=0;i<tableheader.length;i++){
			System.out.println("houubiaotouwei:"+tableheader[i]);
		}
		boolean issucc = ndl.savaTable(tablename, tableheader,mapdata);
		if (issucc) {
		//为创建成功的表插入数据
		int isok=ndl.insertData(tablename, tableheader, mapdata);
		if(isok>0){
			return 50;
		}else{
			return -1;
		}
		}else{
			return -1;
		}
	}

	@Override
	public void saveTableName(TableName tn) {
		//调用Dao层的saveTableName（）方法来保存表名
		ndl.saveTableName(tn);
		
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public List findTableHeader(String[] checkbox) {
		//创建用来保存表头的List集合
		List list=new ArrayList();
		//按所选择的表生成Sql语句交给Dao层处理
		for(int i=0;i<checkbox.length;i++){
			//SQL语句，按表查询出对应的表头
			String sql="select * from "+checkbox[i];
			//调用Dao层的findAllHeader()方法查询出对应的表头并放在List集合中
			list=ndl.findAllHeader(sql,list);
		}
		return list;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List tablesort(String[] tableheader) {
		List list=new ArrayList();
		//将表头存在list集合中
		for(int i=0;i<tableheader.length;i++){
			list.add(tableheader[i]);
		}
		//找出list集合重复的值
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size();j++){
				if(i!=j){				
				if(list.get(i).equals(list.get(j))){
					list.remove(j);
				}
			}
			}
		}
		return list;
	}

	@Override
	public int createTable(String[] tableheader) {
		//获取当前时间，以当前时间作为数据库表名
		Calendar c=Calendar.getInstance();
		int minute=c.get(Calendar.MINUTE);
		int time=c.get(Calendar.SECOND);
		//将整型时间转化为字符串
		String second=String.valueOf(time);
		second="table"+minute+second;
		System.out.println("shijian:0"+second);
		//以当前时间为表名在数据库中建表
		boolean issucc=ndl.createTable(second,tableheader);
		if(issucc){
			//将表名存到TableName类中
			tn.setName(second);
			//调用Dao层将表名存到数据库中
			ndl.saveTableName(tn);
			return 10;
		}
		return -12;
	}

}
