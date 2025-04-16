package com.terra.web.controller.meter;


import com.terra.basicdata.domain.MeterAnnex;
import com.terra.basicdata.services.IMeterAnnexService;
import com.terra.common.annotation.Log;
import com.terra.common.config.BaseConfig;
import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.common.core.domain.model.LoginUser;
import com.terra.common.core.page.TableDataInfo;
import com.terra.common.enums.BusinessType;
import com.terra.common.utils.ServletUtils;
import com.terra.common.utils.file.FileUploadUtils;
import com.terra.common.utils.file.FileUtils;
import com.terra.common.utils.poi.ExcelUtil;
import com.terra.common.utils.uuid.IdUtils;
import com.terra.framework.web.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 计量器具档案附件Controller
 *
 * @author zhaowei
 * @date 2020-02-14
 */
@RestController
@RequestMapping("/meter/annex")
public class MeterAnnexController extends BaseController {
    @Autowired
    private IMeterAnnexService meterAnnexService;
    @Autowired
    private TokenService tokenService;

    private static final Logger log = LoggerFactory.getLogger(MeterAnnexController.class);

    /**
     * 查询计量器具档案附件列表
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:list')")
    @GetMapping("/list")
    public TableDataInfo list(MeterAnnex meterAnnex) {
        startPage();
        List<MeterAnnex> list = meterAnnexService.selectMeterAnnexList(meterAnnex);
        return getDataTable(list);
    }

    /**
     * 导出计量器具档案附件列表
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:export')")
    @Log(title = "计量器具档案附件", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(MeterAnnex meterAnnex) {
        List<MeterAnnex> list = meterAnnexService.selectMeterAnnexList(meterAnnex);
        ExcelUtil<MeterAnnex> util = new ExcelUtil<MeterAnnex>(MeterAnnex.class);
        return util.exportExcel(list, "annex");
    }

    /**
     * 获取计量器具档案附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(meterAnnexService.selectMeterAnnexById(id));
    }

    /**
     * 新增计量器具档案附件
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:add')")
    @Log(title = "计量器具档案附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MeterAnnex meterAnnex) {
        return toAjax(meterAnnexService.insertMeterAnnex(meterAnnex));
    }

    /**
     * 修改计量器具档案附件
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:edit')")
    @Log(title = "计量器具档案附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MeterAnnex meterAnnex) {
        return toAjax(meterAnnexService.updateMeterAnnex(meterAnnex));
    }

    /**
     * 删除计量器具档案附件
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:remove')")
    @Log(title = "计量器具档案附件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(meterAnnexService.deleteMeterAnnexByIds(ids));
    }

    /**
     * 通用指定文件下载请求
     *
     * @param showFileName 下载展示文件名称
     *                     //     * @param filePath 下载文件绝对路径 带 文件真实名字及路径
     * @param delete       是否删除/
     */
    @PreAuthorize("@ss.hasPermi('meter:annex:assignDownload')")
    @PostMapping("/assignDownload")
    public void fileAssignDownload(String showFileName, String filePath, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, showFileName));
            FileUtils.writeBytes(filePath, response.getOutputStream());
//            if (delete)
//            {
//                FileUtils.deleteFile(filePath);
//            }
            log.error("下载成功", "aa");
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    @Log(title = "计量器具档案附件上传", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('meter:annex:fileImport')")
    @PostMapping("/fileImport")
    public AjaxResult importData(MultipartFile file, String implementId) throws Exception {
        if (!file.isEmpty()) {
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            //获取配置的文件上传路径
            String uploadPathDir = BaseConfig.getUploadPath();
            //获取文件原始名称
            String fileName = file.getOriginalFilename();
            //获取文件扩展名
            String fileSuffix = FileUploadUtils.getExtension(file);
//            System.out.println("implementId==="+implementId);
//            System.out.println("filedir==="+uploadPathDir);
//            System.out.println("fileName==="+fileName);
//            System.out.println("fileSuffix==="+fileSuffix);
            //文件最终保存的绝对路径
            String filePath = FileUploadUtils.uploadAll(uploadPathDir, file);
//            System.out.println("上传文件地址:===>"+filePath);
            MeterAnnex meterAnnex = new MeterAnnex();
            //设置主键UUID
            meterAnnex.setId(IdUtils.simpleUUID());
            meterAnnex.setFileName(fileName);
            meterAnnex.setFilePath(filePath);
            meterAnnex.setFileSuffix(fileSuffix);
            meterAnnex.setImplementId(implementId);
            meterAnnex.setCreateBy(loginUser.getUsername());
            if (this.meterAnnexService.insertMeterAnnex(meterAnnex) > 0) {
                return AjaxResult.success("附件上传完成");
            }
        }
        return AjaxResult.success("附件上传失败");
    }
}
