package com.jason.lee.mapper;

import com.jason.lee.entity.Product;

import java.util.List;

/**
 * @author huanli9
 * @description
 * @date 2020/12/14 14:27
 */
public interface ProductMapper {

    Product getProductById(int id);

    Product getProductAndBrand(int id);

    Product getProductAndBrandStep(int id);

    List<Product> getProductsByBrandId(int brandId);

    Product getProduct(int id);

}
