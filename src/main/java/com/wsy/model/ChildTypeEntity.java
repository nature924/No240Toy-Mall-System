package com.wsy.model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import com.wsy.entity.BaseEntity;
import lombok.Data;
import com.wsy.table.ChildTypeTable;


/**
 * 分类表
 * @author Wsy
 */
@Data
@TableName("child_type")
public class ChildTypeEntity extends BaseEntity{
  /**
   * 名称
   */
  @TableField(ChildTypeTable.NAME)
  private String name;
}
