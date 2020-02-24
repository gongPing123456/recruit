package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonJobSecondTitle;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonJobSecondTitleDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonJobSecondTitle record);

    int insertSelective(CommonJobSecondTitle record);

    CommonJobSecondTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonJobSecondTitle record);

    int updateByPrimaryKey(CommonJobSecondTitle record);

    /**
     * 根据 job第一目录id 查找二级目录的列表
     * @param id
     * @return
     */
	List<CommonJobSecondTitle> selectFirstId(Integer id);
}