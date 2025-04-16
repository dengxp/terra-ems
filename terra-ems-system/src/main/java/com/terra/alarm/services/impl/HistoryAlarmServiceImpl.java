package com.terra.alarm.services.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.terra.alarm.domain.HistoryAlarm;
import com.terra.alarm.domain.JkHistoryAlarm;
import com.terra.alarm.mapper.HistoryAlarmMapper;
import com.terra.alarm.services.IHistoryAlarmService;
import com.terra.basicdata.domain.MeterImplement;
import com.terra.basicdata.mapper.MeterImplementMapper;
import com.terra.common.enums.TimeType;
import com.terra.common.utils.StringUtils;
import com.terra.model.domain.EnergyIndex;
import com.terra.model.mapper.EnergyIndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HistoryAlarmServiceImpl implements IHistoryAlarmService {

  @Autowired
  private HistoryAlarmMapper historyAlarmMapper;

  @Autowired
  private MeterImplementMapper meterImplementMapper;

  @Autowired
  private EnergyIndexMapper energyIndexMapper;


  @Override
  public List<HistoryAlarm> getHistoryAlarm(Date beginTime, Date endTime) {
    return null;
  }

  @Override
  public List<HistoryAlarm> getHistoryAlarm(Date beginTime, Date endTime, TimeType timeType) {
    return null;
  }

  @Override
  public List<HistoryAlarm> getHistoryAlarm(Date beginTime, Date endTime, String alarmType) {
    return null;
  }

  @Override
  public List<JkHistoryAlarm> selectJkHistoryAlarmList(JkHistoryAlarm jkHistoryAlarm) {
    return historyAlarmMapper.selectJkHistoryAlarmList(jkHistoryAlarm);
  }

  @Override
  public List<JkHistoryAlarm> selectJkHistoryAlarmListExcel(JkHistoryAlarm jkHistoryAlarm) {
    return historyAlarmMapper.selectJkHistoryAlarmListExcel(jkHistoryAlarm);
  }

  /**
   * 实时检测 功能 的多 sheet页  展示 组态图  测点 报警信息
   *
   * @param jkHistoryAlarm
   * @return
   */
  @Override
  public List<JkHistoryAlarm> selectHistoryAlarmNoteList(JkHistoryAlarm jkHistoryAlarm) {
    return historyAlarmMapper.selectHistoryAlarmNoteList(jkHistoryAlarm);
  }

  @Override
  public void updateHistoryAlarm(String alarmCode, HistoryAlarm historyAlarm) {
    historyAlarmMapper.updateHistoryAlarm(alarmCode, historyAlarm);
  }

  @Override
  public Page<JkHistoryAlarm> selectJkHistoryAlarmPage(JkHistoryAlarm jkHistoryAlarm, Long pageNum, Long pageSize) {
    final Page<JkHistoryAlarm> jkHistoryAlarmPage = historyAlarmMapper.selectJkHistoryAlarmPage(jkHistoryAlarm, new Page<>(pageNum, pageSize));
    jkHistoryAlarmPage.getRecords().forEach(alarm->{
      final String indexType = alarm.getIndexType();
      final String indexId = alarm.getIndexId();
      if("COLLECT".equals(indexType) && StringUtils.isEmpty(alarm.getEnergyId())){
        //根据nodeId和indexId 去查询计量器具
        EnergyIndex energyIndex = energyIndexMapper.selectEnergyIndexById(indexId);
        final MeterImplement meterImplement = meterImplementMapper.selectMeterImplementById(energyIndex.getMeterId());
        alarm.setEnergyId(meterImplement.getEnergyType());
      }
    });
    return jkHistoryAlarmPage;
  }
  
}
