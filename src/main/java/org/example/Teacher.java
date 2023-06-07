package org.example;

import cn.weforward.common.ResultPage;
import cn.weforward.data.UniteId;
import cn.weforward.data.persister.support.AbstractPersistent;
import org.example.impl.ManageDi;

import javax.annotation.Resource;
import java.util.Date;

public class Teacher extends AbstractPersistent<ManageDi> {
    /**教师姓名*/
    @Resource
    protected String m_name;

    /**教师性别*/
    @Resource
    protected String m_age;

    /**创建人id*/
    @Resource
    protected String m_createId;

    /**创建时间*/
    @Resource
    protected Date m_createTime;

    public Teacher(ManageDi di,String name,String age,String createId){
        super(di);
        m_Id = getPersister().getNewId();
        m_name=name;
        m_createTime=new Date();
        m_age = age;
        m_createId=createId;
        markPersistenceUpdate();
    }
    protected Teacher(ManageDi di) {
        super(di);
    }

    /**
     * 创建方案
     * @param createrId
     * @param title
     * @return
     */
    public Programs createPrograms(String createrId,String title,String context){
        return getBusinessDi().createPrograms(this,createrId,title,context);
    }
    public String getId(){
        return getPersistenceId().getOrdinal();
    }
    public String getCreaterId(){
        return m_createId;
    }
    public Date getCreateTime() {
        return m_createTime;
    }
}
