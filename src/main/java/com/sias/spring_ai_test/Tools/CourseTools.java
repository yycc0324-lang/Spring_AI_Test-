package com.sias.spring_ai_test.Tools;

import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.sias.spring_ai_test.Service.ICourseReservationService;
import com.sias.spring_ai_test.Service.ICourseService;
import com.sias.spring_ai_test.Service.ISchoolService;
import com.sias.spring_ai_test.entity.PO.Course;
import com.sias.spring_ai_test.entity.PO.CourseReservation;
import com.sias.spring_ai_test.entity.PO.School;
import com.sias.spring_ai_test.entity.query.CourseQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;
import java.util.List;

//把这个类给Bean自动创建对象吧，方便
@RequiredArgsConstructor
@Component
public class CourseTools {
    private final ICourseService courseService;
    private final ISchoolService schoolService;
    private final ICourseReservationService courseReservationService;

    @Tool(description = "查询课程信息")
    //此处使用Mybatis-plus去写的可读性差，可以使用传统写法，反正都是简单的CURD
    public List<Course> queryCourse(@ToolParam(description = "查询的条件") CourseQuery query) {
        QueryChainWrapper<Course> wrapper = courseService.query();

        wrapper
                .eq(query.getType() != null, "type", query.getType())
                .le(query.getEdu() != null, "edu", query.getEdu());

        if (query.getSorts() != null) {
            for (CourseQuery.Sort sort : query.getSorts()) {
                wrapper.orderBy(true, sort.getAsc(), sort.getField());
            }

        }
        return wrapper.list();
    }

    @Tool(description = "查询所有校区")
    public List<School> queryAllSchools() {
        return schoolService.list();
    }

    @Tool(description = "按课程类型查询课程")
    public List<Course> queryCourseByType(@ToolParam(description = "课程类型，如：编程、设计、自媒体") String type) {
        return courseService.queryCourseByType(type);
    }

    @Tool(description = "按学历要求查询课程")
    public List<Course> queryCourseByEdu(@ToolParam(description = "学历要求：0-无，1-初中，2-高中、3-大专、4-本科以上") Integer edu) {
        return courseService.queryCourseByEdu(edu);
    }

    @Tool(description = "按课程名称查询课程")
    public List<Course> queryCourseByName(@ToolParam(description = "课程名称关键词") String name) {
        return courseService.queryCourseByName(name);
    }

    @Tool(description = "给客户预约试听课")
    public String generateCourseReservation(
            @ToolParam(description = "预约课程") String course,
            @ToolParam(description = "学生姓名") String studentName,
            @ToolParam(description = "联系电话") String contactInfo,
            @ToolParam(description = "预约校区") String school,
            @ToolParam(description = "预约备注", required = false) String remark) {
        CourseReservation courseReservation = new CourseReservation();
        courseReservation.setCourse(course);
        courseReservation.setStudentName(studentName);
        courseReservation.setContactInfo(contactInfo);
        courseReservation.setSchool(school);
        courseReservation.setRemark(remark);
        courseReservationService.save(courseReservation);
        return String.valueOf(courseReservation.getId());
    }


    public String testDatabaseConnection() {
        try {
            long schoolCount = schoolService.count();
            long courseCount = courseService.count();
            return String.format("数据库连接正常！校区数量：%d，课程数量：%d", schoolCount, courseCount);
        } catch (Exception e) {
            return "数据库连接失败：" + e.getMessage();
        }
    }
}
