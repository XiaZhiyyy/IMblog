package com.imblog.pojo;

import lombok.Data;

@Data
public class SystemManagementInfo {

    //评论数
    private long commentCount;
    //总文章数
    private long articleCount;
    //分类数量
    private long categoryCount;
    //标签数量
    private long labelCount;
    //友情链接数量
    private long friendshipLinkCount;

    public SystemManagementInfo(long commentCount, long articleCount, long categoryCount, long labelCount, long friendshipLinkCount) {
        this.commentCount = commentCount;
        this.articleCount = articleCount;
        this.categoryCount = categoryCount;
        this.labelCount = labelCount;
        this.friendshipLinkCount = friendshipLinkCount;
    }
}




