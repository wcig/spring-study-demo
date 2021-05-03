package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;

/**
 * time_type_test (字符串类型测试表)
 */
@Data
@Accessors(chain = true)
public class NewTimeTypeTest {
    // column:id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer id;

    // column:year_t, pk:false, maxLength:0, isNull:true, comment:
    // private LocalDate yearT;
    private Year yearT;

    // column:date_t, pk:false, maxLength:10, isNull:true, comment:
    private LocalDate dateT;

    // column:time_t, pk:false, maxLength:8, isNull:true, comment:
    private LocalTime timeT;

    // column:datetime_t, pk:false, maxLength:19, isNull:true, comment:
    private LocalDateTime datetimeT;

    // column:timestamp_t, pk:false, maxLength:19, isNull:false, comment:
    private LocalDateTime timestampT;

    // column:bigint_t, pk:false, maxLength:19, isNull:true, comment:
    private Long bigintT;
}