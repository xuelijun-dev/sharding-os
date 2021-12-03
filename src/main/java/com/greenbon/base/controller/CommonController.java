package com.greenbon.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.greenbon.base.comm.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

/**
 * Controller 控制层基类
 *
 * @author panjinfa
 */
@Slf4j
public class CommonController<M extends IService> {
    @Autowired
    public M service;
    @Autowired(required = false)
    protected HttpServletRequest request;
    @Autowired(required = false)
    protected HttpServletResponse response;

    protected String getDateForMate() {
        return "yyyy-MM-dd";
    }

    /**
     * 处理日期转换
     *
     * @param request
     * @param binder
     * @throws Exception
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws Exception {
        SimpleDateFormat dt = new SimpleDateFormat(getDateForMate());
        dt.setLenient(false);
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dt, true));
    }

    /**
     * 响应失败处理
     *
     * @param object
     */
    public static void requestFail(JSONObject object, Exception e) {
        object.put(Constant.STATUS_CODE, Constant.STATUS_FAIL);
        object.put(Constant.STATUS_MESSAGE, "操作失败,错误信息:" + e.getMessage());
    }

    /**
     * 响应成功处理
     *
     * @param object
     */
    public static void requestSucc(JSONObject object) {
        object.put(Constant.STATUS_CODE, Constant.STATUS_SUCC);
        object.put(Constant.STATUS_MESSAGE, "操作成功");
    }



    /**
     * 下载文件
     *
     * @param file
     * @param response
     * @throws Exception
     */
    protected void downloadFile(File file, HttpServletResponse response) throws Exception {
        InputStream fis = null;
        OutputStream toClient = null;
        try {
            // 以流的形式下载文件。
            fis = new BufferedInputStream(new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            // 清空response
            response.reset();
            toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            //如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
            toClient.write(buffer);
            toClient.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != fis) {
                fis.close();
            }
            if (null != toClient) {
                toClient.close();
            }
        }

    }

    /**
     * 下载文件
     *
     * @param bytes
     * @param response
     * @param name
     * @throws Exception
     */
    protected void downloadFile(byte[] bytes, HttpServletResponse response, String name) throws Exception {
        InputStream fis = null;
        OutputStream toClient = null;
        try {
            // 清空response
            response.reset();
            toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            //如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(name, "UTF-8"));
            toClient.write(bytes);
            toClient.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (null != fis) {
                fis.close();
            }
            if (null != toClient) {
                toClient.close();
            }
        }
    }
}
