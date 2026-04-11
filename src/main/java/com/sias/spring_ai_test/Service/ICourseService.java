package com.sias.spring_ai_test.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sias.spring_ai_test.entity.PO.Course;
import java.util.List;

public interface ICourseService extends IService<Course> {
    List<Course> queryCourseByType(String type);
    List<Course> queryCourseByEdu(Integer edu);
    List<Course> queryCourseByName(String name);
}