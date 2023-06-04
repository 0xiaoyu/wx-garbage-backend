package com.yu.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.dao.RefuseMapper;
import com.yu.domain.Refuse;
import com.yu.service.RefuseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author za'y
* @description 针对表【refuse】的数据库操作Service实现
* @createDate 2023-05-31 16:28:14
*/
@Service
public class RefuseServiceImpl extends ServiceImpl<RefuseMapper, Refuse>
    implements RefuseService {

    @Override
    public List<Refuse> getByLikeName(String name) {
        LambdaQueryWrapper<Refuse> q = new LambdaQueryWrapper<>();
        q.like(Refuse::getName,name);
        return this.list(q);
    }
}




