package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonJobFirstTitle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonJobFirstTitleDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonJobFirstTitle record);

    int insertSelective(CommonJobFirstTitle record);

    CommonJobFirstTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonJobFirstTitle record);

    int updateByPrimaryKey(CommonJobFirstTitle record);

	List<CommonJobFirstTitle> selectAll();
}