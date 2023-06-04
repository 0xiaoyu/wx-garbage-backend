package com.yu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.domain.Category;
import com.yu.service.CategoryService;
import com.yu.dao.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author za'y
* @description 针对表【sorted】的数据库操作Service实现
* @createDate 2023-05-31 17:32:31
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService {

}




