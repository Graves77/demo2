package org.example.exception;

import cn.weforward.protocol.StatusCode;
import cn.weforward.protocol.client.execption.MicroserviceException;
import cn.weforward.protocol.support.CommonServiceCodes;

/**
 * 业务异常值定义
 */
public class TapdServiceCodes extends CommonServiceCodes {
    private final static StatusCode CODE_TAPD_EXCEPTION = new StatusCode(MicroserviceException.CUSTOM_CODE_START+1,
            "状态扭转失败");

    /**
     * 获取错误码
     *
     * @return
     */
    public static int getCode() {
        return CODE_TAPD_EXCEPTION.code;
    }
}
