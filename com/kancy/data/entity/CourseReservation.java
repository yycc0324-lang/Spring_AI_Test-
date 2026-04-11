package com.kancy.data.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (course_reservation)实体类
 *
 * @author kancy
 * @since 2026-04-08 21:40:27
 * @description 由 Mybatisplus Code Generator 创建
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("course_reservation")
public class CourseReservation extends Model<CourseReservation> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId
	private Integer id;
    /**
     * 预约课程
     */
    private String course;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 联系方式
     */
    private String contactInfo;
    /**
     * 预约校区
     */
    private String school;
    /**
     * 备注
     */
    private String remark;

}