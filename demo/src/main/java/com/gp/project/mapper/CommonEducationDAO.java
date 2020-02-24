package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonEducation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonEducationDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonEducation record);

    int insertSelective(CommonEducation record);

    CommonEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonEducation record);

    int updateByPrimaryKey(CommonEducation record);

	List<CommonEducation> getAll();
}