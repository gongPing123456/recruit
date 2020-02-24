package com.gp.project.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * job_info
 * @author 
 */
public class JobInfo implements Serializable {
    private Integer id;

    /**
     * 职位名
     */
    private String jobName;

    /**
     * 岗位id
     */
    private Integer postId;

    /**
     * 企业id
     */
    private Integer companyId;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 经验要求id
     */
    private Integer experienceId;

    /**
     * 学历要求id
     */
    private Integer educationId;

    /**
     * 薪资下限 单位k
     */
    private Integer minSalary;

    /**
     * 薪资上限 单位k
     */
    private Integer maxSalary;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 修改时间
     */
    private Date updateTime; /**
     * 工作内容
     */
    private String jobContent;

    /**
     * 工作要求
     */
    private String jobRequirement;

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobRequirement() {
        return jobRequirement;
    }

    public void setJobRequirement(String jobRequirement) {
        this.jobRequirement = jobRequirement;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(Integer experienceId) {
        this.experienceId = experienceId;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        JobInfo other = (JobInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobName() == null ? other.getJobName() == null : this.getJobName().equals(other.getJobName()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getCompanyId() == null ? other.getCompanyId() == null : this.getCompanyId().equals(other.getCompanyId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getExperienceId() == null ? other.getExperienceId() == null : this.getExperienceId().equals(other.getExperienceId()))
            && (this.getEducationId() == null ? other.getEducationId() == null : this.getEducationId().equals(other.getEducationId()))
            && (this.getMinSalary() == null ? other.getMinSalary() == null : this.getMinSalary().equals(other.getMinSalary()))
            && (this.getMaxSalary() == null ? other.getMaxSalary() == null : this.getMaxSalary().equals(other.getMaxSalary()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobName() == null) ? 0 : getJobName().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getCompanyId() == null) ? 0 : getCompanyId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getExperienceId() == null) ? 0 : getExperienceId().hashCode());
        result = prime * result + ((getEducationId() == null) ? 0 : getEducationId().hashCode());
        result = prime * result + ((getMinSalary() == null) ? 0 : getMinSalary().hashCode());
        result = prime * result + ((getMaxSalary() == null) ? 0 : getMaxSalary().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobName=").append(jobName);
        sb.append(", postId=").append(postId);
        sb.append(", companyId=").append(companyId);
        sb.append(", cityId=").append(cityId);
        sb.append(", experienceId=").append(experienceId);
        sb.append(", educationId=").append(educationId);
        sb.append(", minSalary=").append(minSalary);
        sb.append(", maxSalary=").append(maxSalary);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}