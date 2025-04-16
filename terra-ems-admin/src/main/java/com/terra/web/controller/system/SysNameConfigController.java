package com.terra.web.controller.system;

import com.terra.common.annotation.Anonymous;
import com.terra.common.annotation.Log;
import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.common.enums.BusinessType;
import com.terra.system.domain.SysNameConfig;
import com.terra.system.service.ISysNameConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 系统名称配置Controller
 * 
 * @author terra
 * @date 2024-11-05
 */
@RestController
@RequestMapping("/system/nameconfig")
public class SysNameConfigController extends BaseController
{
    @Resource
    private ISysNameConfigService sysNameConfigService;


    /**
     * 新增系统名称配置
     */
    @Log(title = "系统名称配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult save(@RequestBody SysNameConfig sysNameConfig)
    {
        return toAjax(sysNameConfigService.saveOrUpdate(sysNameConfig));
    }

    /**
     * 新增系统名称配置
     */
    @GetMapping
    @Anonymous
    public AjaxResult getSysNameConfig()
    {
        return AjaxResult.success(sysNameConfigService.getSysNameConfig());
    }

}
