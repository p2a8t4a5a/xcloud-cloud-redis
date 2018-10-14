package com.xuan.erp.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

// 继承包含CURD、以及分页、条件查询组件
// 注意该接口不能被扫描到, 否则会出错
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}