package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonJobPost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonJobPostDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonJobPost record);

    int insertSelective(CommonJobPost record);

    CommonJobPost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonJobPost record);

    int updateByPrimaryKey(CommonJobPost record);

    /**
     * 获取 三级目录
     * @param id
     * @return
     */
	List<CommonJobPost> selectBySecondId(Integer id);
}