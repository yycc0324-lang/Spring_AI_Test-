package com.kancy.data.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 学科表(course)实体类
 *
 * @author kancy
 * @since 2026-04-08 21:40:27
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("course")
public class Course extends Model<Course> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId
	private Integer id;
    /**
     * 学科名称
     */
    private String name;
    /**
     * 学历背景要求：0-无，1-初中，2-高中、3-大专、4-本科以上
     */
    private Integer edu;
    /**
     * 课程类型：编程、设计、自媒体、其它
     */
    private String type;
    /**
     * 课程价格
     */
    private Long price;
    /**
     * 学习时长，单位: 天
     */
    private Integer duration;

}