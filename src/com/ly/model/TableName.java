package com.ly.model;
/**
 * 
 * @author leiyuan
 *
 */
public class TableName {
	//主键id
	private int id;
	//保存归一化之后的表名
    private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
