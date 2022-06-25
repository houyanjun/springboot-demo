package com.example.demo.service.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.dao.mapper.BlogUserDOMapper;
import com.example.demo.dao.mapper.UserInfoDOMapper;
import com.example.demo.dao.pojo.BlogUserDO;
import com.example.demo.dao.pojo.UserInfoDO;
import com.example.demo.service.biz.BlogUserBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogUserBizServiceImpl implements BlogUserBizService {

    @Autowired
    private BlogUserDOMapper blogUserDOMapper;

    @Autowired
    private UserInfoDOMapper userInfoDOMapper;

    @Override
    public String get() {
        BlogUserDO blogUserDO = blogUserDOMapper.selectByPrimaryKey(1L);
        UserInfoDO userInfoDO = userInfoDOMapper.selectByPrimaryKey(1L);

        Page<UserInfoDO> page = new Page<>(1, 5);
        LambdaQueryWrapper<UserInfoDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfoDO::getId,1);
        IPage<UserInfoDO> userInfoDOIPage = userInfoDOMapper.selectPage(page, queryWrapper);
        return "success";
    }
}
