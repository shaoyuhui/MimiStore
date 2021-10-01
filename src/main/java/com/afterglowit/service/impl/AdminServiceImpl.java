package com.afterglowit.service.impl;

import com.afterglowit.mapper.AdminMapper;
import com.afterglowit.pojo.Admin;
import com.afterglowit.pojo.AdminExample;
import com.afterglowit.service.AdminService;
import com.afterglowit.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //切记，在业务逻辑层中一定会有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String pwd) {
        //根据传入的用户名到DB中查询相应的对象
        //如果有条件则一定要创建AdminExample的对象，用来封装条件
        AdminExample example = new AdminExample();
        /**如何添加条件
         * select * from admin where a_name = 'admin'
         */
        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if(list.size() > 0){
            Admin admin = list.get(0);
            //如果查询到用户对象，再进行密码的比对，注意密码是密文
            String mipwd = MD5Util.getMD5(pwd);
            if(mipwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }
}
