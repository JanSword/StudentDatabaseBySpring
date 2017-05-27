package com.biz.std.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Created by dell on 2017/5/15.
 */
public class DataSourceTest {

    private ApplicationContext ctx = null;

    @Before
    public void setup(){
        ctx= new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx=null;
        System.out.println("tearDown");
    }

    @Test
    public void testDataSource(){
        DataSource dataSource=(DataSource)ctx.getBean("dataSource");
        Assert.assertNotNull(dataSource);
    }
}
