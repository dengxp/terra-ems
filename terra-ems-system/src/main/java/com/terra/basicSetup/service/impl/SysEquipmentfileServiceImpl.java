package com.terra.basicSetup.service.impl;

import com.terra.basicSetup.mapper.SysEquipmentfileMapper;
import com.terra.basicSetup.service.ISysEquipmentfileService;
import com.terra.realtimedata.domain.SysEquipmentFile;
import com.terra.realtimedata.domain.SysSvgInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 组态图Service业务层处理
 *
 * @author sys
 * @date 2020-02-24
 */
@Service
public class SysEquipmentfileServiceImpl implements ISysEquipmentfileService {

  @Autowired
  private SysEquipmentfileMapper equipmentfileMapper;

  @Override
  public void saveEquipmentFile(SysEquipmentFile sysEquipmentfile) {
    SysEquipmentFile sysEquipmentFile = equipmentfileMapper.selectById(sysEquipmentfile.getNodeId());
    if (ObjectUtils.isNotEmpty(sysEquipmentFile)){
      sysEquipmentFile.setFilePath(sysEquipmentfile.getFilePath());
      equipmentfileMapper.updateById(sysEquipmentFile);
    }else {
      SysEquipmentFile equipmentFile = new SysEquipmentFile();
      equipmentFile.setFilePath(sysEquipmentfile.getFilePath());
      equipmentFile.setNodeId(sysEquipmentfile.getNodeId());
      equipmentfileMapper.insert(equipmentFile);
    }
  }

  @Override
  public void saveSettingInfo(String nodeId, List<SysSvgInfo> svgInfo) {
    equipmentfileMapper.saveSettingInfo(nodeId, svgInfo);
  }

  @Override
  public SysEquipmentFile getConfigure(String nodeId) {
    SysEquipmentFile sysEquipmentfile = equipmentfileMapper.getConfigure(nodeId);
    List<SysSvgInfo> infos = getConfigureTag(nodeId);
    if (sysEquipmentfile != null) {
      sysEquipmentfile.setInfoList(infos);
    }

    return sysEquipmentfile;
  }

  @Override
  public List<SysSvgInfo> getConfigureTag(String nodeId) {
    return equipmentfileMapper.getConfigureTag(nodeId);
  }
}
