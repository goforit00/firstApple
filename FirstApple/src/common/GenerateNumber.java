package common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * 
 * @author junqing.fjq
 * @version $Id: GenerateNumber.java, v 0.1 2014年9月3日 下午2:01:19 junqing.fjq Exp $
 */
public class GenerateNumber {

    static final Long BIGNUM                   = 198911090470L;
    static final int  UNIQUE_NUMBER_MIN_LENGTH = 14;
    static final int  UNIQUE_NUMBER_MAX_LENGTH = 24;

    /**
     * 至少14位 ,最长24位
     * @param length 产生的数字长度
     * @return 产生的数字
     */
    public static String generateUniqueNumber(int length) {
        String uniqueNum = null;
        if (length < UNIQUE_NUMBER_MIN_LENGTH || length > UNIQUE_NUMBER_MAX_LENGTH)
            return uniqueNum;

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        uniqueNum = df.format(date);

        Random rand = new Random();
        rand.setSeed(date.getTime());
        for (int i = 0; i < length - UNIQUE_NUMBER_MIN_LENGTH; i++) {
            uniqueNum += String.valueOf(rand.nextInt(9));
        }

        return uniqueNum;
    }
}
