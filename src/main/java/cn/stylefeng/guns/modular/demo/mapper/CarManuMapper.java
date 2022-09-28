package cn.stylefeng.guns.modular.demo.mapper;

import cn.stylefeng.guns.modular.demo.entity.CarManuEntity;
import cn.stylefeng.guns.modular.demo.model.in.CarManuRequest;
import cn.stylefeng.guns.modular.demo.model.out.CarManuResponse;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
public interface CarManuMapper extends BaseMapper<CarManuEntity> {

    CarManuResponse detail(@Param("manuId") Long manuId);

    Page<CarManuResponse> findListByPage(Page page, @Param("param") CarManuRequest carManuRequest);
}
