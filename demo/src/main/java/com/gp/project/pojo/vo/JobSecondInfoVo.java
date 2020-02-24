package com.gp.project.pojo.vo;

import com.gp.project.pojo.Common.CommonJobPost;
import com.gp.project.pojo.Common.CommonJobSecondTitle;

import java.io.Serializable;
import java.util.List;

/**
 * job 二级目录
 * @time 2020/2/23 19:21
 * @Author gp
 */
public class JobSecondInfoVo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 二级目录
	private CommonJobSecondTitle commonJobSecondTitle;

	//三级目录
	private List<CommonJobPost> commonJobPost;

	public CommonJobSecondTitle getCommonJobSecondTitle() {
		return commonJobSecondTitle;
	}

	public void setCommonJobSecondTitle(CommonJobSecondTitle commonJobSecondTitle) {
		this.commonJobSecondTitle = commonJobSecondTitle;
	}

	public List<CommonJobPost> getCommonJobPost() {
		return commonJobPost;
	}

	public void setCommonJobPost(List<CommonJobPost> commonJobPost) {
		this.commonJobPost = commonJobPost;
	}
}
