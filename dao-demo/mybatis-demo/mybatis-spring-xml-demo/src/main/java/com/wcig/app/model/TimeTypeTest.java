package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Year;
import java.util.Date;

/**
 * time_type_test (字符串类型测试表)
 */
@Data
@Accessors(chain = true)
public class TimeTypeTest {
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    // column:year_t, pk:false, maxLength:0, isNull:true, comment:
    // private Date yearT; // 注意: mybatis-generator默认映射mysql year为Date类型,需修改为Year类型
    private Year yearT;

    // column:date_t, pk:false, maxLength:10, isNull:true, comment:
    private Date dateT;

    // column:time_t, pk:false, maxLength:8, isNull:true, comment:
    private Date timeT;

    // column:datetime_t, pk:false, maxLength:19, isNull:true, comment:
    private Date datetimeT;

    // column:timestamp_t, pk:false, maxLength:19, isNull:false, comment:
    private Date timestampT;

    // column:bigint_t, pk:false, maxLength:19, isNull:true, comment:
    private Long bigintT;
}