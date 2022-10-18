package cn.stylefeng.guns.modular.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.stylefeng.guns.core.exception.BusinessException;
import cn.stylefeng.guns.modular.demo.mapper.NewsMapper;
import cn.stylefeng.guns.modular.demo.model.Enum.CarExceptionEnum;
import cn.stylefeng.guns.modular.demo.model.Enum.DelFlagEnum;
import cn.stylefeng.guns.modular.demo.model.in.NewsReq;
import cn.stylefeng.guns.modular.demo.model.out.NewsRep;
import cn.stylefeng.roses.kernel.auth.api.SessionManagerApi;
import cn.stylefeng.roses.kernel.auth.api.context.LoginContext;
import cn.stylefeng.roses.kernel.auth.api.pojo.login.LoginUser;
import cn.stylefeng.roses.kernel.db.api.factory.PageFactory;
import cn.stylefeng.roses.kernel.db.api.factory.PageResultFactory;
import cn.stylefeng.roses.kernel.db.api.pojo.page.PageResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.stylefeng.guns.modular.demo.entity.News;
import cn.stylefeng.guns.modular.demo.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * (TNews)表服务实现类
 *
 * @author RestfulToolkitXCode
 * @since 2022-10-17 17:00:29
 */
@Service("newsService")
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {
    @Resource
    private SessionManagerApi sessionManagerApi;

    @Override
    public PageResult<News> page(NewsReq newsReq) {
        LoginUser loginUser = LoginContext.me().getLoginUser();
        String account = loginUser.getAccount();

        Page<News> page = this.page(PageFactory.defaultPage(), this.queryWrapper(newsReq));

        return PageResultFactory.createPageResult(page);
    }

    @Override
    public void add(NewsReq newsReq) {
        News news = new News();
        BeanUtil.copyProperties(newsReq, news);
        news.setNewsId(RandomUtil.randomLong(1000000000000000000L, 9000000000000000001L));
        this.save(news);
    }

    @Override
    public void edit(NewsReq newsReq) {
        News news = this.query(newsReq);
        BeanUtil.copyProperties(newsReq, news);
        this.updateById(news);
    }

    @Override
    public void batchDel(NewsReq newsReq) {
        List<Long> newsIds = newsReq.getNewsIds();
        Iterator<Long> iterator = newsIds.iterator();
        while (iterator.hasNext()) {
            Long newsId = iterator.next();
            NewsReq newsReqTemp = new NewsReq();
            newsReqTemp.setNewsId(newsId);
            News news = this.query(newsReq);
            news.setDelFlag(DelFlagEnum.Y.getCode());
            this.updateById(news);
        }
    }

    @Override
    public News newsDetail(NewsReq newsReq) {
        News news = this.getById(newsReq.getNewsId());
        if (BeanUtil.isEmpty(news)){
            throw new BusinessException(CarExceptionEnum.CAR_NOT_EXISTED);
        }
        return news;
    }

    private News query(NewsReq newsReq){
        News news = this.getById(newsReq.getNewsId());
        if (BeanUtil.isEmpty(news)){
            throw new BusinessException(CarExceptionEnum.CAR_NOT_EXISTED);
        }
        return news;
    }
    private LambdaQueryWrapper<News> queryWrapper(NewsReq newsReq){
        LambdaQueryWrapper<News> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(
                wrapper ->
                        wrapper.like(ObjectUtil.isNotEmpty(newsReq.getNewsTitle()), News::getNewsTitle, newsReq.getNewsTitle())
                                .ne(News::getDelFlag, DelFlagEnum.Y.getCode())
        );

        queryWrapper.orderByDesc(News::getNewsTitle);

        return queryWrapper;
    }
}

