package com.gp.project.pojo.vo;

import com.gp.project.pojo.Common.CommonJobFirstTitle;
import com.gp.project.pojo.Common.CommonJobSecondTitle;

import java.io.Serializable;
import java.util.List;

/**
 * job 的页面列表
 * @time 2020/2/23 19:18
 * @Author gp
 */
public class JobInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;

	//一级目录
	private CommonJobFirstTitle commonJobFirstTitle;

	//二级目录
	private List<JobSecondInfoVo> jobSecondInfoVos;

	public CommonJobFirstTitle getCommonJobFirstTitle() {
		return commonJobFirstTitle;
	}

	public void setCommonJobFirstTitle(CommonJobFirstTitle commonJobFirstTitle) {
		this.commonJobFirstTitle = commonJobFirstTitle;
	}

	public List<JobSecondInfoVo> getJobSecondInfoVos() {
		return jobSecondInfoVos;
	}

	public void setJobSecondInfoVos(List<JobSecondInfoVo> jobSecondInfoVos) {
		this.jobSecondInfoVos = jobSecondInfoVos;
	}
}
