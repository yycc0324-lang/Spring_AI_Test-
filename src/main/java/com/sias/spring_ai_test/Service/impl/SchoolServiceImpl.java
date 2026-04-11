package com.sias.spring_ai_test.Service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sias.spring_ai_test.Mapper.SchoolMapper;
import com.sias.spring_ai_test.Service.ISchoolService;
import com.sias.spring_ai_test.entity.PO.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {

}