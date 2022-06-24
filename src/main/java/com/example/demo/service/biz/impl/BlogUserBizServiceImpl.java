package com.example.demo.service.biz.impl;

import com.example.demo.dao.mapper.BlogUserDOMapper;
import com.example.demo.dao.pojo.BlogUserDO;
import com.example.demo.service.biz.BlogUserBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogUserBizServiceImpl implements BlogUserBizService {

    @Autowired
    private BlogUserDOMapper blogUserDOMapper;

    @Override
    public String get() {
        BlogUserDO blogUserDO = blogUserDOMapper.selectByPrimaryKey(1L);
        return "success";
    }
}
