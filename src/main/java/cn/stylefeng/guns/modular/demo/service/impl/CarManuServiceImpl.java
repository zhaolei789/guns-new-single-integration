package cn.stylefeng.guns.modular.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.stylefeng.guns.core.exception.BusinessException;
import cn.stylefeng.guns.modular.demo.entity.CarManuEntity;
import cn.stylefeng.guns.modular.demo.mapper.CarManuMapper;
import cn.stylefeng.guns.modular.demo.model.Enum.CarExceptionEnum;
import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
import cn.stylefeng.guns.modular.demo.service.CarManuService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.system.api.exception.SystemModularException;
import cn.stylefeng.roses.kernel.system.modular.user.entity.SysUser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class CarManuServiceImpl extends ServiceImpl<CarManuMapper, CarManuEntity> implements CarManuService {


    private LambdaQueryWrapper<CarManuEntity> queryList(CarManuRequest carManuRequest){
        LambdaQueryWrapper<CarManuEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CarManuEntity::getIsDelete, 0);
        queryWrapper.like(ObjectUtil.isNotEmpty(carManuRequest.getManuName()), CarManuEntity::getManuName, carManuRequest.getManuName());
        queryWrapper.orderByDesc(CarManuEntity::getManuName);
        return queryWrapper;
    }

    private CarManuEntity query(CarManuRequest carManuRequest){
        CarManuEntity carManuEntity = this.getById(carManuRequest.getManuId());
        if (BeanUtil.isEmpty(carManuEntity)){
            throw new BusinessException(CarExceptionEnum.CAR_NOT_EXISTED);
        }
        return carManuEntity;
    }

    @Override
    public List<CarManuEntity> findCarList(CarManuRequest carManuRequest) {
        LambdaQueryWrapper<CarManuEntity> queryWrapper = this.queryList(carManuRequest);
        return this.list(queryWrapper);
    }

    @Override
    public PageResult<CarManuEntity> findListByPage(CarManuRequest carManuRequest) {
        Page<CarManuEntity> page = this.page(PageFactory.defaultPage(), this.queryList(carManuRequest));
        PageResult<CarManuEntity> pageResult = PageResultFactory.createPageResult(page);
        return pageResult;
    }

    @Override
    public void add(CarManuRequest carManuRequest) {
        CarManuEntity carManuEntity = new CarManuEntity();
        BeanUtil.copyProperties(carManuRequest, carManuEntity);
        carManuEntity.setManuId(RandomUtil.randomLong(1000000000000000000L, 9000000000000000001L));
        this.save(carManuEntity);
    }

    @Override
    public void edit(CarManuRequest carManuRequest) {
        CarManuEntity carManuEntity = this.query(carManuRequest);
        BeanUtil.copyProperties(carManuRequest, carManuEntity);
        this.updateById(carManuEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean del(CarManuRequest carManuRequest) {
        CarManuEntity carManuEntity = this.query(carManuRequest);
        carManuEntity.setIsDelete(1);
        boolean removeFlag = this.updateById(carManuEntity);
        return removeFlag;
    }

    @Override
    public void batchDelete(CarManuRequest carManuRequest) {
        List<Long> manuIds = carManuRequest.getManuIds();
        Iterator<Long> var3 = manuIds.iterator();
        while (var3.hasNext()) {
            Long manuId = (Long) var3.next();
            CarManuRequest temp = new CarManuRequest();
            temp.setManuId(manuId);
            boolean del = this.del(temp);
        }

    }

    @Override
    public CarManuEntity carDetail(CarManuRequest carManuRequest) {
        return null;
    }

    @Override
    public void editStat(CarManuRequest carManuRequest) {
        Integer statusFlag = carManuRequest.getStatusFlag();
        CarManuEntity carManu = this.query(carManuRequest);
        Long manuId = carManu.getManuId();
        LambdaUpdateWrapper<CarManuEntity> updateWrapper = new LambdaUpdateWrapper();
        updateWrapper.eq(CarManuEntity::getManuId, manuId).and((i) -> {
            LambdaUpdateWrapper var1000 =  i.ne(CarManuEntity::getIsDelete, 1);
        }).set(CarManuEntity::getStatusFlag, statusFlag);
        boolean update = this.update(updateWrapper);
        if (!update){
            log.error(CarExceptionEnum.UPDATE_STATUS_ERROR.getUserTip());
            throw new SystemModularException(CarExceptionEnum.UPDATE_STATUS_ERROR);
        }
    }
}
