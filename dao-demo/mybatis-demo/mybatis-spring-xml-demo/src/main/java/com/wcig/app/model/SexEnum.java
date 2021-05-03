package com.wcig.app.model;

public enum SexEnum {
    MALE("m", "男"),
    FEMAILE("f", "女");

    private String val;
    private String desc;

    SexEnum(String val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static SexEnum ofSex(String val) {
        if (val.equals(MALE.getVal())) {
            return MALE;
        } else if (val.equals(FEMAILE.val)) {
            return FEMAILE;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SexEnum{" +
                "val='" + val + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
