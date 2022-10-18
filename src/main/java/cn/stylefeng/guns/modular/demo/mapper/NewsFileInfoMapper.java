package cn.stylefeng.guns.modular.demo.mapper;

import cn.stylefeng.guns.modular.demo.entity.NewsFileInfo;
import cn.stylefeng.guns.modular.demo.model.in.NewsFileInfoReq;
import cn.stylefeng.guns.modular.demo.model.out.NewsFileInfoRep;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 文件信息(NewsFileInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-10-18 17:29:57
 */
public interface NewsFileInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param fileId 主键
     * @return 实例对象
     */
    NewsFileInfo queryById(Long fileId);

    /**
     * 查询指定行数据
     *
     * @param newsFileInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<NewsFileInfo> queryAllByLimit(NewsFileInfo newsFileInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param newsFileInfo 查询条件
     * @return 总行数
     */
    long count(NewsFileInfo newsFileInfo);

    /**
     * 新增数据
     *
     * @param newsFileInfo 实例对象
     * @return 影响行数
     */
    int insert(NewsFileInfo newsFileInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<NewsFileInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<NewsFileInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<NewsFileInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<NewsFileInfo> entities);

    /**
     * 修改数据
     *
     * @param newsFileInfo 实例对象
     * @return 影响行数
     */
    int update(NewsFileInfo newsFileInfo);

    /**
     * 通过主键删除数据
     *
     * @param fileId 主键
     * @return 影响行数
     */
    int deleteById(Long fileId);


    List<NewsFileInfoRep> findInfoList(@Param("page") Page<NewsFileInfoRep> page, @Param("newsFileInfoReq") NewsFileInfoReq newsFileInfoReq);

}

