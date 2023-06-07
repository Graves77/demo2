package org.example.impl;

import cn.weforward.common.ResultPage;
import cn.weforward.data.persister.BusinessDi;
import org.example.Programs;
import org.example.Teacher;

public interface ManageDi extends BusinessDi {
    /**
     *  教师创建教案
     * @param teacher
     * @param title
     * @param createId
     * @return
     */
    Programs createPrograms(Teacher teacher, String createId,String title,String context);

    /**
     * 查询教师下的教案
     * @param teacher
     * @return
     */
    ResultPage<Programs> searchPrograms(Teacher teacher);
}
