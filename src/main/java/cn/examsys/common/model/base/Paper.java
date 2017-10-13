package cn.examsys.common.model.base;

import cn.examsys.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = Constants.TABLE_PAPER)
public class Paper {

    /**
     * 试卷id
     */
    private Integer id;

    /**
     * 试卷名
     */
    private String paperName;

    /**
     * 时间加入日期
     */
    private Date joinDate;

    /**
     * 试卷对应的题库
     */
    private Set<Question> questions = new HashSet<>();

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @OneToMany(mappedBy = "paper", fetch = FetchType.EAGER)
    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
}
