package com.gp.project.pojo.vo;

import com.gp.project.pojo.Common.CommonCity;
import com.gp.project.pojo.Common.CommonCityProvince;

import java.io.Serializable;
import java.util.List;

/**
 * 城市的信息
 * @time 2020/2/23 11:23
 * @Author gp
 */
public class CityInfoVo  implements Serializable {
	// 一级城市信息
  private  CommonCityProvince commonCityProvince;

    // 一级城市下的二级城市
  private List<CommonCity>	commonCities;

  private static final long serialVersionUID = 1L;

	public CommonCityProvince getCommonCityProvince() {
		return commonCityProvince;
	}

	public void setCommonCityProvince(CommonCityProvince commonCityProvince) {
		this.commonCityProvince = commonCityProvince;
	}

	public List<CommonCity> getCommonCities() {
		return commonCities;
	}

	public void setCommonCities(List<CommonCity> commonCities) {
		this.commonCities = commonCities;
	}
}
