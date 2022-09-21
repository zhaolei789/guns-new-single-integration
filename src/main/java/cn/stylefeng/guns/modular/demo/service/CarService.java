package cn.stylefeng.guns.modular.demo.service;

import cn.stylefeng.guns.modular.demo.entity.CarEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarRequest;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface CarService extends IService<CarEntity> {

    /**
     * 车辆管理-所有车辆列表
     * @param carRequest
     * @return
     */
    List<CarEntity> findCarList(CarRequest carRequest);

    /**
     * 车辆管理-分页查询
     * @param carRequest
     * @return
     */
    PageResult<CarEntity> findListByPage(CarRequest carRequest);

    /**
     * 车辆管理-新增
     * @param carRequest
     * @return
     */
    boolean add(CarRequest carRequest);

    /**
     * 车辆管理-修改
     * @param carRequest
     */
    void edit(CarRequest carRequest);

    boolean del(CarRequest carRequest);
}
