package com.wsy.entity;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;
import com.wsy.table.RoleTable;
import java.util.Date;


/**
 * 角色表
 * @author resource_sharing
 * @date 2019-12-31 11:38:39
 */
@Data
@TableName("role")
public class RoleEntity extends BaseEntity{
  /**
   * 角色名
   */
  @TableField(RoleTable.NAME)
  private String name;
  /**
   * 状态 1启用  0禁用
   */
  @TableField(RoleTable.STATUS)
  private Boolean status;
  /**
   * 添加时间
   */
  @TableField(RoleTable.TIME)
  private Date time;
}
