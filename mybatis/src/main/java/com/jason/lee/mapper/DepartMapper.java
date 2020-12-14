package com.jason.lee.mapper;

import com.jason.lee.entity.Depart;
import org.apache.ibatis.annotations.Select;

/**
 * @author huanli9
 * @description
 * @date 2020/12/14 14:27
 */
public interface DepartMapper {

    @Select("select * from dept where dept_id = #{deptId}")
    Depart getDeptById(int deptId);
}
