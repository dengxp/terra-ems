package com.terra.alarm.services;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.terra.alarm.domain.HistoryAlarm;
import com.terra.alarm.domain.JkHistoryAlarm;
import com.terra.common.enums.TimeType;

import java.util.Date;
import java.util.List;

public interface IHistoryAlarmService {

  List<HistoryAlarm> getHistoryAlarm(Date beginTime, Date endTime);

  List<HistoryAlarm> getHistoryAlarm(Date beginTime, Date endTime, TimeType timeType);

  List<HistoryAlarm> getHistoryAlarm(Date beginTime, Date endTime, String alarmType);
  /**
   * @param jkHistoryAlarm 根据历史报警对象取值
   * @return
   */
  List<JkHistoryAlarm> selectJkHistoryAlarmList(JkHistoryAlarm jkHistoryAlarm);
  List<JkHistoryAlarm> selectJkHistoryAlarmListExcel(JkHistoryAlarm jkHistoryAlarm);

  /**
   * 实时检测 功能 的多 sheet页  展示 组态图  测点 报警信息
   * @param jkHistoryAlarm
   * @return
   */
  List<JkHistoryAlarm> selectHistoryAlarmNoteList(JkHistoryAlarm jkHistoryAlarm);

  void updateHistoryAlarm(String alarmCode, HistoryAlarm historyAlarm);

  Page<JkHistoryAlarm> selectJkHistoryAlarmPage(JkHistoryAlarm jkHistoryAlarm, Long pageNum, Long pageSize);
}
