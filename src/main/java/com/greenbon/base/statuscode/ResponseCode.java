package com.greenbon.base.statuscode;


import com.alibaba.fastjson.JSONObject;

public class ResponseCode {
    //private final static JSONObject commonNullData = new JSONObject();
    private final static String commonNullData = "";

    public static Object getSuccess() {
        JSONObject os = new JSONObject(true);
        os.put("code", StatusCode.OK.getErrcode());
        os.put("msg", StatusCode.OK.getMsg());
        os.put("data", commonNullData);
        return os;
    }

    public static Object getSuccess(String msg) {
        JSONObject os = new JSONObject(true);
        os.put("code", StatusCode.OK.getErrcode());
        os.put("msg", msg);
        os.put("data", commonNullData);
        return os;
    }

    public static Object getSuccess(String msg, Object result) {
        JSONObject os = new JSONObject(true);
        os.put("code", StatusCode.OK.getErrcode());
        os.put("msg", msg);
        os.put("data", result == null ? commonNullData : result);
        return os;
    }

    public static Object getSuccess(Object result) {
        JSONObject os = new JSONObject(true);
        os.put("code", StatusCode.OK.getErrcode());
        os.put("msg", StatusCode.OK.getMsg());
        os.put("data", result == null ? commonNullData : result);
        return os;
    }

    public static Object getError() {
        JSONObject os = new JSONObject(true);
        os.put("code", StatusCode.ERROR.getErrcode());
        os.put("msg", StatusCode.ERROR.getMsg());
        os.put("data", commonNullData);
        return os;
    }

    public static Object getError(String msg) {
        JSONObject os = new JSONObject(true);
        os.put("code", StatusCode.ERROR.getErrcode());
        os.put("msg", msg);
        os.put("data", commonNullData);
        return os;
    }

    public static Object getError(String msg, Object result) {
        JSONObject oe = new JSONObject(true);
        oe.put("code", StatusCode.ERROR.getErrcode());
        oe.put("msg", msg);
        oe.put("data", result == null ? commonNullData : result);
        return oe;
    }

    /**
     * 自定义返回状态
     *
     * @param errcode
     * @param errmsg
     * @return
     */
    public static Object customMsg(int errcode, String errmsg) {
        JSONObject oe = new JSONObject(true);
        oe.put("code", errcode);
        oe.put("msg", errmsg);
        oe.put("data", commonNullData);
        return oe;
    }

    /**
     * 自定义返回状态
     *
     * @param errcode
     * @param errmsg
     * @return
     */
    public static Object resultMsg(int errcode, String errmsg, Object result) {
        JSONObject oe = new JSONObject(true);
        oe.put("code", errcode);
        oe.put("msg", errmsg);
        oe.put("data", result == null ? commonNullData : result);
        return oe;
    }

}
