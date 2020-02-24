package com.gp.project.controller;

import com.gp.project.common.Result;
import com.gp.project.service.CommonService;
import com.gp.project.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 常用信息管理
 * @time 2020/2/23 11:17
 * @Author gp
 */
@RestController
@RequestMapping("/common")
public class CommonController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	CommonService commonService;


	/**
	 * 修改城市信息
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateCommonCityInfo")
	public Result updateCommonCityInfo(String json) throws IOException {
		long begin =System.currentTimeMillis();
		Result result= commonService.updateCommonCityInfo(json);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"修改城市信息操作");
		return result;
	}

	/**
	 * 更新city分类列表
	 * @return
	 */
	@RequestMapping("/setCityJSON")
	public Result setCityJSON() throws IOException {
		long begin =System.currentTimeMillis();
		Result result= commonService.setCityJSON();
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"修改城市json信息操作");
		return result;
	}

	/**
	 * 设置关键字的json
	 * @return
	 */
	@RequestMapping("/setKeyWordJSON")
	public Result setKeyWord(){
		long begin =System.currentTimeMillis();
		Result result= commonService.setKeyWord();
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"修改关键字json信息操作");
		return result;
	}

	/**
	 * 设置福利的json
	 * @return
	 */
	@RequestMapping("/setWelfareJSON")
	public Result setWelfareJSON(){
		long begin =System.currentTimeMillis();
		Result result= commonService.setWelfareJSON();
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"设置福利的json");
		return result;
	}

	/**
	 * 设置 薪水的json
	 * @return
	 */
	@RequestMapping("/setSalaryJSON")
	public Result setSalaryJSON(){
		long begin =System.currentTimeMillis();
		Result result= commonService.setSalaryJSON();
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"设置 薪水的json");
		return result;
	}

	/**
	 * 设置经验的json
	 * @return
	 */
	@RequestMapping("/setExperienceSON")
	public Result setExperienceSON(){
		long begin =System.currentTimeMillis();
		Result result= commonService.setExperienceSON();
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"设置经验的json");
		return result;
	}

	/**
	 * 设置教育的json
	 * @return
	 */
	@RequestMapping("/setEducationJSON")
	public Result setEducationJSON(){
		long begin =System.currentTimeMillis();
		Result result= commonService.setEducationJSON();
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"设置教育的json");
		return result;
	}
}
