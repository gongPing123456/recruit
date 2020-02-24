package com.gp.project.controller;

import com.gp.project.common.Result;
import com.gp.project.service.CommonService;
import com.gp.project.service.JobService;
import com.gp.project.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * job的各种信息
 * 前端主页的各种信息
 * @time 2020/2/22 21:22
 * @Author gp
 */
@RestController
@RequestMapping("/job")
public class JobInfoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(JobInfoController.class);

	@Autowired
	JobService jobService;
	@Autowired
	CommonService commonService;

	/**
	 * 获取主页信息  主要包括Job 信息
	 * @param json
	 * @return
	 */
	@RequestMapping("/homeInfo")
	public Result homeInfo(@RequestBody String json){
		long begin =System.currentTimeMillis();
		Result result=jobService.homeInfo(json);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"获取主页信息操作");
		return result;
	}

	/**
	 * 所有Job 分类的管理修改
	 * @param json
	 * @return
	 */
	@RequestMapping("/updateJobInfo")
	public Result updateJobInfo(@RequestBody  String json){
		long begin =System.currentTimeMillis();
		Result result=jobService.updateJobInfo(json);
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"获取主页信息操作");
		return result;
	}

	/**
	 * 创建 job列表的json数据
	 * @return
	 */
	@RequestMapping("/setJobJSON")
	public Result setJobJSON(){
		long begin =System.currentTimeMillis();
		Result result= null;
		try {
			result = jobService.setJobJSON();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LOGGER.info("在"+ DateUtils.stampToDate(String.valueOf(begin))+"获取主页信息操作");
		return result;

	}


}
