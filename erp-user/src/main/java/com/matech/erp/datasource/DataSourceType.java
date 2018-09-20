package com.matech.erp.datasource;

public enum DataSourceType {
	Mysql("mysql"),
	SQLServer("sqlserver");
 
	private String name;
 
	DataSourceType(String name) {
		this.name = name;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
}