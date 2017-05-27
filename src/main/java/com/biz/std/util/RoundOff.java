package com.biz.std.util;

import java.math.BigDecimal;

/**
 * 保留两位小数
 */
public class RoundOff {
    public float roundOff(float a) {
        BigDecimal bigDecimal = new BigDecimal(a);
        return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
