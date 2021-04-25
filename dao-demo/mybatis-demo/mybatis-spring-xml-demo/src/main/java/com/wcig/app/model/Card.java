package com.wcig.app.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * card (身份证信息表)
 */
@Data
@Accessors(chain = true)
public class Card {
    // column:card_id, pk:true, maxLength:10, isNull:false, comment:主键id
    private Integer cardId;

    // column:num, pk:false, maxLength:60, isNull:false, comment:身份证号
    private String num;
}