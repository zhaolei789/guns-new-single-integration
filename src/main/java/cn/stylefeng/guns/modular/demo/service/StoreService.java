package cn.stylefeng.guns.modular.demo.service;

import cn.stylefeng.guns.modular.demo.entity.Store;
import cn.stylefeng.guns.modular.demo.model.in.StoreRequest;
import cn.stylefeng.guns.modular.demo.model.out.StoreResponse;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author krwz
* @description 针对表【t_store】的数据库操作Service
* @createDate 2022-09-30 16:45:50
*/
public interface StoreService extends IService<Store> {

    PageResult<Store> findListByPage(StoreRequest storeRequest);

    void add(StoreRequest storeRequest);

    void edit(StoreRequest storeRequest);

}
