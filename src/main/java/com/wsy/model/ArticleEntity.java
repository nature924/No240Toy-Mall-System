package com.wsy.model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.wsy.entity.BaseEntity;
import lombok.Data;
import com.wsy.table.ArticleTable;
import java.util.Date;


/**
 * 文章表
 * @author Wsy
 */
@Data
@TableName("article")
public class ArticleEntity extends BaseEntity{
  /**
   * 标题
   */
  @TableField(ArticleTable.TITLE)
  private String title;
  /**
   * 摘要
   */
  @TableField(ArticleTable.SUMMARY)
  private String summary;
  /**
   * 内容
   */
  @TableField(ArticleTable.CONTENT)
  private String content;
  /**
   * 二级分类ID
   */
  @TableField(ArticleTable.CHILD_TYPE)
  private String childType;
  /**
   * 客户ID
   */
  @TableField(ArticleTable.CUSTOMER_ID)
  private String customerId;
  /**
   * 发布时间
   */
  @TableField(ArticleTable.TIME)
  private Date time;
  /**
   * 0 带审核 1 审核通过   2审核拒绝
   */
  @TableField(ArticleTable.STATUS)
  private Integer status;
  /**
   * 检查结果
   */
  @TableField(ArticleTable.CHECK_RESULT)
  private String checkResult;
  /**
   * 是否置顶
   */
  @TableField(ArticleTable.TOP)
  private Boolean top;
  /**
   * 封面也有可能是封面视频
   */
  @TableField(ArticleTable.COVER)
  private String cover;
  /**
   * 热度
   */
  @TableField(ArticleTable.HOT)
  private Integer hot;

  @TableField(exist = false)
  private String customerName;

  @TableField(exist = false)
  private String childName;

  private String label;

  private String vedio;

  @TableField("shop_ids")
  private String shopIds;

  @TableField(exist = false)
  private CustomerEntity customerEntity;
}
