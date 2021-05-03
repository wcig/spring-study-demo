package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * int_type_test (数字类型测试表)
 */
@Data
@Accessors(chain = true)
public class IntTypeTest {
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    // column:tinyint_t, pk:false, maxLength:3, isNull:true, comment:
    private Integer tinyintT;

    // column:smallint_t, pk:false, maxLength:5, isNull:true, comment:
    private Integer smallintT;

    // column:middleint_t, pk:false, maxLength:7, isNull:true, comment:
    private Integer middleintT;

    // column:int_t, pk:false, maxLength:10, isNull:true, comment:
    private Integer intT;

    // column:bigint_t, pk:false, maxLength:19, isNull:true, comment:
    private Long bigintT;

    // column:float_t, pk:false, maxLength:12, isNull:true, comment:
    private Float floatT;

    // column:double_t, pk:false, maxLength:22, isNull:true, comment:
    private Double doubleT;

    // column:decimal_t, pk:false, maxLength:6, isNull:true, comment:
    private BigDecimal decimalT;
}