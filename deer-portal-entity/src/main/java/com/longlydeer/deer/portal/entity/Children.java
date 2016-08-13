package com.longlydeer.deer.portal.entity;

import com.longlydeer.deer.common.annotation.EntityInfo;
import com.longlydeer.deer.common.annotation.Meaning;
import com.longlydeer.deer.common.entity.BaseEntity;

import javax.validation.constraints.NotNull;

@EntityInfo("孩子")
public class Children extends BaseEntity{
    private static final long serialVersionUID = 5094108001951849690L;

    @Meaning("中文名")
    private String chineseName;
    @Meaning("中文名")
    private String englishName;
    @Meaning("性别")
    private Boolean gender;
    @Meaning("年纪")
    private Integer age;
    @Meaning("会员")
    private Long memberId;

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
