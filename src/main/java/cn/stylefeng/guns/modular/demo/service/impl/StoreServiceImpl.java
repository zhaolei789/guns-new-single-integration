package cn.stylefeng.guns.modular.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.stylefeng.guns.modular.demo.entity.CarEntity;
import cn.stylefeng.guns.modular.demo.entity.Store;
import cn.stylefeng.guns.modular.demo.mapper.StoreMapper;
import cn.stylefeng.guns.modular.demo.model.in.StoreRequest;
import cn.stylefeng.guns.modular.demo.model.out.StoreResponse;
import cn.stylefeng.guns.modular.demo.service.CarService;
import cn.stylefeng.guns.modular.demo.service.StoreService;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author krwz
* @description 针对表【t_store】的数据库操作Service实现
* @createDate 2022-09-30 16:45:50
*/
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

    @Override
    public PageResult<Store> findListByPage(StoreRequest storeRequest) {
        LambdaQueryWrapper<Store> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(
                wrapper ->
                        wrapper.like(ObjectUtil.isNotEmpty(storeRequest.getStoreName()), Store::getStoreName, storeRequest.getStoreName())
        );
        Page<Store> page = this.page(PageFactory.defaultPage(), queryWrapper);
        PageResult<Store> pageResult = PageResultFactory.createPageResult(page);
        return pageResult;
    }

    @Override
    public void add(StoreRequest storeRequest) {
        Store store = new Store();
        BeanUtil.copyProperties(storeRequest, store);
        store.setStoreId(RandomUtil.randomLong(1000000000000000000L, 9000000000000000001L));
        this.save(store);
    }

    @Override
    public void edit(StoreRequest storeRequest) {

    }

    public Store queryStore(){
        return null;
    }
}
