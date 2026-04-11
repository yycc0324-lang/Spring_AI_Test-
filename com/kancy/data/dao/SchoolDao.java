package com.kancy.data.dao;

import lombok.extern.slf4j.Slf4j;
import com.kancy.data.entity.School;
import com.kancy.data.mapper.SchoolMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Repository;

/**
 * 校区表(school)数据DAO
 *
 * @author kancy
 * @since 2026-04-08 21:40:27
 * @description 由 Mybatisplus Code Generator 创建
 */
@Slf4j
@Repository
public class SchoolDao extends ServiceImpl<SchoolMapper, School> {

}