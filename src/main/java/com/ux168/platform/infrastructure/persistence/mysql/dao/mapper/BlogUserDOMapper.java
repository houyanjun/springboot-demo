package com.ux168.platform.infrastructure.persistence.mysql.dao.mapper;

import com.ux168.platform.infrastructure.persistence.mysql.dao.pojo.BlogUserDO;

public interface BlogUserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlogUserDO record);

    int insertSelective(BlogUserDO record);

    BlogUserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogUserDO record);

    int updateByPrimaryKey(BlogUserDO record);
}