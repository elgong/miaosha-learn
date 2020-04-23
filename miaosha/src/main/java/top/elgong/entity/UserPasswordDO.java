package top.elgong.entity;

public class UserPasswordDO {

    private Integer id;

    private String encrpt_password;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEncrpt_password() {
        return encrpt_password;
    }

    public void setEncrpt_password(String encrpt_password) {
        this.encrpt_password = encrpt_password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserPasswordDO{" +
                "id=" + id +
                ", encrpt_password='" + encrpt_password + '\'' +
                ", userId=" + userId +
                '}';
    }
}
