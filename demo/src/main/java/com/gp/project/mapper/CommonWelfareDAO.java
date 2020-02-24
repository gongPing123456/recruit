package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonWelfare;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonWelfareDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonWelfare record);

    int insertSelective(CommonWelfare record);

    CommonWelfare selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonWelfare record);

    int updateByPrimaryKey(CommonWelfare record);

	List<CommonWelfare> getAll();
}