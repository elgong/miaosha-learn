package top.elgong.entity;

import java.util.Date;

/**
 *  DataObject DO
 *   DO 仅仅是对数据库的映射, 不要在service 中传递到 前端，需要借助 Model 来传递
 */
public class UserDO {

    private Integer id;

    private String name;

    private Byte gender;

    private Integer age;

    private String telphone;

    private String regisitMode;

    private Integer thirdPartyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getRegisitMode() {
        return regisitMode;
    }

    public void setRegisitMode(String regisitMode) {
        this.regisitMode = regisitMode;
    }

    public Integer getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(Integer thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", telphone='" + telphone + '\'' +
                ", regisitMode='" + regisitMode + '\'' +
                ", thirdPartyId=" + thirdPartyId +
                '}';
    }
}
