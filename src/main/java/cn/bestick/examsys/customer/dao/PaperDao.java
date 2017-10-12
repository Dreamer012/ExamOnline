package cn.bestick.examsys.customer.dao;

import cn.bestick.examsys.common.model.base.Paper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Bestick
 * Date: 2016/4/9
 * Time: 14:38
 * Url: http://www.bestick.cn
 * Copyright © 2015-2016 All rights reserved
 * -----------------------------------------------------------
 * 会当凌绝顶，一览众山小。
 */
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
