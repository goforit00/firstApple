package com.goforit.firstapple.common.utils;

import com.goforit.firstapple.common.service.SequenceService;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by goforit on 16/7/24.
 */
public class SequenceServiceUitl {

    private static final String SEQUENCE_SERVICE_NAME="sequenceService";

    public static String generate(SequenceService.TableName tableName){
        if(null==tableName){
            throw new RuntimeException("tableName can't be null");
        }

        SequenceService sequenceService=(SequenceService)SpringContextUtil.getBean(SEQUENCE_SERVICE_NAME);

        return sequenceService.generate(tableName);
    }
}
