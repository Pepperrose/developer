package com.groges.developer.util;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author:xiewt
 * @Description:
 * @Date:Create in 2018/1/31 13:47
 * @Modify By:
 */
public class GsonUtil {
    private static Gson gson = new Gson();

    /**
     * 对象序列化为json字符串
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String objectToJsonStr(T object) {
        return gson.toJson(object);
    }

    /**
     * json字符串解析为List集合
     * @param jsonStr
     * @param type
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonToList(String jsonStr , Type type) {
        return gson.fromJson(jsonStr ,type);
    }

    /**
     * json字符串解析为对象
     * @param jsonStr
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T jsonStrToObject(String jsonStr ,Class<T> classOfT) {
        return gson.fromJson(jsonStr ,classOfT);
    }


    public static ParameterizedType type(final Class<?> raw ,final Type... args) {
        return new ParameterizedType() {
            public Type[] getActualTypeArguments() {
                return args;
            }

            public Type getRawType() {
                return null;
            }

            public Type getOwnerType() {
                return null;
            }
        };
    }
}
