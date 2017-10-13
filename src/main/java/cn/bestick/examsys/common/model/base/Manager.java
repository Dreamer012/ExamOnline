package cn.bestick.examsys.common.model.base;

import cn.bestick.examsys.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/4
 * Time: 12:37
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */

@Entity
@Table(name = Constants.TABLE_MANAGER)
public class Manager {

    /**
     * 管理员id
     */
    private Integer id;

    /**
     * 管理员账号
     */
    private String userName;

    /**
     * 管理员密码
     */
    private String password;

    /**
     * 管理员名字
     */
    private String name;

    /**
     * 管理员标识位
     */
    private int flag = 1;

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Manager{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
