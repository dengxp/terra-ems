package com.terra.web.controller.realtimedata;

import com.terra.common.core.controller.BaseController;
import com.terra.common.core.domain.AjaxResult;
import com.terra.model.domain.EnergyIndex;
import com.terra.model.service.IEnergyIndexService;
import com.terra.realtimedata.domain.TagValue;
import com.terra.realtimedata.domain.TagValueResult;
import com.terra.realtimedata.service.RealtimeDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rtdb")
public class RealtimeDataController extends BaseController {

  @Autowired
  private RealtimeDatabaseService realtimeDatabaseService;

  @Autowired
  private IEnergyIndexService energyIndexService;

  @GetMapping("/retrieve/{tagCodes}")
  @ResponseBody
  public AjaxResult getLiveData(@PathVariable("tagCodes") String[] tagCodes) {
    List<String> codes = new ArrayList<>(Arrays.asList(tagCodes));
    List<TagValue> tagValues = realtimeDatabaseService.retrieve(codes);
    List<EnergyIndex> energyIndices = energyIndexService.getEnergyIndexMeterByCodes(codes);
    Map<String, EnergyIndex> mapValue = energyIndices.stream()
        .collect(Collectors.toMap(EnergyIndex::getCode, m -> m));
    List<TagValueResult> results = new ArrayList<>();
    if (!tagValues.isEmpty()) {
      tagValues.forEach(value -> {
        TagValueResult result = new TagValueResult();
        if (mapValue.containsKey(value.getTagCode())) {
          EnergyIndex energyIndex = mapValue.get(value.getTagCode());
          result.setTagName(energyIndex.getName());
          result.setUnitId(energyIndex.getUnitId());
          result.setMeteName(energyIndex.getMeterName());
        }

        result.setTagCode(value.getTagCode());
        result.setValue(value.getValue());
        result.setDataTime(value.getDataTime());
        result.setQuality(value.getQuality());
        results.add(result);
      });
    }
    return AjaxResult.success(results);
  }
}
