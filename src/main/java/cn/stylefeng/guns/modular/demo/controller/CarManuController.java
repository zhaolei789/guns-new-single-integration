package cn.stylefeng.guns.modular.demo.controller;

import cn.stylefeng.guns.modular.demo.entity.CarEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
import cn.stylefeng.guns.modular.demo.model.in.CarRequest;
import cn.stylefeng.guns.modular.demo.service.CarManuService;
import cn.stylefeng.guns.modular.demo.service.CarService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.dict.modular.entity.SysDict;
import cn.stylefeng.roses.kernel.dict.modular.pojo.request.DictRequest;
import cn.stylefeng.roses.kernel.dict.modular.service.DictService;
import cn.stylefeng.roses.kernel.rule.annotation.BusinessLog;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
import cn.stylefeng.roses.kernel.rule.pojo.response.ErrorResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
import cn.stylefeng.roses.kernel.scanner.api.annotation.ApiResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.GetResource;
import cn.stylefeng.roses.kernel.scanner.api.annotation.PostResource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@ApiResource(name = "车辆管理")
public class CarManuController {

    @Resource
    private CarManuService carManuService;
    @Resource
    private DictService dictService;

    @GetResource(
            name = "车辆厂家管理-列表信息",
            path = "/menu/menuList"
    )
    @BusinessLog
    public ResponseData<?> findManuList(CarManuRequest carManuRequest){
        return new SuccessResponseData<>(carManuService.findCarList(carManuRequest));
    }

    @GetResource(name = "车辆厂家管理-分页查询", path = "/menu/page")
    @BusinessLog
    public ResponseData<?> page(CarManuRequest carManuRequest){
        return new SuccessResponseData<>(carManuService.findListByPage(carManuRequest));
    }

    @PostResource(name = "车辆厂家管理-新增", path = "/menu/add")
    @BusinessLog
    public ResponseData<?> add(CarManuRequest carManuRequest){
        carManuService.add(carManuRequest);
        return new SuccessResponseData<>();
    }

    @PostResource(name = "车辆厂家管理-修改", path = "/menu/edit")
    @BusinessLog
    public ResponseData<?> edit(CarManuRequest carManuRequest){
        carManuService.edit(carManuRequest);
        return new SuccessResponseData<>();
    }

    @PostResource(name = "车辆厂家管理-删除", path = "/menu/del")
    @BusinessLog
    public ResponseData<?> remove(CarManuRequest carManuRequest){
        boolean del = carManuService.del(carManuRequest);
        return del? new SuccessResponseData<>() : new ErrorResponseData<>("err", "err");
    }
}
