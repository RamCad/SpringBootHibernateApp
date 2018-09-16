/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramcharan.samplespringbootapp;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ramcharan.adapa
 */
@RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration({"classpath*:spring/applicationContext.xml"})
public class LocaleResolverTest {
    
    
    @Test
    public void testConvertLocaleInputs(){
        //Notification notification = MockNotificationData.mockNotification();

        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> test = new HashMap<>();
        Map<String, Object> children = new HashMap<>();
        Map<String, Object> child = new HashMap<>();
        child.put("key1", "value1");
        children.put("child", child);
        test.put("children", children);
        parameters.put("test", test);

    //notification.setParameters(parameters);    

    Map<String, Object> parameterMap = LocaleResolver.getParameters(parameters);

    assertNotEquals(parameters, parameterMap);
    }
    
    @Test
    public void testConvertLocaleInputs_passKeyWithoutValue(){
    //Notification notification = MockNotificationData.mockNotification();

        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> test = new HashMap<>();
        Map<String, Object> children = new HashMap<>();
        Map<String, Object> child = new HashMap<>();
        child.put("keywithoutvalue", "keywithoutvalue");
        children.put("child", child);
        test.put("children", children);
        parameters.put("test", test);

    //notification.setParameters(parameters);    

    //notificationLocaleResolver.convertLocaleInputs(notification);

    Map<String, Object> parameterMap = LocaleResolver.getParameters(parameters);

    assertEquals(parameters, parameterMap);
    }
    
    @Test
    public void testConvertLocaleInputs_passKeyNotExists(){
    //Notification notification = MockNotificationData.mockNotification();

        Map<String, Object> parameters = new HashMap<>();
        Map<String, Object> test = new HashMap<>();
        Map<String, Object> children = new HashMap<>();
        Map<String, Object> child = new HashMap<>();
        child.put("keynotexists", "keynotexists");
        children.put("child", child);
        test.put("children", children);
        parameters.put("test", test);
        parameters.put("test1", test);

    //notification.setParameters(parameters);    

    //notificationLocaleResolver.convertLocaleInputs(notification);

    //assertEquals(parameters, notification.getRecipients().get(0).getLocalizedParameters());
    Map<String, Object> parameterMap = LocaleResolver.getParameters(parameters);

    assertEquals(parameters, parameterMap);
    }
}
