package com.gp.project.controller;

import com.gp.project.common.Result;
import com.gp.project.pojo.Navs;
import com.gp.project.service.NavsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @time 2019/11/12 16:16
 * @Author gp
 * 主要是对左部导航的管理
 */
@RequestMapping("/manage")
@RestController
@CrossOrigin
public class ManageController {
	@Autowired
	NavsService  navsService;

	/**
	 * 获取目录信息
	 * @return
	 */
	@RequestMapping("/getNavs")
	public List<Navs> getNavs(){
		return  navsService.getServiceList();
	}

	/**
	 * 增加目录信息
	 * @param navs
	 * @return
	 */
	@RequestMapping("/addNavs")
	public  Result addNavs(Navs navs,String onelevelTitle,String onelevelIcon){
		/*
		添加新的一级目录
		 */
		if (onelevelIcon != null && onelevelTitle!= null){
			Navs oneNavs=new Navs();
			oneNavs.setTitle(onelevelTitle);
			oneNavs.setIcon(onelevelIcon);
			navsService.addNavs(oneNavs);
			Navs navId=navsService.getNavs(oneNavs);
			navs.setSubdirectory(navId.getId());
		}
		Result result=navsService.addNavs(navs);
		return result;}

}
