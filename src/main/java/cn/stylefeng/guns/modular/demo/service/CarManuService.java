package cn.stylefeng.guns.modular.demo.service;

import cn.stylefeng.guns.modular.demo.entity.CarManuEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
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
    PageResult<CarManuEntity> findListByPage(CarManuRequest carManuRequest);

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

    boolean del(CarManuRequest carManuRequest);

    void batchDelete(CarManuRequest carManuRequest);

    CarManuEntity carDetail(CarManuRequest carManuRequest);

    void editStat(CarManuRequest carManuRequest);

}
