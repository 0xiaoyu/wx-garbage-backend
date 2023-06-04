package com.yu.control;

import com.yu.common.R;
import com.yu.domain.GarbageLocation;
import com.yu.service.GarbageLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * garbageLocation控制器
 * 获取垃圾桶位置
 * @version 1.0
 * &#064;date  2023/6/1
 * @author  zay
 */
@RestController
@RequestMapping("/garbageLocation")
@Slf4j
public class GarbageLocationController {

    @Autowired
    private GarbageLocationService service;

    @GetMapping("/list/{latitude}/{longitude}")
    public R getListNear(@PathVariable Double latitude, @PathVariable Double longitude){
        List<GarbageLocation> near = service.getListNear(latitude, longitude);
        return R.ok(near);
    }

    @PostMapping("/saveone")
    public R saveOne(@RequestBody GarbageLocation garbageLocation){
        service.save(garbageLocation);
        log.info("保存垃圾桶"+garbageLocation.toString());
        return R.ok();
    }
}
