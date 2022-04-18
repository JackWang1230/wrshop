package cn.wr.common.utils;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * 对象属性复制
 * @author RWang
 * @Date 2022/4/18
 */

public class BeanUtil {

    public static void copyProperties(Object objectFrom,Object objectTo){
        BeanUtils.copyProperties(objectFrom,objectTo);
    }

    /**
     * 获取属性名数组
     * @param o
     * @return
     */
    public static String[] getFieldName(Object o){
        Field[] fields = o.getClass().getDeclaredFields();
        Field[] superFields = o.getClass().getSuperclass().getDeclaredFields();
        String[] fieldNames = new String[fields.length + superFields.length];
        int index = 0;
        for (int i = 0; i < fields.length; i++) {
            fieldNames[index] = fields[i].getName();
            index++;
        }
        for (int i = 0; i < superFields.length; i++) {
            if ("id".equals(superFields[i].getName())) {
                continue;
            }
            fieldNames[index] = superFields[i].getName();
            index++;
        }
        return fieldNames;
    }

    /**
     * 根据属性名称获取属性值
     * @param fieldName
     * @param o
     * @return
     */
    public static Object getFieldValueByName(String fieldName,Object o){

        try {
            // 第一个值改成大写
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            // 组装数据
            String getter = "get" + firstLetter + fieldName.substring(1);

            Method method = o.getClass().getMethod(getter, new Class[]{});
            Object value= method.invoke(method, new Object[]{});
            return value;
        } catch (Exception e){
            return null;
        }
    }


    /**
     * 将对象转换成key value形式
     * A=a&B=b&C=c 格式
     * @param object
     * @return
     */
    public static String formatKeyValuePair(Object object){
        StringBuilder stringBuffer = new StringBuilder();
        String[] fieldNames = BeanUtil.getFieldName(object);
        for (int j = 0; j < fieldNames.length; j++) {
            //不是第一个并且不是最后一个，拼接&
            if (j != 0) {
                stringBuffer.append("&");
            }
            //获取属性的名字
            String key = fieldNames[j];
            //获取值
            Object value = BeanUtil.getFieldValueByName(key, object);
            assert value != null;
            stringBuffer.append(key).append("=").append(value.toString());
        }
        return stringBuffer.toString();
    }


    public static <T> T formatKeyValuePair(String str,T t){

        //填写对参数键值对
        String[] params = str.split("&");

        //获取对象字段
        String[] fieldNames = BeanUtil.getFieldName(t);

        try {
            //循环每个参数
            for (String param : params) {
                String[] keyValues = param.split("=");
                for (int i = 0; i < fieldNames.length; i++) {
                    if (fieldNames[i].equals(keyValues[0])) {
                        Field f = t.getClass().getDeclaredField(fieldNames[i]);
                        f.setAccessible(true);
                        //长度为2 才转换，否则不转
                        if (keyValues.length == 2) {
                            f.set(t, keyValues[1]);
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;

    }

}
