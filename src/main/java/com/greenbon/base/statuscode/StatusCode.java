package com.greenbon.base.statuscode;

/**
 * Developer :PanJinFa
 * Date :2018/4/1
 * Time :22:33
 * Title:StatusCode
 * Description:系统状态码定义
 *
 * @author panjinfa
 */
public enum StatusCode {
    OK("ok", 0),
    // 默认系统运营异常
    ERROR("err", -1),
    //业务主动发起异常
    BUSINESS_ERROR("business_err", -2);

    private String msg;
    private int errcode;

    StatusCode(String msg, int errcode) {
        this.msg = msg;
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }
}

