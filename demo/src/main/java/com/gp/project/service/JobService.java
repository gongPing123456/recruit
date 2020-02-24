package com.gp.project.service;

import com.gp.project.common.Result;

import java.io.IOException;

/**
 * @time 2020/2/22 21:24
 * @Author gp
 */
public interface JobService {
	/**
	 * 获取主页信息
	 * @param json
	 * @return
	 */
	Result homeInfo(String json);

	/**
	 * 所有Job的管理 修改
	 * @param json
	 * @return
	 */
	Result updateJobInfo(String json);
	/**
	 * 创建 job列表的json数据
	 * @return
	 */
	Result setJobJSON() throws IOException;

}
