package com.gp.project.service;

import com.alibaba.fastjson.JSONObject;
import com.gp.project.common.Result;
import com.gp.project.pojo.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

/**
 * @time 2020/1/16 15:24
 * @Author gp
 */
public interface UserService {
	Result login(String jsonObject, HttpServletRequest request) throws UnknownHostException;

	Result regist(String jsonObject);

	/**
	 * 简历分析
	 * @param file
	 * @return
	 */
	Result resumeAnalysis(MultipartFile file);

	/**
	 * 获取简历信息
	 * @param request
	 * @param json
	 * @return
	 */
	Result resumeView(String json ,HttpServletRequest request);
}
