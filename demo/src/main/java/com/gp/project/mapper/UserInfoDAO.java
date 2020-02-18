package com.gp.project.mapper;

import com.gp.project.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 根据name查询userInfo
     * @param loginName
     * @return
     */
	UserInfo selectByUserName( @Param("loginName")String loginName);
}