package cn.stylefeng.guns.modular.demo.controller;

import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
import cn.stylefeng.guns.modular.demo.model.out.CarManuResponse;
import cn.stylefeng.guns.modular.demo.service.CarManuService;
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

@RestController
@ApiResource(name = "车辆管理")
public class CarManuController {

    @Resource
    private CarManuService carManuService;

    /**
     * 车辆厂家管理-列表信息
     * @param carManuRequest
     * @return
     */
    @GetResource(
            name = "车辆厂家管理-列表信息",
            path = "/menu/menuList"
    )
    @BusinessLog
    public ResponseData<?> findManuList(CarManuRequest carManuRequest){
        return new SuccessResponseData<>(carManuService.findCarList(carManuRequest));
    }

    /**
     * 车辆厂家管理-分页查询
     * @param carManuRequest
     * @return
     */
    @GetResource(name = "车辆厂家管理-分页查询", path = "/menu/page")
    @BusinessLog
    public ResponseData<?> page(CarManuRequest carManuRequest){
        return new SuccessResponseData<>(carManuService.findListByPage(carManuRequest));
    }

    /**
     * 车辆厂家管理-新增
     * @param carManuRequest
     * @return
     */
    @PostResource(name = "车辆厂家管理-新增", path = "/menu/add")
    @BusinessLog
    public ResponseData<?> add(@RequestBody @Validated(BaseRequest.add.class) CarManuRequest carManuRequest){
        carManuService.add(carManuRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 车辆厂家管理-修改
     * @param carManuRequest
     * @return
     */
    @PostResource(name = "车辆厂家管理-修改", path = "/menu/edit")
    @BusinessLog
    public ResponseData<?> edit(@RequestBody @Validated(BaseRequest.edit.class) CarManuRequest carManuRequest){
        carManuService.edit(carManuRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 车辆厂家管理-删除
     * @param carManuRequest
     * @return
     */
    @PostResource(name = "车辆厂家管理-删除", path = "/menu/del")
    @BusinessLog
    public ResponseData<?> remove(@RequestBody @Validated(BaseRequest.delete.class) CarManuRequest carManuRequest){
        boolean del = carManuService.del(carManuRequest);
        return del? new SuccessResponseData<>() : new ErrorResponseData<>("err", "err");
    }

    /**
     * 批量删除车辆厂商信息
     * @param carManuRequest
     * @return
     */
    @PostResource(
            name = "批量删除车辆厂商信息",
            path = {"/menu/batchDelete"}
    )
    @BusinessLog
    public ResponseData<?> batchDelete(@RequestBody @Validated({BaseRequest.batchDelete.class}) CarManuRequest carManuRequest) {
        this.carManuService.batchDelete(carManuRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 更改厂商状态
     * @param carManuRequest
     * @return
     */
    @PostResource(
            name = "更改厂商状态",
            path = {"/menu/editStatus"}
    )
    @BusinessLog
    public ResponseData<?> editStatus(@RequestBody @Validated({BaseRequest.updateStatus.class}) CarManuRequest carManuRequest){
        this.carManuService.editStat(carManuRequest);
        return new SuccessResponseData<>();
    }

    /**
     * 详情
     * @param carManuRequest
     * @return
     */
    @PostResource(
            name = "详情",
            path = {"/menu/detail"}
    )
    @BusinessLog
    public ResponseData<?> detail(@RequestBody CarManuRequest carManuRequest){
        CarManuResponse detail = this.carManuService.detail(carManuRequest);
        return new SuccessResponseData<>(detail);
    }
}
