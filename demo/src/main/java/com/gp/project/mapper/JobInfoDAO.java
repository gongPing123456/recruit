package com.gp.project.mapper;

import com.gp.project.pojo.JobInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface JobInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKeyWithBLOBs(JobInfo record);

    int updateByPrimaryKey(JobInfo record);
}