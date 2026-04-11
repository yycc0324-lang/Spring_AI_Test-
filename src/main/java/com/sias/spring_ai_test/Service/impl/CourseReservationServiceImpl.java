package com.sias.spring_ai_test.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sias.spring_ai_test.Mapper.CourseReservationMapper;
import com.sias.spring_ai_test.Service.ICourseReservationService;
import com.sias.spring_ai_test.entity.PO.CourseReservation;
import org.springframework.stereotype.Service;

@Service
public class CourseReservationServiceImpl extends ServiceImpl<CourseReservationMapper, CourseReservation> implements ICourseReservationService {

}
