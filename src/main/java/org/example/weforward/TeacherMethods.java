package org.example.weforward;

import cn.weforward.framework.ApiException;
import cn.weforward.framework.WeforwardMethod;
import cn.weforward.framework.WeforwardMethods;
import cn.weforward.framework.util.ValidateUtil;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocMethod;
import cn.weforward.protocol.doc.annotation.DocParameter;
import cn.weforward.protocol.doc.annotation.DocReturn;
import cn.weforward.protocol.support.datatype.FriendlyObject;
import org.example.ManageService;
import org.example.Programs;
import org.example.Teacher;
import org.example.exception.TapdException;
import org.example.exception.TapdServiceCodes;
import org.example.weforward.vo.ProgramsView;
import org.example.weforward.vo.TeacherView;

import javax.annotation.Resource;
import java.util.List;


@WeforwardMethods
public class TeacherMethods {
    @Resource
    protected ManageService manageService;

    @WeforwardMethod
    @DocMethod(index = 1,description = "创建教师")
    @DocParameter({
            @DocAttribute(index = 1,name = "name", type = String.class, description = "教师姓名", example = "张三",necessary=true),
            @DocAttribute(index = 2,name = "age", type = String.class, description = "教师年龄"),
                })
    @DocReturn(type = TeacherView.class, description = "教师信息", necessary = true)
    public TeacherView createTeacher(FriendlyObject params) throws ApiException {
        String name = params.getString("name");
        ValidateUtil.isEmpty(name, "姓名不能为空");
        String age = params.getString("age");
        // 用户id一般是接入用户模块后通过会话获取，故不走参数传递
        String createrid = "000001";
        Teacher teacher = manageService.createTeacher(createrid,name,age);
        return TeacherView.valueOf(teacher);
    }

    @WeforwardMethod
    @DocMethod(index = 2,description = "获取教师")
    @DocParameter(@DocAttribute(index = 1,name = "id", type = String.class, description = "教师id",necessary=true))
    @DocReturn(type = TeacherView.class, description = "教师信息", necessary = true)
    public TeacherView getTeacher(FriendlyObject params) throws ApiException {
        String id = params.getString("id");
        ValidateUtil.isEmpty(id, "id不能为空");
        Teacher teacher = manageService.getTeacher(id);
        if(null==teacher){
            throw new ApiException(ApiException.CODE_BUSINESS_ERROR,"找不到对应的教师["+id+"]");
        }
        return TeacherView.valueOf(teacher);
    }

    @WeforwardMethod
    @DocMethod(index = 3,description = "删除教师")
    @DocParameter(@DocAttribute(index = 1,name = "id", type = String.class, description = "教师id",necessary=true))
    public void removeTeacher(FriendlyObject params) throws ApiException {
        String id = params.getString("id");
        ValidateUtil.isEmpty(id, "id不能为空");
        manageService.removeTeacher(id);
    }

    @WeforwardMethod
    @DocMethod(index = 4,description = "创建教案")
    @DocParameter({
            @DocAttribute(index = 1,name = "teacherId", type = String.class, description = "教师id", necessary=true),
            @DocAttribute(index = 1,name = "title", type = String.class, description = "任务标题", necessary=true),
            @DocAttribute(index = 2,name = "content", type = String.class, description = "任务内容")
    })
    @DocReturn(type = ProgramsView.class, description = "教案详细信息", necessary = true)
    public ProgramsView createPrograms(FriendlyObject params) throws ApiException {
        String teacherId = params.getString("teacherId");
        ValidateUtil.isEmpty(teacherId, "需求id不能为空");
        String title = params.getString("title");
        ValidateUtil.isEmpty(title, "标题不能为空");
        String content = params.getString("content");
        Teacher teacher = manageService.getTeacher(teacherId);
        if(null==teacher){
            throw new ApiException(ApiException.CODE_BUSINESS_ERROR,"找不到对应的老师["+teacherId+"]");
        }
        // 用户id一般是接入用户模块后通过会话获取，故不走参数传递
        String createrid = "00000000001";
        Programs programs = teacher.createPrograms(createrid,title,content);
        return ProgramsView.valueOf(programs);
    }


    @WeforwardMethod
    @DocMethod(index = 5,description = "获取教案")
    @DocParameter(@DocAttribute(index = 1,name = "id", type = String.class, description = "教案id",necessary=true))
    @DocReturn(type = ProgramsView.class, description = "教案信息", necessary = true)
    public ProgramsView getPrograms(FriendlyObject params) throws ApiException {
        String id = params.getString("id");
        ValidateUtil.isEmpty(id, "id不能为空");
        Programs programs = manageService.getPrograms(id);
        if(null==programs){
            throw new ApiException(ApiException.CODE_BUSINESS_ERROR,"找不到对应的教案["+id+"]");
        }
        return ProgramsView.valueOf(programs);
    }

}
