package com.yu.control;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yu.common.R;
import com.yu.domain.Require;
import com.yu.service.requirementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * requirements控制器
 * 获取垃圾分类要求
 * @version 1.0
 * &#064;date  2023/6/4
 * @author  zay
 */
@RequestMapping("/require")
@RestController
public class RequireController {

    @Autowired
    private requirementsService service;

    @GetMapping("/list/{id}")
    public R getListBySortedId(@PathVariable Integer id){
        try {
            LambdaQueryWrapper<Require> q = new LambdaQueryWrapper<>();
            q.eq(Require::getSortedid, id);
            List<Require> list = service.list(q);
            return R.ok(list.stream().map(Require::getRequirement).toList());
        }catch (Exception e){
            return R.error(e.getMessage());
        }
    }
}
