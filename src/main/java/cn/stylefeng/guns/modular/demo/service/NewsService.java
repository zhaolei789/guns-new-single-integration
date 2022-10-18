package cn.stylefeng.guns.modular.demo.service;

import cn.stylefeng.guns.modular.demo.model.in.NewsReq;
import cn.stylefeng.guns.modular.demo.model.out.NewsRep;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.stylefeng.guns.modular.demo.entity.News;

/**
 * (TNews)表服务接口
 *
 * @author RestfulToolkitXCode
 * @since 2022-10-17 17:00:29
 */
public interface NewsService extends IService<News> {

    PageResult<News> page(NewsReq newsReq);

    void add(NewsReq newsReq);

    void edit(NewsReq newsReq);

    void batchDel(NewsReq newsReq);

    News newsDetail(NewsReq newsReq);

}

