package ssm.domain;

public class UserEntity {
    private int id;
    private String account;
    private String password;
    private String name;
    private int age;
    private int phone;
    private String wechat;

    public UserEntity() {
    }

    public UserEntity(int id, String account, String password, String name, int age, int phone, String wechat) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.wechat = wechat;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                ", wechat='" + wechat + '\'' +
                '}';
    }
}
