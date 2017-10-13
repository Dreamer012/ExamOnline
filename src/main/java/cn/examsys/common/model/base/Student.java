package cn.examsys.common.model.base;

import cn.examsys.Constants;

import javax.persistence.*;


@Entity
@Table(name = Constants.TABLE_STUDENT)
public class Student {

    /**
     * 学生id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 专业
     */
    private String profession;

    /**
     * 准考证号
     */
    private String cardNo;

    /**
     * 学生标识位
     */
    private int flag = 2;

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 40)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password", length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "sex", length = 5)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "profession", length = 40)
    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Column(name = "cardNo", length = 50)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Transient
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", profession='" + profession + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", flag=" + flag +
                '}';
    }
}
