package com.gp.project.mapper;

import com.gp.project.pojo.UserResumeInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResumeInfoDAO {
	/**
	 * 根据用户名查询  简历信息
	 * @param json
	 * @return
	 */
	UserResumeInfo  getResumeByName(String json);
/*    int deleteByPrimaryKey(Integer id);

    int insert(UserResumeInfoWithBLOBs record);

    int insertSelective(UserResumeInfoWithBLOBs record);

    UserResumeInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserResumeInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserResumeInfoWithBLOBs record);

    int updateByPrimaryKey(UserResumeInfo record);*/
}