package com.goforit.firstapple.common.service.impl;

import com.goforit.firstapple.common.mapper.SequenceMapper;
import com.goforit.firstapple.common.model.SequenceDO;
import com.goforit.firstapple.common.service.SequenceService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by junqingfjq on 16/6/24.
 */

@Service(value = "sequenceService")
public class SequenceServiceImpl implements SequenceService {

    private static final Logger LOGGER= LoggerFactory.getLogger(SequenceServiceImpl.class);

    @Autowired
    private SequenceMapper sequenceMapper;

    @Override
    public String generate(TableName tableName) {
        return generate(tableName,Strategy.DEFAULT);
    }

    @Override
    public String generate(TableName tableName, Strategy strategy) {

        SequenceDO sequenceDO=new SequenceDO();
        sequenceDO.setTableName(tableName.name());
        sequenceMapper.add(sequenceDO);

        return fulfillElement(Long.toString(sequenceDO.getId()),strategy);
    }

    private String fulfillElement(String obj,Strategy strategy){
        if(null==strategy){
            return obj;
        }

        return StringUtils.leftPad(obj.toString(),strategy.getSize(),strategy.getPadString());
    }
}
