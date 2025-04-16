package com.terra.realtimedata.mapper;

import com.terra.common.enums.Quality;
import com.terra.common.enums.StatisticType;
import com.terra.common.enums.TimeType;
import com.terra.realtimedata.domain.DataItem;
import com.terra.realtimedata.domain.ElectricityDataDetail;
import com.terra.realtimedata.domain.StatisticResult;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 阶段数据查询，数据访问接口.
 */
public interface PeriodDataMapper {

    void save(@Param("dataItem") DataItem dataItem);

    void insert(@Param("dataItem") DataItem dataItem);

    void insertTOUData(@Param("dataItem") ElectricityDataDetail dataItem);

    void insertTOUDataItems(@Param("dataItems") List<ElectricityDataDetail> dataItems);

    void update(@Param("dataItem") DataItem dataItem);

    DataItem getDataByIndex(@Param("indexId") String indexId,
                            @Param("timeCode") String timeCode);

    List<DataItem> getDatasByIndex(@Param("indexIds") List<String> indexIds,
                                   @Param("timeCode") String timeCode);

    List<DataItem> getPeriodDatasByIndex(@Param("indexIds") List<String> indexIds,
                                         @Param("beginTime") Date beginTime,
                                         @Param("endTime") Date endTime,
                                         @Param("timeType") TimeType timeType);

    Double dataStatisticsByIndex(@Param("indexId") String indexId,
                                 @Param("statisticType") StatisticType statisticType,
                                 @Param("timeType") TimeType timeType,
                                 @Param("beginTime") Date beginTime,
                                 @Param("endTime") Date endTime);

    List<DataItem> dataStatisticsByIndexs(@Param("indexIds") List<String> indexIds,
                                          @Param("statisticType") StatisticType
                                                  statisticType,
                                          @Param("timeType") TimeType timeType,
                                          @Param("beginTime") Date beginTime,
                                          @Param("endTime") Date endTime);

    List<DataItem> statistic(@Param("indexIds") List<String> indexIds,
                             @Param("timeType") TimeType timeType,
                             @Param("beginTime") Date beginTime,
                             @Param("endTime") Date endTime);

    List<DataItem> statisticByCode(@Param("indexCodes") List<String> indexCodes,
                                   @Param("timeType") TimeType timeType,
                                   @Param("beginTime") Date beginTime,
                                   @Param("endTime") Date endTime);

    List<StatisticResult> getStatisticDatasById(@Param("indexIds") List<String> indexIds,
                                                @Param("timeType") TimeType timeType);

    List<StatisticResult> getStatisticDatasByCode(@Param("indexCodes") List<String> indexCodes,
                                                  @Param("timeType") TimeType timeType);

    List<DataItem> dataStatisticsByCodes(@Param("indexCodes") List<String> indexCodes,
                                         @Param("statisticType") StatisticType statisticType,
                                         @Param("timeType") TimeType timeType,
                                         @Param("beginTime") Date beginTime,
                                         @Param("endTime") Date endTime);

    String hasExist(@Param("indexId") String indexId,
                    @Param("timeCode") String timeCode);

    void saveDataList(@Param("dataItemVlues") List<DataItem> datas);

    List<DataItem> getPeriodDatasByIndexAndQuality(@Param("indexIds") List<String> indexIds,
                                                   @Param("beginTime") Date beginTime,
                                                   @Param("endTime") Date endTime,
                                                   @Param("timeType") TimeType timeType,
                                                   @Param("quality") Quality quality);

    List<DataItem> dataStatisticsFilterByCodes(@Param("indexCodes") List<String> indexCodes,
                                               @Param("statisticType") StatisticType statisticType,
                                               @Param("timeType") TimeType timeType,
                                               @Param("beginTime") Date beginTime,
                                               @Param("endTime") Date endTime,
                                               @Param("isFilter") boolean isFilter);

    void delete(@Param("indexId") String indexId,
                @Param("timeType") TimeType timeType,
                @Param("beginTime") Date beginTime,
                @Param("endTime") Date endTime);

    DataItem getDataByIndexCode(String indexCode, String timeCode);

    List<String> queryDataItemIsExist(@Param("queryMap") Map<String, List<String>> queryMap);

    void insertDataList(List<DataItem> insertData);
}
