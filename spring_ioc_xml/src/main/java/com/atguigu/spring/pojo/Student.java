package com.atguigu.spring.pojo;

import java.util.Arrays;
import java.util.Map;

public class Student {

    private Integer sId;

    private String sName;

    private Integer age;

    private String gender;

    private double score;

    private Clazz clazz;

    private String[] hobby;

    public String[] getHobby() {
        return hobby;
    }

    private Map<String,Teacher> teacherMap;

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", clazz=" + clazz +
                ", hobby=" + Arrays.toString(hobby) +
                ", teacherMap=" + teacherMap +
                '}';
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(Integer sId, String sName, Integer age, String gender, double score, Clazz clazz) {
        this.sId = sId;
        this.sName = sName;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.clazz = clazz;
    }
}
