package com.qc.test.model;

/**
 * Created by duh on 2018/5/18 11:02.
 * Email:duh@elab-plus.com
 * Version:v1.0
 */
public enum  RelationEnum {
    ENUM1("爷爷"),
    ENUM2("爸爸"),
    ENUM3("兄弟"),
    ENUM4("哥哥"),
    ENUM5("弟弟"),
    ENUM6("儿子"),
    ENUM7("孙子"),
    ENUM8("老师"),
    ENUM9("同学"),
    ENUM10("学生")
            ;
    public String code;
    RelationEnum(String relation) {
        code = relation;
    }
}
