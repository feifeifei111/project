package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String birthPlace;
    private String birthday;
    private String nation;
    private String politicalStatus;
    private String healthy;
    private String marriage;
    private String education;
    private String phone;
    private String email;
    private String major;
    private String school;
    private String competence;
    private String post;
    private String experience;
    private String award;
    private String selfComment;
    private String hobbyOrSpeciality;
    private int state;
    private int userId;
    private int recruitId;
    private Date createTime;
    private String interviewTime;

    public Resume() {
    }

    public Resume(int id, String name, String sex, String birthPlace, String birthday, String nation, String politicalStatus, String healthy, String marriage, String education, String phone, String email, String major, String school, String competence, String post, String experience, String award, String selfComment, String hobbyOrSpeciality, int state, int userId, int recruitId, Date createTime, String interviewTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthPlace = birthPlace;
        this.birthday = birthday;
        this.nation = nation;
        this.politicalStatus = politicalStatus;
        this.healthy = healthy;
        this.marriage = marriage;
        this.education = education;
        this.phone = phone;
        this.email = email;
        this.major = major;
        this.school = school;
        this.competence = competence;
        this.post = post;
        this.experience = experience;
        this.award = award;
        this.selfComment = selfComment;
        this.hobbyOrSpeciality = hobbyOrSpeciality;
        this.state = state;
        this.userId = userId;
        this.recruitId = recruitId;
        this.createTime = createTime;
        this.interviewTime = interviewTime;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getHealthy() {
        return healthy;
    }

    public void setHealthy(String healthy) {
        this.healthy = healthy;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getSelfComment() {
        return selfComment;
    }

    public void setSelfComment(String selfComment) {
        this.selfComment = selfComment;
    }

    public String getHobbyOrSpeciality() {
        return hobbyOrSpeciality;
    }

    public void setHobbyOrSpeciality(String hobbyOrSpeciality) {
        this.hobbyOrSpeciality = hobbyOrSpeciality;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(int recruitId) {
        this.recruitId = recruitId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nation='" + nation + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", healthy='" + healthy + '\'' +
                ", marriage='" + marriage + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                ", competence='" + competence + '\'' +
                ", post='" + post + '\'' +
                ", experience='" + experience + '\'' +
                ", award='" + award + '\'' +
                ", selfComment='" + selfComment + '\'' +
                ", hobbyOrSpeciality='" + hobbyOrSpeciality + '\'' +
                ", state=" + state +
                ", userId=" + userId +
                ", recruitId=" + recruitId +
                ", createTime=" + createTime +
                ", interviewTime=" + interviewTime +
                '}';
    }
}
