package org.example.weforward.vo;

import cn.weforward.common.util.TimeUtil;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import org.example.Programs;

import javax.annotation.Resource;
import java.util.Date;

public class ProgramsView{
    protected Programs programs;

    public static ProgramsView valueOf(Programs programs){
        return null == programs ? null : new ProgramsView(programs);
    }

    /** 初始化 */
    public ProgramsView(Programs programs) {
        this.programs = programs;
    }

    @DocAttribute(description = "id",type = String.class,index =1)
    public String getId() {
        return programs.getId();
    }

    @DocAttribute(description = "创建人id",type = String.class,index =2)
    public String getCreaterId() {
        return programs.getCreaterId();
    }

    @DocAttribute(description = "创建时间",type = String.class,index =3)
    public String getCreateTime() {
        return TimeUtil.formatDateTime(programs.getCreateTime());
    }

    @DocAttribute(description = "标题",type = String.class,index =4)
    public String getTitle() {
        return programs.getTitle();
    }
}
