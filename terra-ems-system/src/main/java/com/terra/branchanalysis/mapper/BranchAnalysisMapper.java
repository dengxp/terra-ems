package com.terra.branchanalysis.mapper;

import com.terra.branchanalysis.domain.BranchAnalysisVO;
import com.terra.common.utils.TypeTime;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 *支路用能分析
 *
 * @author sys
 * @date 2021-01-11
 */
public interface BranchAnalysisMapper {
    public List<BranchAnalysisVO> getBranchAnalysisList(@Param("indexIds") List<String> indexIds,
                                                        @Param("dataList") List<TypeTime> dataList,
                                                        @Param("beginTime") Date beginTime,
                                                        @Param("endTime") Date endTime,
                                                        @Param("timeType") String timeType,
                                                        @Param("indexStorageId") String indexStorageId);


}

