package com.afterglowit.service;

import com.afterglowit.pojo.ProductInfo;
import com.afterglowit.pojo.vo.ProductInfoVo;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductInfoService {
    //显示全部商品（不分页
    List<ProductInfo> getAll();

    //实现分页功能
    PageInfo splitPage(int pageNum,int pageSize);

    //添加商品
    int save(ProductInfo info);

    //按主键id查询商品
    ProductInfo getById(int pid);

    //更新商品
    int update(ProductInfo info);

    //单个商品删除
    int delete(int pid);

    //批量删除商品
    int deleteBatch(String[] ids);

    //多条件商品查询
    List<ProductInfo> selectCondition(ProductInfoVo vo);
}
