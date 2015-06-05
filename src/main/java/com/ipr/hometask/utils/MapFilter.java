package com.ipr.hometask.utils;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static com.google.common.collect.Sets.newHashSet;
import static java.lang.Math.min;

/**
 * Created by Iwan on 01.06.2015
 */

public class MapFilter {

    public static Map<Integer, Set<String>> getTop(Map<String, Integer> map, int k) {
        Map<Integer, Set<String>> top = new TreeMap<>(Collections.reverseOrder());
        top.putAll(groupWords(map));

        List<Integer> keysList = new ArrayList<>(top.keySet());
        Collections.sort(keysList, Collections.reverseOrder());

        int topSize = min(keysList.size(), k);
        Set<Integer> topKeys = new HashSet<>(keysList.subList(0, topSize));
        top.keySet().retainAll(topKeys);
        return top;
    }

    public static Map<Integer, Set<String>> groupWords(Map<String, Integer> map) {
        Map<Integer, Set<String>> resultMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            Set<String> set = newHashSet(entry.getKey());
            Set<String> prevSet = resultMap.put(entry.getValue(), set);
            if (CollectionUtils.isNotEmpty(prevSet)) {
                set.addAll(prevSet);
            }
        }
        return resultMap;
    }
}
