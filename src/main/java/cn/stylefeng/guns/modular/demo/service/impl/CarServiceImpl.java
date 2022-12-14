package cn.stylefeng.guns.modular.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.stylefeng.guns.core.exception.BusinessException;
import cn.stylefeng.guns.modular.demo.entity.CarEntity;
import cn.stylefeng.guns.modular.demo.mapper.CarMapper;
import cn.stylefeng.guns.modular.demo.model.Enum.CarExceptionEnum;
import cn.stylefeng.guns.modular.demo.model.Enum.DelFlagEnum;
import cn.stylefeng.guns.modular.demo.model.in.CarRequest;
import cn.stylefeng.guns.modular.demo.service.CarService;
import cn.stylefeng.roses.kernel.auth.api.pojo.login.LoginUser;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.stylefeng.roses.kernel.auth.api.context.LoginContext;

import java.util.Iterator;
import java.util.List;
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, CarEntity> implements CarService {
    /**
     * 车辆管理-所有车辆列表
     * @param carRequest
     * @return
     */
    @Override
    public List<CarEntity> findCarList(CarRequest carRequest) {
        LambdaQueryWrapper<CarEntity> queryWrapper = this.queryList(carRequest);
        LoginUser loginUser = LoginContext.me().getLoginUser();
        log.debug("---" + loginUser.getUserId());
//        queryWrapper.like(ObjectUtil.isNotEmpty(carRequest.getCarName()), CarEntity::getCarName, carRequest.getCarName());
//        queryWrapper.like(ObjectUtil.isNotEmpty(carRequest.getCarColor()), CarEntity::getCarColor, carRequest.getCarColor());
        queryWrapper.and(
                wrapper ->
                        wrapper.like(ObjectUtil.isNotEmpty(carRequest.getCarName()), CarEntity::getCarName, carRequest.getCarName())
                                .eq(ObjectUtil.isNotEmpty(carRequest.getCarColor()), CarEntity::getCarColor, carRequest.getCarColor())
                                .ne(CarEntity::getDelFlag, DelFlagEnum.Y.getCode())
        );
        return this.list(queryWrapper);
    }

    /**
     * 车辆管理-分页查询
     * @param carRequest
     * @return
     */
    @Override
    public PageResult<CarEntity> findListByPage(CarRequest carRequest) {
        LambdaQueryWrapper<CarEntity> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.and(wapper->wapper.like())
        Page<CarEntity> page  = this.page(PageFactory.defaultPage(), this.queryList(carRequest));
        PageResult<CarEntity> pageResult = PageResultFactory.createPageResult(page);
        return pageResult;
    }

    /**
     * 车辆管理-新增
     * @param carRequest
     * @return
     */
    @Override
    public boolean add(CarRequest carRequest) {
        CarEntity carEntity = new CarEntity();
        BeanUtil.copyProperties(carRequest, carEntity);
        carEntity.setCarId(RandomUtil.randomLong(1000000000000000000L, 9000000000000000001L));
        this.save(carEntity);
        return true;
    }

    /**
     * 车辆管理-修改
     * @param carRequest
     */
    @Override
    public void edit(CarRequest carRequest) {
        CarEntity carEntity = this.queryCar(carRequest);
        BeanUtil.copyProperties(carRequest, carEntity);
        this.updateById(carEntity);
    }

    /**
     * 车辆管理-删除
     * @param carRequest
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean del(CarRequest carRequest) {
        CarEntity carEntity = this.queryCar(carRequest);
//        boolean delFlag = this.removeById(carEntity.getCarId());
        carEntity.setDelFlag(DelFlagEnum.Y.getCode());
        return this.updateById(carEntity);
    }

    /**
     * 车辆管理-批量删除
     * @param carRequest
     */
    @Override
    public void batchDelete(CarRequest carRequest) {
        List<Long> carIds = carRequest.getCarIds();
        Iterator<Long> var3 = carIds.iterator();

        while (var3.hasNext()) {
            Long carId = (Long) var3.next();
            CarRequest tempCarReq = new CarRequest();
            tempCarReq.setCarId(carId);
            this.del(tempCarReq);
        }
    }

    /**
     * 车辆详情
     * @param carRequest
     * @return
     */
    @Override
    public CarEntity carDetail(CarRequest carRequest) {
        CarEntity car = this.getById(carRequest.getCarId());
        if (BeanUtil.isEmpty(car)){
            throw new BusinessException(CarExceptionEnum.CAR_NOT_EXISTED);
        }
        return car;
    }

    private CarEntity queryCar(CarRequest carRequest){
        CarEntity carEntity = this.getById(carRequest.getCarId());
        if (BeanUtil.isEmpty(carEntity)){
            throw new BusinessException(CarExceptionEnum.CAR_NOT_EXISTED);
        }
        return carEntity;
    }

    private LambdaQueryWrapper<CarEntity> queryList(CarRequest carRequest){
        LambdaQueryWrapper<CarEntity> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.like(ObjectUtil.isNotEmpty(carRequest.getCarName()), CarEntity::getCarName, carRequest.getCarName());
        queryWrapper.and(
                wrapper ->
                        wrapper.like(ObjectUtil.isNotEmpty(carRequest.getCarName()), CarEntity::getCarName, carRequest.getCarName())
                                .eq(ObjectUtil.isNotEmpty(carRequest.getCarColor()), CarEntity::getCarColor, carRequest.getCarColor())
                                .ne(CarEntity::getDelFlag, DelFlagEnum.Y.getCode())
        );
        queryWrapper.orderByDesc(CarEntity::getCarName);
        return queryWrapper;
    }
}
