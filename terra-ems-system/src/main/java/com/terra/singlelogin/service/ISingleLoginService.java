package com.terra.singlelogin.service;

import com.terra.common.core.domain.entity.SysUser;

/**
 * description todu
 *
 * @author hmj
 * @date 2024-11-15 17:08
 */
public interface ISingleLoginService {
    SysUser singleLogin(String token);
}
