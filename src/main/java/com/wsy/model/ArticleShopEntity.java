package com.wsy.model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.wsy.entity.BaseEntity;
import lombok.Data;
import com.wsy.table.ArticleShopTable;
import java.util.Date;


/**
 * 文章商品表
 * @author Wsy
 */
@Data
@TableName("article_shop")
public class ArticleShopEntity extends BaseEntity{
  /**
   * 文章ID
   */
  @TableField(ArticleShopTable.ARTICLE_ID)
  private String articleId;
  /**
   * 商品ID
   */
  @TableField(ArticleShopTable.SHOP_ID)
  private String shopId;
  /**
   * 时间
   */
  @TableField(ArticleShopTable.TIME)
  private Date time;
}
