package com.goforit.firstapple.common.mapper;

import com.goforit.firstapple.common.model.SystemConfigInfo;

/**
 * Created by junqingfjq on 16/6/23.
 */
public interface SystemConfigMapper {

    void create(SystemConfigInfo systemConfigInfo);

    SystemConfigInfo get(String key);
}
