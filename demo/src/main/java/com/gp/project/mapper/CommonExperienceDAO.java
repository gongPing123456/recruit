package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonExperience;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonExperienceDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonExperience record);

    int insertSelective(CommonExperience record);

    CommonExperience selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonExperience record);

    int updateByPrimaryKey(CommonExperience record);

	List<CommonExperience> getAll();
}