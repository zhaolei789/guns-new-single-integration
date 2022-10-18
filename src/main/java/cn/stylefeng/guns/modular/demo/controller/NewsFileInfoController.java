package cn.stylefeng.guns.modular.demo.controller;

import cn.stylefeng.guns.modular.demo.model.in.NewsFileInfoReq;
import cn.stylefeng.guns.modular.demo.model.out.NewsFileInfoRep;
import cn.stylefeng.guns.modular.demo.service.NewsFileInfoService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文件信息(NewsFileInfo)表控制层
 *
 * @author makejava
 * @since 2022-10-18 17:29:57
 */
@RestController
@RequestMapping("newsFileInfo")
public class NewsFileInfoController {
    /**
     * 服务对象
     */
    @Resource
    private NewsFileInfoService newsFileInfoService;

    @GetResource(
            name = "分页查看文件信息",
            path = {"/fileInfoListPage"},
            requiredPermission = false
    )
    public ResponseData<PageResult<NewsFileInfoRep>> fileInfoListPage(NewsFileInfoReq newsFileInfoReq){
        return new SuccessResponseData<>(this.newsFileInfoService.page(newsFileInfoReq));
    }

}

