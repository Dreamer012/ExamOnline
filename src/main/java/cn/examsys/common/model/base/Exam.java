package cn.examsys.common.model.base;

import cn.examsys.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = Constants.TABLE_EXAM)
public class Exam {

    /**
     * 考试id
     */
    private Integer id;

    /**
     * 参加考试的student
     */
    private Student student;

    /**
     * 考试对应的试卷
     */
    private Paper paper;

    /**
     * 单选题得分
     */
    private int singleScore;

    /**
     * 多选题得分
     */
    private int multipleScore;

    /**
     * 总分
     */
    private int sumScore;

    /**
     * 考试日期
     */
    private Date examDate;

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "studentId")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "paperId")
    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public int getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(int singleScore) {
        this.singleScore = singleScore;
    }

    public int getMultipleScore() {
        return multipleScore;
    }

    public void setMultipleScore(int multipleScore) {
        this.multipleScore = multipleScore;
    }

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", student=" + student +
                ", paper=" + paper +
                ", singleScore=" + singleScore +
                ", multipleScore=" + multipleScore +
                ", sumScore=" + sumScore +
                ", examDate=" + examDate +
                '}';
    }
}
