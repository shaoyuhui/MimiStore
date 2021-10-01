package com.afterglowit.service.impl;

import com.afterglowit.mapper.ProductTypeMapper;
import com.afterglowit.pojo.ProductType;
import com.afterglowit.pojo.ProductTypeExample;
import com.afterglowit.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    //再业务逻辑层中一定会有数据访问层的对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAll() {
        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
