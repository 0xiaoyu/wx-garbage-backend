package com.yu.control;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yu.common.R;
import com.yu.domain.Refuse;
import com.yu.service.RefuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 垃圾信息控制器
 * @version 1.0
 * &#064;date  2023/6/1
 * @author  zay
 */
@RestController()
@RequestMapping("/refuse")
public class RefuseController {

    @Autowired
    private RefuseService service;

    /**
     * 获取所有垃圾信息
     * @param refuse 垃圾信息
     * @return 垃圾信息列表
     */
    @PostMapping("/save")
    public R saveRefuse(@RequestBody Refuse refuse) {
        service.saveOrUpdate(refuse);
        return R.ok();
    }

    /**
     * 根据垃圾名称获取垃圾信息
     * @param name 垃圾名称
     * @return 垃圾信息列表
     */
    @GetMapping("/nameone/{name}")
    public R getByName(@PathVariable String name){
        if (name == null || name.equals(""))
            return R.error("垃圾名称不能为空");
        LambdaQueryWrapper<Refuse> q = new LambdaQueryWrapper<>();
        q.eq(Refuse::getName,name);
        return R.ok(service.list(q));
    }

    /**
     * 根据垃圾名称模糊查询垃圾信息
     * @param name 垃圾名称
     * @return 垃圾信息列表
     */
    @GetMapping("/name/{name}")
    public R getRefuseByName(@PathVariable String name) {
        if (name == null || name.equals(""))
            return R.error("垃圾名称不能为空");
        List<Refuse> list = service.getByLikeName(name);
        List maplist = list.stream().map(x -> Map.of("value", x.getId(), "text", x.getName())).toList();
        System.out.println(list);
        return R.ok(maplist);
    }

    /**
     * 根据垃圾id获取垃圾信息
     * @param id 垃圾id
     * @return 垃圾信息列表
     */
    @GetMapping("/id/{id}")
    public R getRefuseById(@PathVariable Integer id) {
        if (id == null)
            return R.error("垃圾id不能为空");
        Refuse refuse = service.getById(id);
        return R.ok(List.of(refuse));
    }


    /**
     * 根据垃圾id分页获取垃圾信息
     * @param limit 限制页数
     * @param id 垃圾id
     * @return 垃圾信息列表
     */
    @GetMapping("/limit/{id}/{limit}")
    public R getRefuseByLimit(@PathVariable Integer limit, @PathVariable Integer id) {
        if (limit == null || id == null)
            return R.error("存在空值");
        if (id < 1)
            return R.error("id不能小于1");
        LambdaQueryWrapper<Refuse> q = new LambdaQueryWrapper<>();
        q.last("limit " + limit);
        q.eq(Refuse::getSortid, id);
        List<Refuse> list = service.list(q);
        return R.ok(list);
    }
}
