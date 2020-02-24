package com.gp.project.pojo.Common;

import java.io.Serializable;
import java.util.Date;

/**
 * common_job_second_title
 * @author 
 */
public class CommonJobSecondTitle implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 一级标题id
     */
    private Integer firTitleId;

    /**
     * 二级标题
     */
    private String secTitle;

    /**
     * 开启状态 0未开启 1开启
     */
    private Integer status;

    /**
     * 修改时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirTitleId() {
        return firTitleId;
    }

    public void setFirTitleId(Integer firTitleId) {
        this.firTitleId = firTitleId;
    }

    public String getSecTitle() {
        return secTitle;
    }

    public void setSecTitle(String secTitle) {
        this.secTitle = secTitle;
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
        CommonJobSecondTitle other = (CommonJobSecondTitle) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFirTitleId() == null ? other.getFirTitleId() == null : this.getFirTitleId().equals(other.getFirTitleId()))
            && (this.getSecTitle() == null ? other.getSecTitle() == null : this.getSecTitle().equals(other.getSecTitle()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFirTitleId() == null) ? 0 : getFirTitleId().hashCode());
        result = prime * result + ((getSecTitle() == null) ? 0 : getSecTitle().hashCode());
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
        sb.append(", firTitleId=").append(firTitleId);
        sb.append(", secTitle=").append(secTitle);
        sb.append(", status=").append(status);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}