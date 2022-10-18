package cn.stylefeng.guns.modular.demo.service.impl;

import cn.stylefeng.guns.modular.demo.dao.NewsFileInfoDao;
import cn.stylefeng.guns.modular.demo.mapper.NewsFileInfoMapper;
import cn.stylefeng.guns.modular.demo.model.in.NewsFileInfoReq;
import cn.stylefeng.guns.modular.demo.model.out.NewsFileInfoRep;
import cn.stylefeng.guns.modular.demo.service.NewsFileInfoService;
import cn.stylefeng.roses.kernel.auth.api.context.LoginContext;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import cn.stylefeng.roses.kernel.file.api.util.PicFileTypeUtil;
import cn.stylefeng.roses.kernel.file.modular.service.SysFileInfoService;
import cn.stylefeng.roses.kernel.file.modular.service.impl.SysFileInfoServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件信息(NewsFileInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-10-18 17:29:59
 */
@Service("newsFileInfoService")
public class NewsFileInfoServiceImpl implements NewsFileInfoService {

    @Resource
    private NewsFileInfoMapper newsFileInfoMapper;

    @Resource
    private SysFileInfoServiceImpl sysFileInfoServiceImpl;

    @Override
    public PageResult<NewsFileInfoRep> page(NewsFileInfoReq newsFileInfoReq) {
        Page<NewsFileInfoRep> page = PageFactory.defaultPage();
        List<NewsFileInfoRep> list = this.newsFileInfoMapper.findInfoList(page, newsFileInfoReq);
        List<NewsFileInfoRep> collect = list.stream().filter((i) -> {
            return !"defaultAvatar.png".equals(i.getFileOriginName());
        }).collect(Collectors.toList());
        Iterator var5 = collect.iterator();
        while (var5.hasNext()) {
            NewsFileInfoRep newsFileInfoRepNext = (NewsFileInfoRep) var5.next();
            if (PicFileTypeUtil.getFileImgTypeFlag(newsFileInfoRepNext.getFileSuffix())){
                newsFileInfoRepNext.setFileUrl(sysFileInfoServiceImpl.getFileAuthUrl(newsFileInfoRepNext.getFileId()));
            }
        }
        return PageResultFactory.createPageResult(page.setRecords(collect));
    }
}
