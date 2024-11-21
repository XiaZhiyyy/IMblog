package com.imblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imblog.dao.CommentDao;
import com.imblog.dao.ArticleDao;
import com.imblog.dao.CategoryDao;
import com.imblog.dao.LabelDao;
import com.imblog.dao.FriendshipLinkDao;
import com.imblog.pojo.*;
import com.imblog.service.SystemManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemManagementServiceImpl implements SystemManagementService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private FriendshipLinkDao friendshipLinkDao;

    @Override
    public SystemManagementInfo getSystemManagementInfo() {
//        QueryWrapper<Comment> q_com = new QueryWrapper<>();
//        long commentCount = commentDao.selectCount(q_com);

        QueryWrapper<Article> q_art = new QueryWrapper<>();
        long articleCount = articleDao.selectCount(q_art);

        QueryWrapper<Category> q_cat = new QueryWrapper<>();
        long categoryCount = categoryDao.selectCount(q_cat);

//        QueryWrapper<Label> q_lab = new QueryWrapper<>();
//        long labelCount = labelDao.selectCount(q_lab);
//
        QueryWrapper<FriendshipLink> q_fri = new QueryWrapper<>();
        long friendshipLinkCount = friendshipLinkDao.selectCount(q_fri);


        // 测试用数据
        long commentCount = 114514;
        long labelCount = 12;
        return new SystemManagementInfo(commentCount,  articleCount, categoryCount, labelCount, friendshipLinkCount);
    }
}

