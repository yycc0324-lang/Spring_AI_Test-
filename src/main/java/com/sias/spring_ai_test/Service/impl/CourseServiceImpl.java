package com.sias.spring_ai_test.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sias.spring_ai_test.Mapper.CourseMapper;
import com.sias.spring_ai_test.Service.ICourseService;
import com.sias.spring_ai_test.entity.PO.Course;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Override
    public List<Course> queryCourseByType(String type) {
        return this.query().eq("type", type).list();
    }

    @Override
    public List<Course> queryCourseByEdu(Integer edu) {
        return this.query().le("edu", edu).list();
    }

    @Override
    public List<Course> queryCourseByName(String name) {
        return this.query().like("name", name).list();
    }
}