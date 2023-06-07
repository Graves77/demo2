package org.example.weforward.vo;

import cn.weforward.common.util.TimeUtil;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import org.example.Teacher;

public class SimpleTeacherView {
    protected Teacher teacher;

    public static SimpleTeacherView valueOf(Teacher teacher){

        return null == teacher ? null : new SimpleTeacherView(teacher);
    }

    /** 初始化 */
    public SimpleTeacherView(Teacher teacher) {
        this.teacher = teacher;
    }

    @DocAttribute(description = "id",type = String.class,index =1)
    public String getId() {
        return teacher.getId();
    }

    @DocAttribute(description = "创建人id",type = String.class,index =2)
    public String getCreaterId() {
        return teacher.getCreaterId();
    }

    @DocAttribute(description = "创建时间",type = String.class,index =3)
    public String getCreateTime() {
        return TimeUtil.formatDateTime(teacher.getCreateTime());
    }


}
