package com.gp.project.mapper;


import com.gp.project.pojo.Common.CommonCity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonCityDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CommonCity record);

    int insertSelective(CommonCity record);

    CommonCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommonCity record);

    int updateByPrimaryKey(CommonCity record);

    /**
     * 根据province_id 查找二级城市的列表
     * @param id
     * @return
     */
	List<CommonCity> selectByProvinceId(Integer id);
}