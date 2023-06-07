package org.example.weforward.vo;

import cn.weforward.protocol.doc.annotation.DocAttribute;

public class testVo {
    @DocAttribute(description = "姓名")
    String name;
    @DocAttribute(description = "类型")
    String type;
    @DocAttribute(description = "唯一标识符")
    String id;

    public void setId(String id) {
        this.id = id;
    }
}
