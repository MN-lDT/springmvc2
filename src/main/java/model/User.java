package model;

/**
 * @Description:
 * @author:lidetian
 * @date: 2018/7/20
 * @system name:马达贷
 * @copyright:长安新生（深圳）金融投资有限公司
 */
public class User {
    private int id;
    private String username;
    private String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
