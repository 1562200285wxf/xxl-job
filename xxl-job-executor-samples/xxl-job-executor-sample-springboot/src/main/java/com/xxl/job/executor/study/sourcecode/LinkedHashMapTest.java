package com.xxl.job.executor.study.sourcecode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-28 14:22
 * @description：
 */
public class LinkedHashMapTest {

    static class Entry<K,V> extends HashMapTest.Node<K,V> {
        LinkedHashMapTest.Entry<K,V> before, after;
        Entry(int hash, K key, V value, HashMapTest.Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
}
