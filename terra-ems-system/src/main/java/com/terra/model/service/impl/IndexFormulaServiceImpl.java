package com.terra.model.service.impl;

import com.terra.common.utils.StringUtils;
import com.terra.common.utils.uuid.UUID;
import com.terra.model.domain.IndexFormula;
import com.terra.model.domain.IndexFormulaParam;
import com.terra.model.mapper.IndexFormulaMapper;
import com.terra.model.service.IndexFormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fanxinfu
 */
@Service
public class IndexFormulaServiceImpl implements IndexFormulaService {

  @Autowired
  private IndexFormulaMapper indexFormulaMapper;

  @Override
  public void saveIndexFormula(IndexFormula indexFormula) {
    if (StringUtils.isEmpty(indexFormula.getId())) {
      indexFormula.setId(UUID.fastUUID().toString());
      indexFormulaMapper.insertIndexFormula(indexFormula);
    } else {
      indexFormulaMapper.updateIndexFormula(indexFormula);
    }

    indexFormula.getIndexFormulaParams().forEach(param -> {
      param.setId(UUID.fastUUID().toString());
      param.setFormulaId(indexFormula.getId());
      param.setIndexId(indexFormula.getIndexId());
    });
    indexFormulaMapper
        .saveIndexFormulaParam(indexFormula.getIndexId(), indexFormula.getIndexFormulaParams());
  }

  @Override
  public IndexFormula getIndexFormula(String indexId) {
    IndexFormula indexFormula = indexFormulaMapper.getFormula(indexId);
    if (indexFormula != null) {
      List<IndexFormulaParam> indexFormulaParams = indexFormulaMapper.getFormulaParam(indexId);
      if (!indexFormulaParams.isEmpty()) {
        indexFormula.setIndexFormulaParams(indexFormulaParams);
      }
    } else {
      indexFormula = new IndexFormula();
    }

    return indexFormula;
  }

}
