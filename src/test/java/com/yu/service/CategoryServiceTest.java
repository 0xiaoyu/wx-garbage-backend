package com.yu.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yu.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
class CategoryServiceTest {
    @Autowired
    private CategoryService categoryService;

    @Test
    void getByName() {
        LambdaQueryWrapper<Category> q = new LambdaQueryWrapper<>();
        q.eq(Category::getName,"可回收垃圾");
        List<Category> list = categoryService.list(q);
        Assertions.assertThat(list.get(0)).isNotNull();
        assert list.get(0).getId() == 1;
    }

}