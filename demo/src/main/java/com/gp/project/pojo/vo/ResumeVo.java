package com.gp.project.pojo.vo;

import java.io.Serializable;

/**
 * 远程简历接口类
 * @time 2020/2/18 15:00
 * @Author gp
 */
public class ResumeVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int status;
	private ResumeAnalysisVo data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public ResumeAnalysisVo getData() {
		return data;
	}

	public void setData(ResumeAnalysisVo data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResumeVo{" +
				"status=" + status +
				", data=" + data +
				'}';
	}
}
