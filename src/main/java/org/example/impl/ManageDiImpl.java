package org.example.impl;

import cn.weforward.common.ResultPage;
import cn.weforward.data.persister.Persistent;
import cn.weforward.data.persister.Persister;
import cn.weforward.data.persister.PersisterFactory;
import org.example.Programs;
import org.example.Teacher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManageDiImpl implements ManageDi{

    final static Logger _Logger = LoggerFactory.getLogger(ManageDiImpl.class);
    PersisterFactory m_Factory;
    /**教师业务对象持久器*/
    Persister<Teacher> m_PsTeacher;
    /**方案业务对象持久器*/
    Persister<Programs> m_PsPrograms;

    public ManageDiImpl(PersisterFactory factory) {
        m_Factory = factory;
        m_PsTeacher = factory.createPersister(Teacher.class, this);
        m_PsPrograms = factory.createPersister(Programs.class, this);
    }

    @Override
    public <E extends Persistent> Persister<E> getPersister(Class<E> clazz) {
        return m_Factory.getPersister(clazz);
    }
    @Override
    public Programs createPrograms(Teacher teacher, String title,String createId,String context) {
        return new Programs(this,teacher,createId,title,context);
    }


    @Override
    public ResultPage<Programs> searchPrograms(Teacher teacher) {
        return m_PsPrograms.startsWith(teacher.getId());
    }


}
