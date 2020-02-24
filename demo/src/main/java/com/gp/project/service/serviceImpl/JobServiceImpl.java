package com.gp.project.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gp.project.common.Constants;
import com.gp.project.common.Result;
import com.gp.project.mapper.CommonJobFirstTitleDAO;
import com.gp.project.mapper.CommonJobPostDAO;
import com.gp.project.mapper.CommonJobSecondTitleDAO;
import com.gp.project.mapper.JobInfoDAO;
import com.gp.project.pojo.Common.CommonJobFirstTitle;
import com.gp.project.pojo.Common.CommonJobPost;
import com.gp.project.pojo.Common.CommonJobSecondTitle;
import com.gp.project.pojo.vo.CityInfoVo;
import com.gp.project.pojo.vo.JobInfoVo;
import com.gp.project.pojo.vo.JobSecondInfoVo;
import com.gp.project.service.JobService;
import com.gp.project.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @time 2020/2/22 21:24
 * @Author gp
 */
@Service
public class JobServiceImpl implements JobService {
	@Autowired
	JobInfoDAO jobInfoDAO;
	@Autowired
	CommonJobFirstTitleDAO commonJobFirstTitleDAO;
	@Autowired
	CommonJobSecondTitleDAO commonJobSecondTitleDAO;
	@Autowired
	CommonJobPostDAO commonJobPostDAO;

	/**
	 * 获取主页信息
	 * @param json
	 * @return
	 */
	@Override
	public Result homeInfo(String json) {
		return null;
	}

	@Override
	public Result updateJobInfo(String json) {
		return null;
	}
	/**
	 * 创建 job列表的json数据
	 * @return
	 */
	@Override
	public Result setJobJSON() throws IOException {
		Result result = alterJob();
		return result;
	}

	/**
	 * 获取所有的job列表
	 * @return
	 */

	public String getAllJobs(){
		List<JobInfoVo> jobInfoVoList=new ArrayList<>();
		List<CommonJobFirstTitle> commonJobFirstTitles=commonJobFirstTitleDAO.selectAll();
		for (CommonJobFirstTitle commonJobFirstTitle:commonJobFirstTitles){
			JobInfoVo firstJob=new JobInfoVo();
			List<JobSecondInfoVo> jobSecondInfoVos=new ArrayList<>();
			List<CommonJobSecondTitle> commonJobSecondTitles=commonJobSecondTitleDAO.selectFirstId(commonJobFirstTitle.getId());

			for (CommonJobSecondTitle commonJobSecondTitle:commonJobSecondTitles){

				JobSecondInfoVo jobSecondInfoVo=new JobSecondInfoVo();
				//三级目录
				List<CommonJobPost> commonJobPosts=commonJobPostDAO.selectBySecondId(commonJobSecondTitle.getId());
				jobSecondInfoVo.setCommonJobSecondTitle(commonJobSecondTitle);
				jobSecondInfoVo.setCommonJobPost(commonJobPosts);

				jobSecondInfoVos.add(jobSecondInfoVo);
			}
			firstJob.setCommonJobFirstTitle(commonJobFirstTitle);
			firstJob.setJobSecondInfoVos(jobSecondInfoVos);

			jobInfoVoList.add(firstJob);
		}


		return JSON.toJSONString(jobInfoVoList);
	}

	/**
	 * 更新job的json文件
	 * @return
	 * @throws IOException
	 */
	private Result alterJob() throws IOException {
		Result result=new Result();
		String allJobs = getAllJobs();
		CommonUtils.jsonFile(allJobs, Constants.JSON_PATH+Constants.JOB_JSON);
		
		List<JobInfoVo> jobInfoVoList=JSON.parseObject(allJobs,List.class);

		Result.success(result,jobInfoVoList);
		return result;
	}
}
