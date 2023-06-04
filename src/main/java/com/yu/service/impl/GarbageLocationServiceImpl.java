package com.yu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yu.domain.GarbageLocation;
import com.yu.service.GarbageLocationService;
import com.yu.dao.GarbageLocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author za'y
* @description 针对表【garbage_location(记录垃圾桶的位置信息)】的数据库操作Service实现
* @createDate 2023-06-01 20:19:37
*/
@Service
public class GarbageLocationServiceImpl extends ServiceImpl<GarbageLocationMapper, GarbageLocation>
    implements GarbageLocationService {

    @Autowired
    private GarbageLocationMapper mapper;

    @Override
    public List<GarbageLocation> getListNear(Double latitude, Double longitude) {
        LambdaQueryWrapper<GarbageLocation> q = new LambdaQueryWrapper<>();
        q.ge(GarbageLocation::getLatitude, latitude - 0.01);
        q.le(GarbageLocation::getLatitude, latitude + 0.01);
        q.ge(GarbageLocation::getLongitude, longitude - 0.01);
        q.le(GarbageLocation::getLongitude, longitude + 0.01);
        return mapper.selectList(q);
    }
}




