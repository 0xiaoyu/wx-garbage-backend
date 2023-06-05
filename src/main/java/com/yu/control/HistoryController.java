package com.yu.control;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yu.common.R;
import com.yu.domain.history;
import com.yu.service.historyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * history控制器
 * @version 1.0
 * &#064;date  2023/6/4
 * @author  zay
 */
@RequestMapping("/history")
@RestController
public class HistoryController {

    @Autowired
    private historyService service;

    /**
     * 根据用户id获取历史记录列表
     * @param id 用户id
     * @return 历史记录列表
     */
    @GetMapping("/list/{id}")
    public R getListByUserId(@PathVariable String id){
        LambdaQueryWrapper<history> q = new LambdaQueryWrapper<>();
        q.eq(history::getUserid,id);
        return R.ok(service.list(q));
    }
}
