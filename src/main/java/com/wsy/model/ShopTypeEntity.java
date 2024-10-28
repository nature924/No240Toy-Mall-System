package com.wsy.model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.wsy.entity.BaseEntity;
import lombok.Data;
import com.wsy.table.ShopTypeTable;


/**
 * 商品类型
 * @author Wsy
 */
@Data
@TableName("shop_type")
public class ShopTypeEntity extends BaseEntity{
  /**
   * 名称
   */
  @TableField(ShopTypeTable.NAME)
  private String name;
}
