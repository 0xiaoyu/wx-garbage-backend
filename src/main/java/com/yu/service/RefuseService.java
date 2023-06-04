package com.yu.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yu.domain.Refuse;

import java.util.List;

/**
* @author za'y
* @description 针对表【refuse】的数据库操作Service
* @createDate 2023-05-31 16:28:14
*/
public interface RefuseService extends IService<Refuse> {

    /**
     * @description 根据垃圾名称获取垃圾信息
     * @param name 垃圾名称
     * @return com.yu.domain.Refuse
     */
    List<Refuse> getByLikeName(String name);

}
