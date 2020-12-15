package com.jason.lee.mapper;

import com.jason.lee.entity.Brand;
import com.jason.lee.entity.Depart;
import org.apache.ibatis.annotations.Select;

/**
 * @author huanli9
 * @description
 * @date 2020/12/14 14:27
 */
public interface BrandMapper {

    Brand getBrandById(int brandId);

    Brand getBrandByIdPlus(int brandId);

    Brand getBrandStep(int brandId);
}
