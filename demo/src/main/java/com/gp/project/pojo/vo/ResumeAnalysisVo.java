package com.gp.project.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
/**
 * 接收简历  分析接口
 * @time 2020/2/18 15:00
 * @Author gp
 */
public class ResumeAnalysisVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @JSONField(name = "姓名")
    private String name;

    @JSONField(name = "性别")
    private String sex;

    @JSONField(name = "邮箱")
    private String email;

    @JSONField(name = "电话")
    private String mobile;

    @JSONField(name = "QQ号")
    private String qq;

    @JSONField(name = "出生年月")
    private String birth;

    @JSONField(name = "年龄")
    private String age;

    @JSONField(name = "现居住地")
    private String addressNow;

    @JSONField(name = "工作经验")
    private String experience;

    @JSONField(name = "期望薪资")
    private String salaryExpectation;

    @JSONField(name = "教育经历")
    private String eduExperience;

    @JSONField(name = "工作经历")
    private String jobExperience;

    @JSONField(name = "关键词")
    private String keyWord;

    @JSONField(name = "项目经验")
    private String projExperience;

    @JSONField(name = "自我评价")
    private String selfEvaluation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddressNow() {
        return addressNow;
    }

    public void setAddressNow(String addressNow) {
        this.addressNow = addressNow;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSalaryExpectation() {
        return salaryExpectation;
    }

    public void setSalaryExpectation(String salaryExpectation) {
        this.salaryExpectation = salaryExpectation;
    }

    public String getEduExperience() {
        return eduExperience;
    }

    public void setEduExperience(String eduExperience) {
        this.eduExperience = eduExperience;
    }

    public String getJobExperience() {
        return jobExperience;
    }

    public void setJobExperience(String jobExperience) {
        this.jobExperience = jobExperience;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getProjExperience() {
        return projExperience;
    }

    public void setProjExperience(String projExperience) {
        this.projExperience = projExperience;
    }

    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }

    @Override
    public String toString() {
        return "ResumeAnalysisVo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", qq='" + qq + '\'' +
                ", birth='" + birth + '\'' +
                ", age='" + age + '\'' +
                ", addressNow='" + addressNow + '\'' +
                ", experience='" + experience + '\'' +
                ", salaryExpectation='" + salaryExpectation + '\'' +
                ", eduExperience='" + eduExperience + '\'' +
                ", jobExperience='" + jobExperience + '\'' +
                ", keyWord='" + keyWord + '\'' +
                ", projExperience='" + projExperience + '\'' +
                ", selfEvaluation='" + selfEvaluation + '\'' +
                '}';
    }
}
