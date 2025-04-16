package com.terra.model.mapper;

import com.terra.common.enums.CalcType;
import com.terra.common.enums.TimeType;
import com.terra.model.domain.IndexStorage;
import com.terra.model.domain.IndexStorageParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexStorageMapper {

  void insertIndexStorage(IndexStorage storage);

  void updateIndexStorage(IndexStorage storage);

  List<IndexStorage> getIndexStorage(String indexId);

  void saveParams(@Param("storageId")String storageId, @Param("parameterIds")List<String> parameterIds);

  List<IndexStorageParam> getAllParameter();

  List<IndexStorage> getAllCalcIndexStorage(CalcType calc);

  IndexStorage getWithTimetype(@Param("indexId") String indexId, @Param("timeType") TimeType timeType);
}
