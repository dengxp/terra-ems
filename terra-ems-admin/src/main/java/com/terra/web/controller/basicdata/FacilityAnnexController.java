package com.terra.web.controller.basicdata;

import com.terra.basicdata.domain.FacilityAnnex;
import com.terra.basicdata.services.IFacilityAnnexService;
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
 * 设备档案附件Controller
 *
 * @author sys
 * @date 2020-02-24
 */
@RestController
@RequestMapping("/facility/annex")
public class FacilityAnnexController extends BaseController
{
    @Autowired
    private IFacilityAnnexService facilityAnnexService;
    @Autowired
    private TokenService tokenService;

    private static final Logger log = LoggerFactory.getLogger(FacilityAnnexController.class);
    /**
     * 查询设备档案附件列表
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:list')")
    @GetMapping("/list")
    public TableDataInfo list(FacilityAnnex facilityAnnex)
    {
        startPage();
        List<FacilityAnnex> list = facilityAnnexService.selectFacilityAnnexList(facilityAnnex);
        return getDataTable(list);
    }

    /**
     * 导出设备档案附件列表
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:export')")
    @Log(title = "设备档案附件", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(FacilityAnnex facilityAnnex)
    {
        List<FacilityAnnex> list = facilityAnnexService.selectFacilityAnnexList(facilityAnnex);
        ExcelUtil<FacilityAnnex> util = new ExcelUtil<FacilityAnnex>(FacilityAnnex.class);
        return util.exportExcel(list, "annex");
    }

    /**
     * 获取设备档案附件详细信息
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(facilityAnnexService.selectFacilityAnnexById(id));
    }

    /**
     * 新增设备档案附件
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:add')")
    @Log(title = "设备档案附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FacilityAnnex facilityAnnex)
    {
        return toAjax(facilityAnnexService.insertFacilityAnnex(facilityAnnex));
    }

    /**
     * 修改设备档案附件
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:edit')")
    @Log(title = "设备档案附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FacilityAnnex facilityAnnex)
    {
        return toAjax(facilityAnnexService.updateFacilityAnnex(facilityAnnex));
    }

    /**
     * 删除设备档案附件
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:remove')")
    @Log(title = "设备档案附件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(facilityAnnexService.deleteFacilityAnnexByIds(ids));
    }


    /**
     * 通用指定文件下载请求
     *
     * @param showFileName 下载展示文件名称
    //     * @param filePath 下载文件绝对路径 带 文件真实名字及路径
     * @param delete 是否删除/
     */
    @PreAuthorize("@ss.hasPermi('facility:annex:assignDownload')")
    @PostMapping("/assignDownload")
    public void fileAssignDownload(String showFileName, String filePath, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
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
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }
    @Log(title = "设备档案附件上传", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('facility:annex:fileImport')")
    @PostMapping("/fileImport")
    public AjaxResult importData(MultipartFile file, String facilityId) throws Exception
    {
        if (!file.isEmpty())
        {
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
            FacilityAnnex facilityAnnex = new FacilityAnnex();
            //设置主键UUID
            facilityAnnex.setId(IdUtils.simpleUUID());
            facilityAnnex.setFileName(fileName);
            facilityAnnex.setFilePath(filePath);
            facilityAnnex.setFilesuffix(fileSuffix);
            facilityAnnex.setFacilityId(facilityId);
            facilityAnnex.setCreateBy(loginUser.getUsername());

            facilityAnnex.setCreateBy(loginUser.getUsername());
            if (this.facilityAnnexService.insertFacilityAnnex(facilityAnnex)>0)
            {
                return AjaxResult.success("附件上传完成");
            }
        }
        return AjaxResult.success("附件上传失败");
    }
}
