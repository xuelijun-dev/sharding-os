package com.greenbon.druid.webservice;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据源监控
 */
@RestController
@RequestMapping("/api/druid")
public class DruidStatController {

    @GetMapping("/stat")
    public Object druidStat() {
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

    @GetMapping("/activeConnStackTraceList")
    public Object activeConnStackTraceList() {
        return DruidStatManagerFacade.getInstance().getActiveConnStackTraceList();
    }
}
