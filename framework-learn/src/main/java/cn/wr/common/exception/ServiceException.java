package cn.wr.common.exception;

import cn.wr.common.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author RWang
 * @Date 2022/4/18
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException{

    private static final long serialVersionUID = -7450483673233577690L;

    public static final String DEFAULT_MESSAGE = "网络错误，请稍后重试！";

    /**
     * 异常消息
     */
    private String msg = DEFAULT_MESSAGE;

    /**
     * 错误码
     */
    private ResultCode resultCode;

    public ServiceException(String msg) {
        this.resultCode = ResultCode.ERROR;
        this.msg = msg;
    }
}
