package com.terra.model.service;


import com.terra.model.domain.IndexFormula;

public interface IndexFormulaService {

  void saveIndexFormula(IndexFormula indexFormula);

  IndexFormula getIndexFormula(String indexId);
}
