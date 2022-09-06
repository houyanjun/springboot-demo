package com.ux168.platform.infrastructure.persistence.mysql.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ux168.platform.infrastructure.persistence.mysql.dao.pojo.UserInfoDO;

public interface UserInfoDOMapper extends BaseMapper<UserInfoDO> {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

    UserInfoDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfoDO record);

    int updateByPrimaryKey(UserInfoDO record);
}