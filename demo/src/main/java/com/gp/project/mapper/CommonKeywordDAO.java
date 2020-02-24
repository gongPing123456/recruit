package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonKeyword;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonKeywordDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonKeyword record);

    int insertSelective(CommonKeyword record);

    CommonKeyword selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonKeyword record);

    int updateByPrimaryKey(CommonKeyword record);

	List<CommonKeyword> getAllKeyWord();

}