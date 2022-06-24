package com.example.demo.dao.mapper;

import com.example.demo.dao.pojo.BlogUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogUserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BlogUserDO record);

    int insertSelective(BlogUserDO record);

    BlogUserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BlogUserDO record);

    int updateByPrimaryKey(BlogUserDO record);
}