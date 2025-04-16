package com.terra.model.service;


import com.terra.common.enums.TimeType;
import com.terra.model.domain.IndexFormula;
import com.terra.model.domain.IndexStorage;

import java.util.List;

/**
 * @author fanxinfu
 */
public interface IIndexStorageService {

  void saveIndexStorage(String indexId, List<IndexStorage> indexStorage);

    void saveFormulaAndStorage(IndexFormula indexFormula, List<IndexStorage> indexStorage,
                               String indexId);

  List<IndexStorage> getIndexStorage(String indexId);

  List<IndexStorage> getAllCalcIndexStorage();

  IndexStorage getIndexStorage(String indexId, TimeType timeType);
}
