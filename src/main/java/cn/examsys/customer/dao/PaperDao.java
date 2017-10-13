package cn.examsys.customer.dao;

import cn.examsys.common.model.base.Paper;

import java.util.List;


public interface PaperDao {

    /**
     * 获取试卷列表
     *
     * @return List<Paper>
     * @throws Exception
     */
    List<Paper> getPapers() throws Exception;

    /**
     * 根据试卷id获取具体试卷
     *
     * @return Paper
     * @throws Exception
     */
    Paper getPaper(Integer paperId) throws Exception;
}
