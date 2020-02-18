package com.gp.project.service;

import com.gp.project.common.Result;
import com.gp.project.pojo.Navs;

import java.util.List;

/**
 * @time 2019/11/12 16:17
 * @Author gp
 */
public interface NavsService {
	/**
	 * 获取 左导航菜单的列表
	 * @return
	 */
	List<Navs> getServiceList();

	/**
	 * 新增导航信息
	 * @return
	 */
	Result addNavs(Navs navs);

	/**
	 * 获取
	 * @param navs
	 * @return
	 */
	Navs getNavs(Navs navs);
}
