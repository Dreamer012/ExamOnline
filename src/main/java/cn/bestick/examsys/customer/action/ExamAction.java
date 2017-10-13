package cn.bestick.examsys.customer.action;

import cn.bestick.examsys.Constants;
import cn.bestick.examsys.common.model.base.Exam;
import cn.bestick.examsys.common.model.base.Question;
import cn.bestick.examsys.customer.dao.ExamDao;
import cn.bestick.examsys.customer.dao.QuestionDao;
import cn.bestick.examsys.customer.dao.impl.ExamDaoImpl;
import cn.bestick.examsys.customer.dao.impl.QuestionDaoImpl;
import cn.bestick.examsys.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/15
 * Time: 16:49
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
public class ExamAction extends ActionSupport implements ServletRequestAware {

    /**
     * mainPage
     */
    private String mainPage;

    /**
     * Exam实体
     */
    private Exam exam;

    /**
     * List<Exam>
     */
    private List<Exam> examList;

    /**
     * studentId
     */
    private String studentId;

    /**
     * ExamDao
     */
    private ExamDao examDao = new ExamDaoImpl();

    /**
     * QuestionDao
     */
    private QuestionDao questionDao = new QuestionDaoImpl();

    /**
     * HttpServletRequest
     */
    private HttpServletRequest request;

    /**
     * 保存考试信息
     *
     * @return String
     * @throws Exception
     */
    public String add() throws Exception {
        Map<String, String[]> keyMap = request.getParameterMap();
        Set<Entry<String, String[]>> entrySet = keyMap.entrySet();
        int sumScore;
        int singleScore = 0;
        int multipleScore = 0;
        for (Entry<String, String[]> entry :
                entrySet) {
            String formName = entry.getKey();
            String values[] = entry.getValue();
            String questionId;
            String userAnswer = "";
            //跳过隐藏域
            if (formName.equals("exam.student.id") || formName.equals("exam.paper.id")) {
                continue;
            }
            //单选题
            if (formName.split("-")[1].equals("r")) {
                questionId = formName.split("-")[2];
                userAnswer = values[0];
                //计算单选题得分
                singleScore += this.calScore(questionId, userAnswer, Constants.SINGLE_QUESTION_TYPE);
            } else {
                questionId = formName.split("-")[2];
                for (String s :
                        values) {
                    //多选题答案用逗号隔开
                    userAnswer += s + ",";
                }
                //去掉最后一个逗号
                userAnswer = userAnswer.substring(0, userAnswer.length() - 1);
                //计算多选题得分
                multipleScore += this.calScore(questionId, userAnswer, Constants.MULTIPLE_QUESTION_TYPE);
            }
        }
        //计算总分
        sumScore = singleScore + multipleScore;
        exam.setSingleScore(singleScore);
        exam.setMultipleScore(multipleScore);
        exam.setSumScore(sumScore);
        exam.setExamDate(new Date());
        examDao.saveExam(exam);
        mainPage = "jsp/customer/exam/examResult.jsp";
        return SUCCESS;
    }

    /**
     * 计算分数
     *
     * @param questionId 试题id
     * @param userAnswer 考生答案
     * @param type       试题类型
     * @return 得分
     * @throws Exception
     */
    private int calScore(String questionId, String userAnswer, String type) throws Exception {
        Question question = questionDao.getQuestion(Integer.parseInt(questionId));
        if (userAnswer.equals(question.getAnswer())) {
            if (Constants.SINGLE_QUESTION_TYPE.equals(type)) {
                return Integer.parseInt(PropertiesUtil.getValue("singleScore"));
            } else {
                return Integer.parseInt(PropertiesUtil.getValue("multipleScore"));
            }
        } else {
            return Integer.parseInt(PropertiesUtil.getValue("wrongScore"));
        }
    }

    /**
     * 成绩查询
     *
     * @return String
     * @throws Exception
     */
    public String list() throws Exception {
        examList = examDao.getExamList(studentId);
        mainPage = "jsp/customer/exam/myExam.jsp";
        return SUCCESS;
    }


    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
