package com.imblog.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imblog.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDaoTest {

    @Resource
    ArticleDao articleDao;
    @Test
    public void add() {
        Article article = new Article();
        article.setArticleId(2);
        article.setTitle("测试");
        article.setContent("1.用户信息模块：用户登录、修改密码，安全退出。\n" +
                "2.系统管理首页模块：导航栏、查看评论数、总文章数、分类数量、标签数量、友情链接数量。\n" +
                "3.标签管理模块：增加标签，删除标签，管理标签。\n" +
                "4.博客管理模块：博客首页，发布博客，删除博客、修改博客、查看博客信息，搜索博客信息。\n" +
                "5.博客分类模块：增加博客类型、修改博客类型、删除博客类型，查看博客类型。\n" +
                "6.系统配置模块：修改站点信息，修改个人信息，修改底部设置。\n" +
                "7.友情链接模块：增加链接、删除链接、修改链接、查看友情链接。\n" +
                "8. 评论模块：回复评论、删除评论、修改评论、查看评论。");
        int is = articleDao.insert(article);
        if (is != 0){
            System.out.println("新增成功");
        }
    }
    @Test
    public void query(){
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        long a = articleDao.selectCount(queryWrapper);
        System.out.println("总条目数量"+a);
        queryWrapper.eq("title","测试");
        articleDao.selectList(queryWrapper);
    }
}