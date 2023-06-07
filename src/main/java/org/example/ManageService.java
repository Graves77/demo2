package org.example;

public interface ManageService {
    /**
     *创建教师
     * @param createId
     * @param name
     * @param age
     * @return
     */
    Teacher createTeacher(String createId,String name,String age);

    Teacher getTeacher(String id);

    void removeTeacher(String id);

    Programs getPrograms(String id);
}
