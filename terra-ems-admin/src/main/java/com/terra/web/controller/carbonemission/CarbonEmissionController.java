package com.terra.web.controller.carbonemission;

import com.terra.basicdata.domain.FacilityAnnex;
import com.terra.carbonemission.domain.dto.CarbonEmissionDTO;
import com.terra.carbonemission.domain.vo.carbonEmissionYQVO;
import com.terra.carbonemission.service.ICarbonEmissionService;
import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.common.core.page.TableDataInfo;
import com.terra.common.utils.poi.ExcelUtil;
import com.terra.web.controller.basicdata.FacilityAnnexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 碳排放核算Controller
 *
 * @author lsk
 * @date 2024-10-29
 */
@RestController
@RequestMapping("/carbonEmission")
public class CarbonEmissionController  extends BaseController
{

    @Resource
    private ICarbonEmissionService carbonEmissionService;

    private static final Logger log = LoggerFactory.getLogger(CarbonEmissionController.class);



    @GetMapping("/up")
    public AjaxResult up(CarbonEmissionDTO carbonEmissionDTO)
    {
        final Map<String, Object> upCarbonEmission = carbonEmissionService.getUpCarbonEmission(carbonEmissionDTO);
        return AjaxResult.success(upCarbonEmission);
    }

    @GetMapping("/middle")
    public AjaxResult middle(CarbonEmissionDTO carbonEmissionDTO)
    {
        final List<carbonEmissionYQVO>  carbonEmissionYQVO = carbonEmissionService.getMiddleCarbonEmission(carbonEmissionDTO);
        return AjaxResult.success(carbonEmissionYQVO);
    }

    @PostMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response, CarbonEmissionDTO carbonEmissionDTO)
    {
        List<carbonEmissionYQVO>  carbonEmissionYQVO = carbonEmissionService.getMiddleCarbonEmission(carbonEmissionDTO);
        ExcelUtil<carbonEmissionYQVO> util = new ExcelUtil<carbonEmissionYQVO>(carbonEmissionYQVO.class);
        util.exportExcel(response,carbonEmissionYQVO, "碳排放量同环比");
    }
}
