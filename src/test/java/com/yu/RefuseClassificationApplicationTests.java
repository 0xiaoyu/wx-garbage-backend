package com.yu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yu.domain.Category;
import com.yu.domain.Refuse;
import com.yu.service.CategoryService;
import com.yu.service.RefuseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RefuseClassificationApplicationTests {

    @Autowired
    private RefuseService refuseService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<Refuse> q = new LambdaQueryWrapper<>();
        q.like(Refuse::getName,"龙虾");
        Refuse refuse = refuseService.getOne(q,false);
        Category category = categoryService.getById(refuse.getSortid());
        System.out.println(category.getName());
    }

}
