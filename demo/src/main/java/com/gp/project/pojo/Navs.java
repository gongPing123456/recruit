package com.gp.project.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * navs
 * @author 
 */
public class Navs implements Serializable {
    private Integer id;

    /**
     * 左导航的名字
     */
    private String title;

    /**
     * 左导航的矢量图标
     */
    private String icon;

    /**
     * 链接的路径
     */
    private String href;

    private Boolean spread;

    /**
     * 父目录的id
     */
    private Integer subdirectory;

    /**
     * 是否为子目录   1表示true，0表示false
     */
    private Boolean isSubdirectory;

    /**
     * 新页面的打开方式
     */
    private String target;
    /**
     * 新增目录的等级  （分三级）
     */
    private  String level;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Navs> children=new ArrayList<>();

    public List<Navs> getChildren() {
        return children;
    }

    public void setChildren(List<Navs> children) {
        this.children = children;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public Integer getSubdirectory() {
        return subdirectory;
    }

    public void setSubdirectory(Integer subdirectory) {
        this.subdirectory = subdirectory;
    }

    public Boolean getIsSubdirectory() {
        return isSubdirectory;
    }

    public void setIsSubdirectory(Boolean isSubdirectory) {
        this.isSubdirectory = isSubdirectory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
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
        Navs other = (Navs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getIcon() == null ? other.getIcon() == null : this.getIcon().equals(other.getIcon()))
            && (this.getHref() == null ? other.getHref() == null : this.getHref().equals(other.getHref()))
            && (this.getSpread() == null ? other.getSpread() == null : this.getSpread().equals(other.getSpread()))
            && (this.getSubdirectory() == null ? other.getSubdirectory() == null : this.getSubdirectory().equals(other.getSubdirectory()))
            && (this.getIsSubdirectory() == null ? other.getIsSubdirectory() == null : this.getIsSubdirectory().equals(other.getIsSubdirectory()))
            && (this.getTarget() == null ? other.getTarget() == null : this.getTarget().equals(other.getTarget()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getIcon() == null) ? 0 : getIcon().hashCode());
        result = prime * result + ((getHref() == null) ? 0 : getHref().hashCode());
        result = prime * result + ((getSpread() == null) ? 0 : getSpread().hashCode());
        result = prime * result + ((getSubdirectory() == null) ? 0 : getSubdirectory().hashCode());
        result = prime * result + ((getIsSubdirectory() == null) ? 0 : getIsSubdirectory().hashCode());
        result = prime * result + ((getTarget() == null) ? 0 : getTarget().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", icon=").append(icon);
        sb.append(", href=").append(href);
        sb.append(", spread=").append(spread);
        sb.append(", subdirectory=").append(subdirectory);
        sb.append(", isSubdirectory=").append(isSubdirectory);
        sb.append(", target=").append(target);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}