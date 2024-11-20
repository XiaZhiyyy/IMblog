package com.imblog.controller;

import com.imblog.pojo.SystemManagementInfo;
import com.imblog.service.SystemManagementService;
import com.imblog.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemManagementController {

    @Autowired
    private SystemManagementService systemManagementService;

    @GetMapping("/index")
    public ResultVo getSystemManagementInfo() {
        SystemManagementInfo info = systemManagementService.getSystemManagementInfo();
        return ResultVo.success("查询成功", info);
    }
}
