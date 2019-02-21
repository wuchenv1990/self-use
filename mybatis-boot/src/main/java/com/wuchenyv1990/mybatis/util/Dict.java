package com.wuchenyv1990.mybatis.util;

import java.util.LinkedHashMap;

/**
 * 使用:d.set(k1,v1).and(k1,v2)
 *
 * @param <K> key
 * @param <V> value
 */
public class Dict<K, V> extends LinkedHashMap<K, V> {

    public static <K, V> Dict<K, V> set(K k, V v) {
        return new Dict<K, V>().and(k, v);
    }

    public Dict<K, V> and(K key, V value) {
        put(key, value);
        return this;
    }

}
