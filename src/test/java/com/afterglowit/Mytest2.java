package com.afterglowit;

import com.afterglowit.mapper.ProductInfoMapper;
import com.afterglowit.pojo.ProductInfo;
import com.afterglowit.pojo.vo.ProductInfoVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext_dao.xml","classpath:applicationContext_service.xml"})
public class Mytest2 {
    @Autowired
    ProductInfoMapper productInfoMapper;

    @Test
    public void testSelectCondition(){
        ProductInfoVo vo = new ProductInfoVo();
        vo.setPname("1");
        vo.setTypeid(2);
        vo.setHprice(4000);
        vo.setLprice(3300);
        List<ProductInfo> list = productInfoMapper.selectCondition(vo);
        for (ProductInfo productInfo : list) {
            System.out.println(productInfo);
        }
        //list.forEach(productInfo -> System.out.println(productInfo));
    }
}
