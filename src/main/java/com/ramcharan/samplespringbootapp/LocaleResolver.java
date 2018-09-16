package com.ramcharan.samplespringbootapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.apache.commons.lang.LocaleUtils;

/**
 *
 * @author ramcharan.adapa
 */
public class LocaleResolver {
    
    public static Map<String, Object> getParameters(Map<String, Object> parameters){
        Map<String, Object> parameterMap = new HashMap<>();
        parameters.entrySet().stream().filter((entry) -> (entry.getValue() instanceof HashMap)).forEachOrdered((entry) -> {
            parameterMap.put(entry.getKey(), convertParametersToLocaleText(entry.getValue()));
        });
        return parameterMap;
    }
    
    private static Object convertParametersToLocaleText(Object value){
        Map<String, Object> tempMap = new HashMap<>();
        Map<String, Object> testMap = (Map<String, Object>) value;
        testMap.entrySet().forEach((entry) -> {
            if(entry.getValue() instanceof HashMap){
                tempMap.put(entry.getKey(), convertParametersToLocaleText(entry.getValue()));
            }
            else if (entry.getValue() instanceof String){
                tempMap.put(entry.getKey(), convertToLocaleText(entry));
            }
        });
        return tempMap;
    }
    
    private static Object convertToLocaleText(Entry<String, Object> entry){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.ramcharan.somebundle", LocaleUtils.toLocale("es_AR"));
        try{
            if(resourceBundle.getString(entry.getKey()).length() > 0){
                return resourceBundle.getString(entry.getKey());
            }
            else {
                return entry.getValue();
            }
        } catch(MissingResourceException missingResource){
            //System.out.println(Arrays.toString(missingResource.getStackTrace()));
            return entry.getValue();
        }
        
    }
    
//    public static void main(String[] args){
//        Map<String, Object> parameters = new HashMap<>();
//        Map<String, Object> test = new HashMap<>();
//        Map<String, Object> children = new HashMap<>();
//        Map<String, Object> child = new HashMap<>();
//        child.put("key1", "value1");
//        child.put("keywithoutvalue", "keywithoutvalue");
//        child.put("keynotexists", "keynotexists");
//        children.put("child", child);
//        test.put("children", children);
//        parameters.put("test", test);
//        //parameters.put("test1", test);
//        
//        getParameters(parameters);
//    }
    
}
