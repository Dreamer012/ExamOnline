package cn.examsys.customer.action;

import cn.examsys.Constants;
import cn.examsys.common.model.base.Paper;
import cn.examsys.common.model.base.Question;
import cn.examsys.customer.dao.PaperDao;
import cn.examsys.customer.dao.impl.PaperDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class PaperAction extends ActionSupport {

    /**
     * PaperDao
     */
    private PaperDao paperDao = new PaperDaoImpl();

    /**
     * mainPage
     */
    private String mainPage;

    /**
     * 试卷集合
     */
    private List<Paper> papers = new ArrayList<>();

    /**
     * 试卷id
     */
    private Integer paperId;

    /**
     * 试卷
     */
    private Paper paper;

    /**
     * 单选题集合
     */
    private List<Question> singleList = new ArrayList<>();

    /**
     * 多选题集合
     */
    private List<Question> multipleList = new ArrayList<>();

    /**
     * 获取试卷集合
     *
     * @return String
     * @throws Exception
     */
    public String list() throws Exception {
        papers = paperDao.getPapers();
        mainPage = "jsp/customer/exam/selectPaper.jsp";
        return SUCCESS;
    }

    /**
     * 获取试卷详情
     *
     * @return String
     * @throws Exception
     */
    public String getDetailPaper() throws Exception {
        paper = paperDao.getPaper(paperId);
        Set<Question> questionsSet = paper.getQuestions();
        for (Question question : questionsSet) {
            if (Constants.SINGLE_QUESTION_TYPE.equals(question.getType())) {
                singleList.add(question);
            } else if (Constants.MULTIPLE_QUESTION_TYPE.equals(question.getType())) {
                multipleList.add(question);
            }
        }
        mainPage = "jsp/customer/exam/paper.jsp";
        singleList = this.getRandomQuestion(singleList, 3);
        multipleList = this.getRandomQuestion(multipleList, 2);
        return SUCCESS;
    }

    /**
     * 根据传入的question集合随机获取n条question组成新的集合
     *
     * @param questionList 入参
     * @param num          指定条数
     * @return List<Question>
     * @throws Exception
     */
    private List<Question> getRandomQuestion(List<Question> questionList, int num) throws Exception {
        List<Question> resultList = new ArrayList<>();
        Random random = new Random();
        if (num > 0) {
            for (int i = 0; i < num; i++) {
                int n = random.nextInt(questionList.size());
                Question question = questionList.get(n);
                if (resultList.contains(question)) {
                    //FIXME questionList.size() < num时死循环
                    i--;
                } else {
                    resultList.add(question);
                }
            }
        }
        return resultList;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public List<Paper> getPapers() {
        return papers;
    }

    public void setPapers(List<Paper> papers) {
        this.papers = papers;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public List<Question> getSingleList() {
        return singleList;
    }

    public void setSingleList(List<Question> singleList) {
        this.singleList = singleList;
    }

    public List<Question> getMultipleList() {
        return multipleList;
    }

    public void setMultipleList(List<Question> multipleList) {
        this.multipleList = multipleList;
    }
}
