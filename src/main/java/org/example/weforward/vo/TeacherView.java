package org.example.weforward.vo;

import cn.weforward.common.util.TimeUtil;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocObject;
import org.example.Teacher;

import javax.annotation.Resource;
import java.util.Date;

@DocObject(description = "教师信息")
public class TeacherView extends SimpleTeacherView {
    protected TeacherView(Teacher teacher) {
        super(teacher);
    }

    public static TeacherView valueOf(Teacher teacher){
         return null == teacher ? null : new TeacherView(teacher);
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
