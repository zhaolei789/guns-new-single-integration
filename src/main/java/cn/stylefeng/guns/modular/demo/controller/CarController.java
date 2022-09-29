package cn.stylefeng.guns.modular.demo.controller;

import cn.stylefeng.guns.modular.demo.entity.CarEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarRequest;
import cn.stylefeng.guns.modular.demo.service.CarService;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.dict.modular.entity.SysDict;
import cn.stylefeng.roses.kernel.dict.modular.pojo.request.DictRequest;
import cn.stylefeng.roses.kernel.dict.modular.service.DictService;
import cn.stylefeng.roses.kernel.rule.annotation.BusinessLog;
import cn.stylefeng.roses.kernel.rule.pojo.request.BaseRequest;
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
public class CarController {

    @Resource
    private CarService carService;
    @Resource
    private DictService dictService;

    /**
     * 车辆管理-所有车辆列表
     * @param carRequest
     * @return
     */
    @GetResource(name = "车辆管理-所有车辆列表", path = "/car/findList", requiredLogin = false, requiredPermission = false)
    @BusinessLog
    public ResponseData<List<CarEntity>> list(CarRequest carRequest){
        return new SuccessResponseData<>(carService.findCarList(carRequest));
    }

    /**
     * 车辆管理-分页查询
     * @param carRequest
     * @return
     */
    @GetResource(name = "车辆管理-分页查询", path = "/car/findListByPage")
    @BusinessLog
    public ResponseData<PageResult<CarEntity>> findListByPage(CarRequest carRequest){
        return new SuccessResponseData<>(carService.findListByPage(carRequest));
    }

    /**
     * 车辆管理-新增
     * @param carRequest
     * @return
     */
    @PostResource(name = "车辆管理-新增", path = "/car/addCar")
    @BusinessLog
    public ResponseData<String> add(@RequestBody @Validated(BaseRequest.add.class) CarRequest carRequest){
        boolean addFlag = this.carService.add(carRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 车辆管理-修改
     * @param carRequest
     * @return
     */
    @PostResource(name = "车辆管理-修改", path = "/car/editCar")
    @BusinessLog
    public ResponseData<String> edit(@RequestBody @Validated(BaseRequest.edit.class) CarRequest carRequest){
        carService.edit(carRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 车辆管理-删除
     * @param carRequest
     * @return
     */
    @PostResource(name = "车辆管理-删除", path = "/car/delCar")
    @BusinessLog
    public ResponseData<Boolean> del(@RequestBody @Validated(BaseRequest.delete.class) CarRequest carRequest){
        boolean del = carService.del(carRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 批量删除车辆信息
     * @param carRequest
     * @return
     */
    @PostResource(
            name = "批量删除车辆信息",
            path = {"/car/batchDelete"}
    )
    @BusinessLog
    public ResponseData<?> batchDelete(@RequestBody @Validated({BaseRequest.batchDelete.class}) CarRequest carRequest){
        this.carService.batchDelete(carRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 获取系统配置分组字典列表
     * @param dictRequest
     * @return
     */
    @GetResource(
            name = "获取系统配置分组字典列表",
            path = {"/car/getCarGroupDict"}
    )
    public ResponseData<PageResult<SysDict>> getCarGroupDict(DictRequest dictRequest) {
        dictRequest.setDictTypeCode("car_type");
        PageResult<SysDict> page = this.dictService.findPage(dictRequest);
        return new SuccessResponseData<>(page);
    }

    /**
     * 查看车辆详情信息
     * @param carRequest
     * @return
     */
    @PostResource(
            name = "查看车辆详情信息",
            path = {"/car/detail"}
    )
    @BusinessLog
    public ResponseData<?> detail(@RequestBody CarRequest carRequest){
        CarEntity car = this.carService.carDetail(carRequest);
        return new SuccessResponseData<>(car);
    }
}
