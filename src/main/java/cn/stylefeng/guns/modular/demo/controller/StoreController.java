package cn.stylefeng.guns.modular.demo.controller;

import cn.stylefeng.guns.modular.demo.model.in.StoreRequest;
import cn.stylefeng.guns.modular.demo.service.StoreService;
import cn.stylefeng.roses.kernel.rule.annotation.BusinessLog;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@ApiResource(name = "门店管理")
public class StoreController {

    @Resource
    private StoreService storeService;

    @GetResource(name = "查看门店列表", path = "/store/page")
    @BusinessLog
    public ResponseData<?> page(StoreRequest storeRequest){
        return new SuccessResponseData<>(storeService.findListByPage(storeRequest));
    }

    @PostResource(name = "新增门店信息", path = "/store/add")
    public ResponseData<?> add(StoreRequest storeRequest){
        this.storeService.add(storeRequest);
        return new SuccessResponseData<>();
    }
}
