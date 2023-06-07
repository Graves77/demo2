package org.example.weforward;


import cn.weforward.framework.ApiException;
import cn.weforward.framework.WeforwardMethod;
import cn.weforward.framework.WeforwardMethods;
import cn.weforward.framework.util.ValidateUtil;
import cn.weforward.protocol.Access;
import cn.weforward.protocol.client.util.MappedUtil;
import cn.weforward.protocol.datatype.DtObject;
import cn.weforward.protocol.doc.annotation.DocAttribute;
import cn.weforward.protocol.doc.annotation.DocMethod;
import cn.weforward.protocol.doc.annotation.DocParameter;
import cn.weforward.protocol.doc.annotation.DocReturn;
import cn.weforward.protocol.support.datatype.FriendlyObject;
import cn.weforward.protocol.support.datatype.SimpleDtList;
import cn.weforward.protocol.support.datatype.SimpleDtObject;
import org.example.weforward.vo.testVo;

import java.util.List;

@WeforwardMethods(kind = Access.KIND_SERVICE)
public class MytestMethods {

    @WeforwardMethod
    @DocMethod(description = "测试demo",index = 1)
    @DocParameter({@DocAttribute( name =  "name",type = String.class,description = "测试对象Id",necessary = true,example = "dxz"),
            @DocAttribute(name = "listName",type = List.class,component = String.class,description = "名称列表"),
            @DocAttribute(name = "testVo",type = testVo.class,description = "子对象")})
    @DocReturn({@DocAttribute(name = "stringValue", type = String.class, description = "姓名字串"),
            @DocAttribute(name = "listValue", type = List.class,component = String.class,description = "容器名称"),
            @DocAttribute(name = "VoValue", type = testVo.class, description = "子对象值")})
    public DtObject testdemo(FriendlyObject myRule) throws ApiException {
        String name =myRule.getString("name");
        List<String> myList =myRule.getFriendlyList("listName").toStringList();
        testVo VoValue = MappedUtil.fromBase(testVo.class, myRule.getObject("testVo"));
        SimpleDtObject resp = new SimpleDtObject();
        resp.put("stringValue","Hello " +name+" visit success");
        resp.put("listValue", SimpleDtList.stringOf(myList));
        resp.put("VoValue",MappedUtil.toBase(VoValue));
        return resp;
    }


}
