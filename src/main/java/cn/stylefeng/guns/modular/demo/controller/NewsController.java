package cn.stylefeng.guns.modular.demo.controller;



import cn.stylefeng.guns.modular.demo.model.in.NewsReq;
import cn.stylefeng.roses.kernel.rule.annotation.BusinessLog;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.stylefeng.guns.modular.demo.entity.News;
import cn.stylefeng.guns.modular.demo.service.NewsService;
import org.springframework.validation.annotation.Validated;
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
@ApiResource(name = "新闻管理")
public class NewsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private NewsService newsService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetResource(name = "新闻管理-列表", path = "/news/page")
    @BusinessLog
    public ResponseData<?> page(NewsReq newsReq) {
        return new SuccessResponseData<>(newsService.page(newsReq));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.newsService.getById(id));
    }

    /**
     * 新增数据
     * @param newsReq 实体对象
     * @return 新增结果
     */
    @PostResource(name = "新闻管理-新增", path = "/news/add")
    @BusinessLog
    public ResponseData<?> insert(@RequestBody @Validated(BaseRequest.add.class) NewsReq newsReq) {
        this.newsService.add(newsReq);
        return new SuccessResponseData<>();
    }

    /**
     * 修改数据
     *
     * @param newsReq 实体对象
     * @return 修改结果
     */
    @PostResource(name = "新闻管理-修改", path = "/news/edit")
    @BusinessLog
    public ResponseData<?> update(@RequestBody @Validated(BaseRequest.edit.class) NewsReq newsReq) {
        this.newsService.edit(newsReq);
        return new SuccessResponseData<>();
    }

    /**
     * 删除数据
     *
     * @param newsReq 主键结合
     * @return 删除结果
     */
    @PostResource(
            name = "批量删除新闻信息",
            path = {"/news/batchDelete"}
    )
    @BusinessLog
    public ResponseData<?> batchDel(@RequestBody @Validated({BaseRequest.batchDelete.class}) NewsReq newsReq) {
        this.newsService.batchDel(newsReq);
        return new SuccessResponseData<>();
    }

    /**
     * 新闻管理-详情
     * @param newsReq
     * @return
     */
    @PostResource(
            name = "查看详情",
            path = {"/news/detail"}
    )
    @BusinessLog
    public ResponseData<?> detail(@RequestBody NewsReq newsReq){
        News news = this.newsService.newsDetail(newsReq);
        return new SuccessResponseData<>(news);
    }
}

