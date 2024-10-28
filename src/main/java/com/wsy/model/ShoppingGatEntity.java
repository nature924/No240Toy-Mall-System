package com.wsy.model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.wsy.entity.BaseEntity;
import lombok.Data;
import com.wsy.table.ShoppingGatTable;


/**
 * 购物车
 * @author Wsy
 */
@Data
@TableName("shopping_gat")
public class ShoppingGatEntity extends BaseEntity {
  /**
   * 
   */
  @TableField(ShoppingGatTable.CUSTOMER_ID)
  private String customerId;
  /**
   * 
   */
  @TableField(ShoppingGatTable.SHOP_ID)
  private String shopId;
  /**
   * 数量
   */
  @TableField(ShoppingGatTable.NUM)
  private Integer num;

  @TableField(exist = false)
  private ShopEntity shopEntity;

  private String cid;

}
