package com.github.spring.sqldemo.mapper;

public class DynamicSql {

	private static final ThreadLocal<String> sql = new ThreadLocal<String>();

	public void setSql(String sql){
		this.sql.set(sql);
	}

	public String getSql(){
		return this.sql.get();
	}
}
