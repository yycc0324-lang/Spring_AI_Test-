package com.kancy.data.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 校区表(school)实体类
 *
 * @author kancy
 * @since 2026-04-08 21:40:27
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("school")
public class School extends Model<School> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
	private Integer id;
    /**
     * 校区名称
     */
    private String name;
    /**
     * 校区所在城市
     */
    private String city;

}