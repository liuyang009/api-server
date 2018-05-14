package io.common.apiserver.util;

import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author Five.Liu
 * @create 2017-08-30 10:18
 */
public class StringUtil extends StringUtils{

    public static boolean isEmpty(Object obj){
        if(obj instanceof List){
            return ((List)obj).isEmpty();
        }else if(obj instanceof Set){
            return ((Set)obj).isEmpty();
        }else if(obj instanceof Map){
            return ((Map)obj).isEmpty();
        }
        return obj == null || obj.toString().isEmpty();
    }

    public static boolean isEmpty(String str){
        return str == null || str.toString().isEmpty();
    }

    public static String trim(Object str){
        return str == null?"":str.toString().trim();
    }

    public static String trim(String str){
        return str == null?"":str.toString().trim();
    }
}
