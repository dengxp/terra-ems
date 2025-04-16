package com.terra.basicSetup.service;

import com.terra.realtimedata.domain.SysEquipmentFile;
import com.terra.realtimedata.domain.SysSvgInfo;

import java.util.List;

/**
 * 组态图Service接口
 *
 * @author sys
 * @date 2020-02-24
 */
public interface ISysEquipmentfileService {

  void saveEquipmentFile(SysEquipmentFile sysEquipmentfile);

  void saveSettingInfo(String nodeId, List<SysSvgInfo> svgInfo);

  /**
   * 获取组态图配置信息
   * @param nodeId 模型节点 id
   * @return
   */
  SysEquipmentFile getConfigure(String nodeId);

  /**
   * 获取组态图配置的点位号
   * @param nodeId 模型节点 id
   * @return
   */
  List<SysSvgInfo> getConfigureTag(String nodeId);
}
