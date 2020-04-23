package top.elgong.controller.viewobject;

/**
 *  ViewObject 真正返回给前端的数据
 */
public class UserVo {

    private Long id;
    private String nickname;
    private Integer gender;
    private Integer age;
    private String telephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
