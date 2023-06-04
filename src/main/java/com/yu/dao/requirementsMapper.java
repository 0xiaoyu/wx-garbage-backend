package com.yu.dao;

import com.yu.domain.Require;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author za'y
* @description 针对表【requirements】的数据库操作Mapper
* @createDate 2023-06-03 13:28:28
* @Entity com.yu.domain.requirements
*/
@Mapper
public interface requirementsMapper extends BaseMapper<Require> {

}




