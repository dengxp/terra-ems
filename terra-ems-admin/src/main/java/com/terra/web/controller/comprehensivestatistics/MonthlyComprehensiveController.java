package com.terra.web.controller.comprehensivestatistics;

import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.common.utils.poi.ExcelUtil;
import com.terra.comprehensivestatistics.domain.MonthlyComprehensive;
import com.terra.comprehensivestatistics.service.ImonthlyComprehensive;
import com.terra.model.domain.ModelNode;
import com.terra.model.service.IModelNodeService;
import com.terra.realtimedata.domain.DataItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * electricityPriceController
 *
 * @author sys
 * @date 2020-02-18
 */
@Slf4j
@RestController
@RequestMapping("/comprehensive/monthlyComprehensive")
@Api(value = "综合指标分析（月）controller",tags = {"综合指标分析"})
public class MonthlyComprehensiveController extends BaseController {

    @Autowired
    private IModelNodeService modelNodeService;
    @Autowired
    private ImonthlyComprehensive monthlyComprehensive;

    /*全厂能耗统计*/
    @ApiOperation(value = "获取综合指标分析（月）列表")
    @GetMapping("/list")
    public AjaxResult list(DataItem dataItem) {
        try {

            Map tableColumn =new HashMap<>();//表数据
            List<MonthlyComprehensive> dataList=new ArrayList<>();
            DateFormat df = new SimpleDateFormat("yyyy-MM");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String aa= df.format(dataItem.getDataTime());
            String bb="";
            int i = 1;
            String beginTime=aa+"-01 00:00:00";
            dataItem.setBeginTime(sf.parse(beginTime));
            String endTime=aa+"-"+Integer.valueOf(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length()-2))+" 00:00:00";
            dataItem.setEndTime(sf.parse(endTime));
            while (i <= Integer.parseInt(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length() - 2))) {
                if (i > 9) {
                    bb = aa + "-" + i + " 00:00:00";
                } else {
                    bb = aa + "-0" + i + " 00:00:00";
                }
                MonthlyComprehensive report = new MonthlyComprehensive();
                report.setDataTime(sf.parse(bb));
                report.setValue("value" + i);
                dataList.add(report);
                tableColumn.put("value" + i, String.valueOf(i) + "日");
                i++;
            }

            MonthlyComprehensive reportList = new MonthlyComprehensive();
            List<Map> table = new ArrayList<>();
            table.add(tableColumn);
            reportList.setTablehead(table);

            ModelNode modelNode = modelNodeService.getModelNodeByModelCodeByIndexCode(dataItem.getIndexCode());
            if (ObjectUtils.isEmpty(modelNode)) {
                return AjaxResult.success(reportList);
            }
            List<MonthlyComprehensive> list = monthlyComprehensive.getMonthlyComprehensiveList(modelNode.getNodeId(),
                    dataList, dataItem.getBeginTime(), dataItem.getEndTime(), dataItem.getTimeType(), dataItem.getEnergyType());
            int count = Integer.parseInt(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length() - 2));
            list.forEach(monthlyReport -> monthlyReport.setCount(count));
            reportList.setTabledata(list);

            return AjaxResult.success(reportList);
        } catch (Exception ex) {
            logger.error("获取出错！", ex);
            return AjaxResult.error("获取出错!");
        }
    }
/**/
    /**
     * 全厂综合能耗统计图
     */
    @GetMapping("/listChart")
    @ApiOperation(value = "获取综合指标分析图表（月）数据")
    public AjaxResult listChart(DataItem dataItem) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String aa= df.format(dataItem.getDataTime());
        String beginTime=aa+"-01 00:00:00";
        dataItem.setBeginTime(sf.parse(beginTime));
        String endTime=aa+"-"+Integer.valueOf(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length()-2))+" 00:00:00";
        dataItem.setEndTime(sf.parse(endTime));
        List<MonthlyComprehensive> list = monthlyComprehensive.getListChart(dataItem.getIndexId(),dataItem.getBeginTime(),dataItem.getEndTime(), dataItem.getTimeType(),dataItem.getEnergyType());
        return AjaxResult.success(list);
    }
    public static String getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
        int month = Integer.parseInt(yearMonth.split("-")[1]); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.MONTH, month); //设置当前月的上一个月
        // 获取某月最大天数
        //int lastDay = cal.getActualMaximum(Calendar.DATE);
        int lastDay = cal.getMinimum(Calendar.DATE); //获取月份中的最小值，即第一天
        // 设置日历中月份的最大天数
        //cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1); //上月的第一天减去1就是当月的最后一天
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }
    /*综合月报表导出*/
//    @Log(title = "综合月报表导出", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    @ApiOperation(value = "综合月报表导出")
    public AjaxResult export(DataItem dataItem) {
        try {

            Map tableColumn =new HashMap<>();//表数据
            List<MonthlyComprehensive> dataList=new ArrayList<>();
            DateFormat df = new SimpleDateFormat("yyyy-MM");
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String aa= df.format(dataItem.getDataTime());
            String bb="";
            int i = 1;
            String beginTime=aa+"-01 00:00:00";
            dataItem.setBeginTime(sf.parse(beginTime));
            String endTime=aa+"-"+Integer.valueOf(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length()-2))+" 00:00:00";
            dataItem.setEndTime(sf.parse(endTime));
            while (i <= Integer.parseInt(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length() - 2))) {
                if (i > 9) {
                    bb = aa + "-" + i + " 00:00:00";
                } else {
                    bb = aa + "-0" + i + " 00:00:00";
                }
                MonthlyComprehensive report = new MonthlyComprehensive();
                report.setDataTime(sf.parse(bb));
                report.setValue("value" + i);
                dataList.add(report);
                tableColumn.put("value" + i, i + "日");
                i++;
            }

            MonthlyComprehensive reportList = new MonthlyComprehensive();
            List<Map> table = new ArrayList<>();
            table.add(tableColumn);
            reportList.setTablehead(table);

            ModelNode modelNode = modelNodeService.getModelNodeByModelCodeByIndexCode(dataItem.getIndexCode());
            if (ObjectUtils.isEmpty(modelNode)) {
                return AjaxResult.success(reportList);
            }
            List<MonthlyComprehensive> list = monthlyComprehensive.getMonthlyComprehensiveList(modelNode.getNodeId(), dataList,
                    dataItem.getBeginTime(), dataItem.getEndTime(), dataItem.getTimeType(), dataItem.getEnergyType());
            int count = Integer.parseInt(getLastDayOfMonth(aa).substring(getLastDayOfMonth(aa).length() - 2));
            list.forEach(monthlyReport -> monthlyReport.setCount(count));
            if (CollectionUtils.isNotEmpty(list)) {
                list.forEach(this::valueRep);
            }
            ExcelUtil<MonthlyComprehensive> util = new ExcelUtil<>(MonthlyComprehensive.class);
            return util.exportExcel(list, "综合指标分析月");
        } catch (Exception ex) {
            logger.error("获取出错！", ex);
            return AjaxResult.error("获取出错!");
        }
    }
    public void valueRep(Object dr){
        Field[] fields = dr.getClass().getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            Object obj = field.getType();
            if(field.getType().getName().equals("java.lang.Double")){
                String name = field.getName();
                try {
                    if(ObjectUtils.isEmpty(field.get(dr)))
                    {
                        field.set(dr,0.00);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
