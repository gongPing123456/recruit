package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonSalary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonSalaryDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonSalary record);

    int insertSelective(CommonSalary record);

    CommonSalary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonSalary record);

    int updateByPrimaryKey(CommonSalary record);

	List<CommonSalary> getAll();
}