package com.gp.project.pojo.Common;

import java.io.Serializable;
import java.util.Date;

/**
 * common_job_first_title
 * @author 
 */
public class CommonJobFirstTitle implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 1级标题
     */
    private String firTitle;

    /**
     * 是否热门 0非热门 1热门
     */
    private Integer hotStatus;

    /**
     * 开启状态 0未开启 1开启
     */
    private Integer status;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirTitle() {
        return firTitle;
    }

    public void setFirTitle(String firTitle) {
        this.firTitle = firTitle;
    }

    public Integer getHotStatus() {
        return hotStatus;
    }

    public void setHotStatus(Integer hotStatus) {
        this.hotStatus = hotStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        CommonJobFirstTitle other = (CommonJobFirstTitle) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFirTitle() == null ? other.getFirTitle() == null : this.getFirTitle().equals(other.getFirTitle()))
            && (this.getHotStatus() == null ? other.getHotStatus() == null : this.getHotStatus().equals(other.getHotStatus()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFirTitle() == null) ? 0 : getFirTitle().hashCode());
        result = prime * result + ((getHotStatus() == null) ? 0 : getHotStatus().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
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
        sb.append(", firTitle=").append(firTitle);
        sb.append(", hotStatus=").append(hotStatus);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}