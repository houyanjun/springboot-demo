package com.ux168.platform.domain.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ux168.platform.domain.blog.service.BlogUserBizService;
import com.ux168.platform.infrastructure.persistence.mysql.dao.mapper.BlogUserDOMapper;
import com.ux168.platform.infrastructure.persistence.mysql.dao.mapper.UserInfoDOMapper;
import com.ux168.platform.infrastructure.persistence.mysql.dao.pojo.BlogUserDO;
import com.ux168.platform.infrastructure.persistence.mysql.dao.pojo.UserInfoDO;
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
