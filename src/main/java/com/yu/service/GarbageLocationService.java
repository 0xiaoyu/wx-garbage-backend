package com.yu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.domain.GarbageLocation;

import java.util.List;

/**
* @author za'y
* @description 针对表【garbage_location(记录垃圾桶的位置信息)】的数据库操作Service
* @createDate 2023-06-01 20:19:37
*/
public interface GarbageLocationService extends IService<GarbageLocation> {


    /**
     * @description 根据经纬度获取附近的垃圾桶
     * @param latitude 纬度
     * @param longitude 经度
     * @return java.util.List<com.yu.domain.GarbageLocation>
     */
    List<GarbageLocation> getListNear(Double latitude, Double longitude);
}
