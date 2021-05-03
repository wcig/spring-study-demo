package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * enum_type_test (枚举类型测试表)
 */
@Data
@Accessors(chain = true)
public class EnumTypeTest {
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    // column:enum_t, pk:false, maxLength:1, isNull:true, comment:
    private String enumT;
}