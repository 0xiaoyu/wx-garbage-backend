package com.yu.dao;

import com.yu.domain.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author za'y
* @description 针对表【sorted】的数据库操作Mapper
* @createDate 2023-05-31 17:32:31
* @Entity com.yu.domain.sorted
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}




