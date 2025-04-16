package com.terra.branchanalysis.service;


import com.terra.branchanalysis.domain.BranchAnalysisVO;
import com.terra.realtimedata.domain.dto.BranchAnalysisDTO;


public interface IBranchAnalysisService {
    /**
     * 支路用能分析
     *
     * @author sys
     * @date 2021-01-11
     */
    BranchAnalysisVO getBranchAnalysisService(BranchAnalysisDTO dataItem);
}
