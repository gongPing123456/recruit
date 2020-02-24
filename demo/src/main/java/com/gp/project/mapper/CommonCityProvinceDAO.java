package com.gp.project.mapper;

import com.gp.project.pojo.Common.CommonCityProvince;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonCityProvinceDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonCityProvince record);

    int insertSelective(CommonCityProvince record);

    CommonCityProvince selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonCityProvince record);

    int updateByPrimaryKey(CommonCityProvince record);
    List<CommonCityProvince> selectAll();
}