package com.wcig.app.dao;

import com.wcig.app.MybatisSpringXmlApp;
import com.wcig.app.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 基础类型测试
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= MybatisSpringXmlApp.class)
public class BasicTypeTest {

    @Resource
    private IntTypeTestMapper intTypeTestMapper;
    @Resource
    private StringTypeTestMapper stringTypeTestMapper;
    @Resource
    private TimeTypeTestMapper timeTypeTestMapper;
    @Resource
    private NewTimeTypeTestMapper newTimeTypeTestMapper;
    @Resource
    private EnumTypeTestMapper enumTypeTestMapper;
    @Resource
    private NewEnumTypeTestMapper newEnumTypeTestMapper;

    @Test
    public void testIntType() {
        IntTypeTest intTypeTest = new IntTypeTest()
                .setId(1)
                .setSmallintT(1)
                .setMiddleintT(1)
                .setSmallintT(1)
                .setIntT(1)
                .setBigintT(1L)
                .setFloatT(1.1F)
                .setDoubleT(1.1D)
                .setDecimalT(new BigDecimal("1.11"));
        int affected = intTypeTestMapper.insert(intTypeTest);
        assertEquals(1, affected);

        intTypeTest.setTinyintT(2);
        affected = intTypeTestMapper.updateByPrimaryKey(intTypeTest);
        assertEquals(1, affected);

        IntTypeTest test = intTypeTestMapper.selectByPrimaryKey(1);
        assertNotNull(test);

        affected = intTypeTestMapper.deleteByPrimaryKey(1);
        assertEquals(1, affected);
    }

    @Test
    public void testStringType() {
        StringTypeTest stringTypeTest = new StringTypeTest()
                .setId(1)
                .setCharT("abc")
                .setVarcharT("abc")
                .setTinytextT("abc")
                .setTextT("abc")
                .setMediumtextT("abc")
                .setLongtextT("abc");
        int affected = stringTypeTestMapper.insert(stringTypeTest);
        assertEquals(1, affected);

        stringTypeTest.setVarcharT("abcdef");
        affected = stringTypeTestMapper.updateByPrimaryKey(stringTypeTest);
        assertEquals(1, affected);

        StringTypeTest test = stringTypeTestMapper.selectByPrimaryKey(1);
        assertNotNull(test);

        affected = stringTypeTestMapper.deleteByPrimaryKey(1);
        assertEquals(1, affected);
    }

    @Test
    public void testTimeType() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Year year = Year.of(calendar.get(Calendar.YEAR));
        long ts = date.getTime();
        log.info("date: {}, year: {}, ts: {}", date, year, ts);

        TimeTypeTest timeTypeTest = new TimeTypeTest()
                .setId(1)
                // .setYearT(date)
                .setYearT(year)
                .setDateT(date)
                .setTimeT(date)
                .setDatetimeT(date)
                .setTimestampT(date)
                .setBigintT(date.getTime());
        int affected = timeTypeTestMapper.insert(timeTypeTest);
        assertEquals(1, affected);

        timeTypeTest.setDatetimeT(new Date());
        affected = timeTypeTestMapper.updateByPrimaryKey(timeTypeTest);
        assertEquals(1, affected);

        TimeTypeTest test = timeTypeTestMapper.selectByPrimaryKey(1);
        assertNotNull(test);
        log.info("timeTypeTest: {}", test);

        affected = timeTypeTestMapper.deleteByPrimaryKey(1);
        assertEquals(1, affected);
    }

    @Test
    public void testNewTimeType() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        Year year = Year.of(localDateTime.getYear());
        long ts = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        log.info("date: {}, year: {}, ts: {}", localDateTime, year, ts);

        NewTimeTypeTest newTimeTypeTest = new NewTimeTypeTest()
                .setId(2)
                // .setYearT(localDate)
                .setYearT(Year.of(localDateTime.getYear()))
                .setDateT(localDate)
                .setTimeT(localTime)
                .setDatetimeT(localDateTime)
                .setTimestampT(localDateTime)
                .setBigintT(System.currentTimeMillis());
        int affected = newTimeTypeTestMapper.insert(newTimeTypeTest);
        assertEquals(1, affected);

        newTimeTypeTest.setDatetimeT(LocalDateTime.now());
        affected = newTimeTypeTestMapper.updateByPrimaryKey(newTimeTypeTest);
        assertEquals(1, affected);

        NewTimeTypeTest test = newTimeTypeTestMapper.selectByPrimaryKey(2);
        assertNotNull(test);
        log.info("newTimeTypeTest: {}", test);

        affected = newTimeTypeTestMapper.deleteByPrimaryKey(2);
        assertEquals(1, affected);
    }

    @Test
    public void testStringEnumType() {
        EnumTypeTest enumTypeTest = new EnumTypeTest().setId(1).setEnumT(SexEnum.MALE.getVal());
        int affected = enumTypeTestMapper.insert(enumTypeTest);
        assertEquals(1, affected);

        enumTypeTest.setEnumT(SexEnum.FEMAILE.getVal());
        affected = enumTypeTestMapper.updateByPrimaryKey(enumTypeTest);
        assertEquals(1, affected);

        EnumTypeTest test = enumTypeTestMapper.selectByPrimaryKey(1);
        assertNotNull(test);
        log.info("enumTypeTest: {}", test);

        affected = enumTypeTestMapper.deleteByPrimaryKey(1);
        assertEquals(1, affected);
    }

    @Test
    public void testEnumEnumType() {
        NewEnumTypeTest newEnumTypeTest = new NewEnumTypeTest().setId(1).setEnumT(SexEnum.MALE);
        int affected = newEnumTypeTestMapper.insert(newEnumTypeTest);
        assertEquals(1, affected);

        newEnumTypeTest.setEnumT(SexEnum.FEMAILE);
        affected = newEnumTypeTestMapper.updateByPrimaryKey(newEnumTypeTest);
        assertEquals(1, affected);

        NewEnumTypeTest test = newEnumTypeTestMapper.selectByPrimaryKey(1);
        assertNotNull(test);
        log.info("newEnumTypeTest: {}", test);

        affected = newEnumTypeTestMapper.deleteByPrimaryKey(1);
        assertEquals(1, affected);
    }
}
