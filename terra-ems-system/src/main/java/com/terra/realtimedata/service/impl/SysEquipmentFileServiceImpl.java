package com.terra.realtimedata.service.impl;

import com.terra.realtimedata.domain.SysEquipmentFile;
import com.terra.realtimedata.domain.SysSvgInfo;
import com.terra.realtimedata.mapper.SysEquipmentFileMapper;
import com.terra.realtimedata.service.ISysEquipmentFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 拓扑图Service业务层处理
 *
 */
@Service
public class SysEquipmentFileServiceImpl implements ISysEquipmentFileService {

  @Autowired
  private SysEquipmentFileMapper equipmentFileMapper;

  @Override
  public void saveEquipmentFile(SysEquipmentFile sysEquipmentFile) {
    equipmentFileMapper.saveEquipmentFile(sysEquipmentFile);
  }

  @Override
  public void saveSettingInfo(String nodeId, List<SysSvgInfo> svgInfo) {
    equipmentFileMapper.saveSettingInfo(nodeId, svgInfo);
  }

  @Override
  public SysEquipmentFile getConfigure(String nodeId) {
    SysEquipmentFile sysEquipmentFile = equipmentFileMapper.getConfigure(nodeId);
    List<SysSvgInfo> infos = getConfigureTag(nodeId);
    if (sysEquipmentFile != null) {
      sysEquipmentFile.setInfoList(infos);
    }

    return sysEquipmentFile;
  }

  @Override
  public List<SysSvgInfo> getConfigureTag(String nodeId) {
    return equipmentFileMapper.getConfigureTag(nodeId);
  }
}
