package com.zf.model;

import java.io.Serializable;
import java.util.Date;

public class Resume implements Serializable {
    private int id;
    private String birthPlace;
    private String birthday;
    private String nation;
    private String politicalStatus;
    private String healthy;
    private String marriage;
    private String education;
    private String major;
    private String school;
    private String competence;
    private String experience;
    private String award;
    private String selfComment;
    private String hobbyOrSpeciality;
    private int state;
    private User user;
    private Post post;
    private Date createTime;

    public Resume() {
    }

    public Resume(int id, String birthPlace, String birthday, String nation, String politicalStatus, String healthy, String marriage, String education, String major, String school, String competence, String experience, String award, String selfComment, String hobbyOrSpeciality, int state, User user, Post post, Date createTime) {
        this.id = id;
        this.birthPlace = birthPlace;
        this.birthday = birthday;
        this.nation = nation;
        this.politicalStatus = politicalStatus;
        this.healthy = healthy;
        this.marriage = marriage;
        this.education = education;
        this.major = major;
        this.school = school;
        this.competence = competence;
        this.experience = experience;
        this.award = award;
        this.selfComment = selfComment;
        this.hobbyOrSpeciality = hobbyOrSpeciality;
        this.state = state;
        this.user = user;
        this.post = post;
        this.createTime = createTime;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", birthPlace='" + birthPlace + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nation='" + nation + '\'' +
                ", politicalStatus='" + politicalStatus + '\'' +
                ", healthy='" + healthy + '\'' +
                ", marriage='" + marriage + '\'' +
                ", education='" + education + '\'' +
                ", major='" + major + '\'' +
                ", school='" + school + '\'' +
                ", competence='" + competence + '\'' +
                ", experience='" + experience + '\'' +
                ", award='" + award + '\'' +
                ", selfComment='" + selfComment + '\'' +
                ", hobbyOrSpeciality='" + hobbyOrSpeciality + '\'' +
                ", state=" + state +
                ", user=" + user +
                ", post=" + post +
                ", createTime=" + createTime +
                '}';
    }
}
