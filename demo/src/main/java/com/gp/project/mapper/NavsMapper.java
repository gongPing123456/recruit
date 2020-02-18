package com.gp.project.mapper;

import com.gp.project.pojo.Navs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Navs record);

    int insertSelective(Navs record);

    Navs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Navs record);

    int updateByPrimaryKey(Navs record);

	List<Navs> selectAll();

	Navs selectByPrimaryKeySelective(Navs record);
}