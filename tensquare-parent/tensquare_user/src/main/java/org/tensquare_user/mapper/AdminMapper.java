package org.tensquare_user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.tensquare_user.pojo.Admin;
@Mapper
public interface AdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}