package org.example.impl;

import cn.weforward.data.persister.PersisterFactory;
import org.example.ManageService;
import org.example.Programs;
import org.example.Teacher;

public class ManageServiceImpl extends ManageDiImpl implements ManageService {

    public ManageServiceImpl(PersisterFactory factory) {
        super(factory);
    }

    @Override
    public Teacher createTeacher(String createId, String name, String age) {
        return new Teacher(this,name,age,createId);
    }

    @Override
    public Teacher getTeacher(String id) {
        return m_PsTeacher.get(id);
    }

    @Override
    public void removeTeacher(String id) {
        m_PsTeacher.remove(id);
    }

    @Override
    public Programs getPrograms(String id) {
        return m_PsPrograms.get(id);
    }
}
