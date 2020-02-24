package com.gp.project.mapper;

import com.gp.project.pojo.Common.CompanyInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}