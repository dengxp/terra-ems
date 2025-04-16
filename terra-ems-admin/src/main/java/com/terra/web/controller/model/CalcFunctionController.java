package com.terra.web.controller.model;


import com.terra.common.annotation.Log;
import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.common.core.page.TableDataInfo;
import com.terra.common.enums.BusinessType;
import com.terra.common.utils.poi.ExcelUtil;
import com.terra.common.utils.uuid.UUID;
import com.terra.model.domain.CalcFunction;
import com.terra.model.service.ICalcFunctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 计算函数Controller
 *
 * @author fanxinfu
 * @date 2020-03-10
 */
@RestController
@RequestMapping("/basicsetting/function")
@Api(value = "计算公式管理",tags = {"计算公式管理"})
public class CalcFunctionController extends BaseController
{
    @Autowired
    private ICalcFunctionService calcFunctionService;

    /**
     * 查询计算函数列表
     */
    @PreAuthorize("@ss.hasPermi('basicsetting:function:list')")
    @GetMapping("/list")
    @ApiOperation(value = "计算函数列表")
    public TableDataInfo list(CalcFunction calcFunction)
    {
        startPage();
        List<CalcFunction> list = calcFunctionService.selectCalcFunctionList(calcFunction);
        return getDataTable(list);
    }

    /**
     * 导出计算函数列表
     */
    @ApiOperation(value = "计算函数列表导出")
    @PreAuthorize("@ss.hasPermi('basicsetting:function:export')")
    @Log(title = "计算函数", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CalcFunction calcFunction)
    {
        List<CalcFunction> list = calcFunctionService.selectCalcFunctionList(calcFunction);
        ExcelUtil<CalcFunction> util = new ExcelUtil<CalcFunction>(CalcFunction.class);
        return util.exportExcel(list, "function");
    }

    /**
     * 获取计算函数详细信息
     */
    @ApiOperation(value = "获取计算函数详细信息")
    @PreAuthorize("@ss.hasPermi('basicsetting:function:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(calcFunctionService.selectCalcFunctionById(id));
    }

    /**
     * 新增计算函数
     */
    @PreAuthorize("@ss.hasPermi('basicsetting:function:add')")
    @Log(title = "计算函数", businessType = BusinessType.INSERT)
    @PostMapping
    @ApiOperation(value = "新增计算函数")
    public AjaxResult add(@RequestBody CalcFunction calcFunction)
    {
        calcFunction.setId(UUID.fastUUID().toString());
        return toAjax(calcFunctionService.insertCalcFunction(calcFunction));
    }

    /**
     * 修改计算函数
     */
    @PreAuthorize("@ss.hasPermi('basicsetting:function:edit')")
    @Log(title = "计算函数", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation(value = "编辑计算函数")
    public AjaxResult edit(@RequestBody CalcFunction calcFunction)
    {
        return toAjax(calcFunctionService.updateCalcFunction(calcFunction));
    }

    /**
     * 删除计算函数
     */
    @PreAuthorize("@ss.hasPermi('basicsetting:function:remove')")
    @Log(title = "计算函数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @ApiOperation(value = "删除计算函数")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(calcFunctionService.deleteCalcFunctionByIds(ids));
    }
}
