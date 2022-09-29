package cn.stylefeng.guns.modular.demo.mapper;

import cn.stylefeng.guns.modular.demo.entity.CarManuEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
import cn.stylefeng.guns.modular.demo.model.out.CarManuResponse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
public interface CarManuMapper extends BaseMapper<CarManuEntity> {

    /**
     * 详情
     * @param manuId
     * @return
     */
    CarManuResponse detail(@Param("manuId") Long manuId);

    /**
     * 列表查询
     * @param page
     * @param carManuRequest
     * @return
     */
    Page<CarManuResponse> findListByPage(Page page, @Param("param") CarManuRequest carManuRequest);
}
