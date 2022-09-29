package cn.stylefeng.guns.modular.demo.service;

import cn.stylefeng.guns.modular.demo.entity.CarManuEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
import cn.stylefeng.guns.modular.demo.model.out.CarManuResponse;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CarManuService extends IService<CarManuEntity> {

    /**
     * 车辆管理-所有车辆列表
     * @param carManuRequest
     * @return
     */
    List<CarManuEntity> findCarList(CarManuRequest carManuRequest);

    /**
     * 车辆管理-分页查询
     * @param carManuRequest
     * @return
     */
    PageResult<CarManuResponse> findListByPage(CarManuRequest carManuRequest);

    /**
     * 车辆管理-新增
     * @param carManuRequest
     * @return
     */
    void add(CarManuRequest carManuRequest);

    /**
     * 车辆管理-修改
     * @param carManuRequest
     */
    void edit(CarManuRequest carManuRequest);

    /**
     * 车辆厂家管理-删除
     * @param carManuRequest
     * @return
     */
    boolean del(CarManuRequest carManuRequest);

    /**
     * 批量删除车辆厂商信息
     * @param carManuRequest
     * @return
     */
    void batchDelete(CarManuRequest carManuRequest);

    /**
     * 更改厂商状态
     * @param carManuRequest
     * @return
     */
    void editStat(CarManuRequest carManuRequest);

    /**
     * 详情
     * @param carManuRequest
     * @return
     */
    CarManuResponse detail(CarManuRequest carManuRequest);

}
