package com.gp.project.service;

import com.gp.project.common.Result;

import java.io.IOException;

/**
 * @time 2020/2/23 11:13
 * @Author gp
 */
public interface CommonService {

	/**
	 * 修改城市信息
	 * @param json
	 * @return
	 */
	Result updateCommonCityInfo(String json) throws IOException;

	/**
	 * 更新城市的json
	 * @return
	 */
	Result setCityJSON() throws IOException;

	/**
	 * 更新关键字的json
	 * @return
	 */
	Result setKeyWord();

	Result setWelfareJSON();

	Result setSalaryJSON();

	Result setExperienceSON();

	Result setEducationJSON();
}
