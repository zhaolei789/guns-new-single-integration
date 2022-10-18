package cn.stylefeng.guns.modular.demo.service;

import cn.stylefeng.guns.modular.demo.entity.NewsFileInfo;
import cn.stylefeng.guns.modular.demo.model.in.NewsFileInfoReq;
import cn.stylefeng.guns.modular.demo.model.out.NewsFileInfoRep;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 文件信息(NewsFileInfo)表服务接口
 *
 * @author makejava
 * @since 2022-10-18 17:29:59
 */
public interface NewsFileInfoService {

    PageResult<NewsFileInfoRep> page(NewsFileInfoReq newsFileInfoReq);

}
