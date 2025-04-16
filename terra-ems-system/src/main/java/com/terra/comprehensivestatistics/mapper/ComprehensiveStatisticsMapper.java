package com.terra.comprehensivestatistics.mapper;

import com.terra.basicdata.domain.FacilityArchives;
import com.terra.common.enums.TimeType;
import com.terra.comprehensivestatistics.domain.ComprehensiveStatistics;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ComprehensiveStatisticsMapper {
    List<FacilityArchives> getFacilityArchives();
    List<ComprehensiveStatistics> getDatasByList(@Param("indexIds") List<String> indexIds, @Param("beginTime") Date beginTime,
                                                 @Param("endTime") Date endTime,
                                                 @Param("timeType") TimeType timeType);
    List<ComprehensiveStatistics> getDatasByIndex(@Param("indexIds") List<String> indexIds, @Param("timeCode") String timeCode);
    List<ComprehensiveStatistics> getDatasIndex(@Param("indexIds") List<String> indexIds,@Param("timeCode") String timeCode);
    List<ComprehensiveStatistics> getEnergyByIndex(@Param("indexType") String indexType);

}
