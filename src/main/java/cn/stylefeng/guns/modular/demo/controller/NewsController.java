package cn.stylefeng.guns.modular.demo.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.News;
import cn.stylefeng.guns.modular.demo.service.NewsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TNews)表控制层
 *
 * @author RestfulToolkitXCode
 * @since 2022-10-17 17:00:29
 */
@RestController
@RequestMapping("tNews")
public class NewsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService tNewsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param news 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<News> page, News news) {
        return success(this.tNewsService.page(page, new QueryWrapper<>(news)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tNewsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param news 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody News news) {
        return success(this.tNewsService.save(news));
    }

    /**
     * 修改数据
     *
     * @param news 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody News news) {
        return success(this.tNewsService.updateById(news));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tNewsService.removeByIds(idList));
    }
}

