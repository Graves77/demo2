package org.example;

import cn.weforward.common.NameItem;
import cn.weforward.common.util.StringUtil;
import cn.weforward.data.persister.support.AbstractPersistent;
import org.example.impl.ManageDi;

import javax.annotation.Resource;
import java.util.Date;

public class Programs extends AbstractPersistent<ManageDi> {
    /**创建时间*/
    @Resource
    protected Date m_CreateTime;

    /**标题*/
    @Resource
    protected String m_title;

    /**教案内容*/
    @Resource
    protected String m_Context;

    /**创建人id*/
    @Resource
    protected String m_CreaterId;

    public String getId(){
        return getPersistenceId().getOrdinal();
    }

    public Date getCreateTime() {
        return m_CreateTime;
    }

    public String  getTitle() {
        return m_title;
    }
    /**创建人id*/
    public String getCreaterId() {
        return m_CreaterId;
    }

    public String getContext() {
        return m_Context;
    }

    public Programs(ManageDi di,Teacher teacher,String createId,String title,String context){
        super(di);
        m_Id = getPersister().getNewId();
        m_title=title;
        m_CreateTime=new Date();
        m_CreaterId=createId;
        markPersistenceUpdate();
        m_Context=context;
    }

    public Programs(ManageDi di){super(di);}

    public void setContent(String Content) {
        this.m_Context = Content;
        markPersistenceUpdate();
    }

    public String getContent() {
        // 防止没设置时返回null，以下转换若null则返回空串
        return StringUtil.toString(m_Context);
    }
}
