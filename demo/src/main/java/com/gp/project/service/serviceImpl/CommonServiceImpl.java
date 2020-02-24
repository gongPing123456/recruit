package com.gp.project.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gp.project.common.Constants;
import com.gp.project.common.Result;
import com.gp.project.mapper.*;
import com.gp.project.pojo.Common.*;
import com.gp.project.pojo.vo.CityInfoVo;
import com.gp.project.service.CommonService;
import com.gp.project.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 城市信息 的 管理
 * @time 2020/2/23 11:13
 * @Author gp
 */
@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	CommonCityDAO commonCityDAO;
	@Autowired
	CommonCityProvinceDAO commonCityProvinceDAO;

	@Autowired
	CommonKeywordDAO commonKeywordDAO;

	@Autowired
	CommonEducationDAO commonEducationDAO;

	@Resource
	CommonSalaryDAO commonSalaryDAO;
	@Resource
	CommonWelfareDAO commonWelfareDAO;
	@Resource
	CommonExperienceDAO commonExperienceDAO;
	@Override
	public Result updateCommonCityInfo(String json) throws IOException {
		Result result=new Result();

		return result;
	}

	/**
	 * 跟新json文件
	 * @return
	 */
	@Override
	public Result setCityJSON() throws IOException {
		Result result = new Result();
		Result.success(result, alterJson(Constants.JSON_PATH+Constants.CITY_JSON,getAllCity()).getData());
		return result;
	}

	/**
	 * 更新关键字的json
	 * @return
	 */
	@Override
	public Result setKeyWord() {
		Result result=new Result();
		try {
			result= alterJson( Constants.JSON_PATH + Constants.KEYWORD_JSON,alterKeyWord());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Result setWelfareJSON() {
		Result result=new Result();
		try {
			result= alterJson( Constants.JSON_PATH + Constants.WELFARE_JSON,getWelfare());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Result setSalaryJSON() {
		Result result=new Result();
		try {
			result= alterJson( Constants.JSON_PATH + Constants.SALARY_JSON,getSalary());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Result setExperienceSON() {
		Result result=new Result();
		try {
			result= alterJson( Constants.JSON_PATH + Constants.EXPERIENCE_JSON,getExperience());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Result setEducationJSON() {
		Result result=new Result();
		try {
			result= alterJson( Constants.JSON_PATH + Constants.EDUCATION_JSON,getEducations());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 更新关键字
	 * @return
	 */
	private String alterKeyWord(){
		List<CommonKeyword> commonKeywords=commonKeywordDAO.getAllKeyWord();
		return JSON.toJSONString(commonKeywords);
	}

	/**
	 * 获取所有教育信息
	 * @return
	 */
	private String getEducations(){
		List<CommonEducation> commonEducations=commonEducationDAO.getAll();
		return JSON.toJSONString(commonEducations);
	}
	/**
	 * 获取所有 薪水信息
	 */
	private String getSalary(){
		List<CommonSalary> commonSalaries=commonSalaryDAO.getAll();
		return JSON.toJSONString(commonSalaries);
	}

	/**
	 * 获取所有福利信息
	 * @return
	 */
	private String getWelfare(){
		List<CommonWelfare> commonWelfares=commonWelfareDAO.getAll();
		return JSON.toJSONString(commonWelfares);
	}

	/**
	 * 获取所有经验
	 * @return
	 */
	private String getExperience(){
		List<CommonExperience> commonExperiences=commonExperienceDAO.getAll();
		return JSON.toJSONString(commonExperiences);
	}
	/**
	 * 获取所有的城市的json数据
	 * @return
	 */
	public String getAllCity(){
		List<CityInfoVo> cityInfoVoList=new ArrayList<>();
		List<CommonCityProvince> commonCityProvinces = commonCityProvinceDAO.selectAll();
		for (CommonCityProvince commonCityProvince:commonCityProvinces){
			CityInfoVo cityInfoVo=new CityInfoVo();
			List<CommonCity> commonCities=commonCityDAO.selectByProvinceId(commonCityProvince.getId());
			cityInfoVo.setCommonCityProvince(commonCityProvince);
			cityInfoVo.setCommonCities(commonCities);
			cityInfoVoList.add(cityInfoVo);
		}
//		return cityInfoVoList;
		return JSON.toJSONString(cityInfoVoList);
	}

	/**
	 * 更新 json文件
	 * @return
	 * @throws IOException
	 */
	public Result alterJson(String path, String json) throws IOException {
		Result result=new Result();
		//String allCity = getAllCity();
		CommonUtils.jsonFile(json, path);
//		List<CityInfoVo> cityInfoVoList=JSON.parseObject(allCity,List.class);
		result.setData(json);
		return result;
	}
}
