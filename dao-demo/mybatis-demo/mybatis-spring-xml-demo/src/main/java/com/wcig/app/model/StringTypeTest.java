package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * string_type_test (字符串类型测试表)
 */
@Data
@Accessors(chain = true)
public class StringTypeTest {
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    // column:char_t, pk:false, maxLength:32, isNull:true, comment:
    private String charT;

    // column:varchar_t, pk:false, maxLength:32, isNull:true, comment:
    private String varcharT;

    // column:tinytext_t, pk:false, maxLength:255, isNull:true, comment:
    private String tinytextT;

    // column:text_t, pk:false, maxLength:65535, isNull:true, comment:
    private String textT;

    // column:mediumtext_t, pk:false, maxLength:16777215, isNull:true, comment:
    private String mediumtextT;

    // column:longtext_t, pk:false, maxLength:2147483647, isNull:true, comment:
    private String longtextT;
}