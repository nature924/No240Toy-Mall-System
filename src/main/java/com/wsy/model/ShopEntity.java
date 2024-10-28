package com.wsy.model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.wsy.entity.BaseEntity;
import lombok.Data;
import com.wsy.table.ShopTable;
import java.math.BigDecimal;


/**
 * 商品表
 * @author Wsy
 */
@Data
@TableName("shop")
public class ShopEntity extends BaseEntity{
  @Override
  public String toString() {
    return "ShopEntity{" +
            "name='" + name + '\'' +
            ", summery='" + summery + '\'' +
            ", content='" + content + '\'' +
            ", typeId='" + typeId + '\'' +
            ", cover='" + cover + '\'' +
            ", price=" + price +
            ", discountPrice=" + discountPrice +
            ", score=" + score +
            ", stock=" + stock +
            ", status=" + status +
            ", hot=" + hot +
            ", label='" + label + '\'' +
            ", royalty=" + royalty +
            '}';
  }

  /**
   * 商品名称
   */
  @TableField(ShopTable.NAME)
  private String name;
  /**
   * 简单描述
   */
  @TableField(ShopTable.SUMMERY)
  private String summery;
  /**
   * 内容
   */
  @TableField(ShopTable.CONTENT)
  private String content;
  /**
   * 类型ID
   */
  @TableField(ShopTable.TYPE_ID)
  private String typeId;
  /**
   * 封面
   */
  @TableField(ShopTable.COVER)
  private String cover;
  /**
   * 
   */
  @TableField(ShopTable.PRICE)
  private BigDecimal price;
  /**
   * 折扣价格
   */
  @TableField(ShopTable.DISCOUNT_PRICE)
  private BigDecimal discountPrice;
  /**
   * 评分
   */
  @TableField(ShopTable.SCORE)
  private Double score;
  /**
   * 库存剩余
   */
  @TableField(ShopTable.STOCK)
  private Integer stock;

  private Boolean status;

  private boolean hot;

  private String label;

  private BigDecimal royalty;
}
