package com.yu.control;

import com.yu.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用测试控制器
 * @version 1.0
 * &#064;date  2023/5/31
 * @author  zay
 */
@RestController
public class commonController {
    @GetMapping("/kong")
    public R kong(){
        return R.ok();
    }
}
