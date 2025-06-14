package com.exercises.sort;

import java.util.*;

/**
 * 对项目项目排序的帮助类
 * 对确定好相互依赖关系的项目进行排序。（按照有向图的拓扑排序原理） <li>a)
 * 从项目VO中找到不依赖其他项目的项目记入顺序队列中； <li>b)
 * 从项目中删除所有项目对该项目的依赖关系； <li>c)
 * 重复以上两步，直至全部项目都排好序，拓扑排序顺利完成。
 * 否则，若剩有还依赖于其他项目的项目，说明图中有环，拓扑排序不能进行。
 */
public class ItemSortUtil<T> {

    /**
     * 得到项目的环， 便于显示
     *
     * @param itemMap
     * @return
     */
    private Map<T, List<T>> getCircle(Map<T, List<T>> itemMap) {
        Map<T, List<T>> leftItemMap = new HashMap<>();
        Iterator<T> it = itemMap.keySet().iterator();
        List<T> usefulValue = new LinkedList<T>();
        while (it.hasNext()) {
            T keyItem = it.next();
            List<T> values = itemMap.get(keyItem);
            for (T value : values) {
                if (!usefulValue.contains(value)) {
                    usefulValue.add(value);
                }
            }
        }

        for (T useful : usefulValue) {
            if (itemMap.containsKey(useful)) {
                leftItemMap.put(useful, itemMap.get(useful));
            }
        }

        if (itemMap.size() != leftItemMap.size()) {
            return this.getCircle(leftItemMap);
        } else {
            return leftItemMap;
        }
    }

    /**
     * 对于 v的每个邻接点入度减1
     *
     * @param itemVO
     * @param itemMap
     * @return
     */
    private Map<T, List<T>> getLeftItemMap(T itemVO, Map<T, List<T>> itemMap) {
        itemMap.remove(itemVO);
        if (!itemMap.isEmpty()) {
            Iterator<T> it = itemMap.keySet().iterator();
            while (it.hasNext()) {
                List<T> list = itemMap.get(it.next());
                if (list != null && !list.isEmpty() && list.contains(itemVO)) {
                    list.remove(itemVO);
                }
            }
        }

        return itemMap;
    }

    /**
     * @param itemMap 邻接表
     * @return 排序结果
     */
    public LinkedList<T> topologicalSort(Map<T, List<T>> itemMap) {
        // 拓扑序列
        LinkedList<T> topSeq = new LinkedList<T>();
        LinkedList<T> s = new LinkedList<T>();
        Iterator<T> it = itemMap.keySet().iterator();
        int numberItems = itemMap.size();
        // 初始化顶点集应用信息
        // 生成拓扑序列
        while (it.hasNext()) {
            T keyItem = it.next();
            List<T> dependItems = itemMap.get(keyItem);
            if (dependItems == null || dependItems.isEmpty()) {
                s.addLast(keyItem);
            }
        }
        while (!s.isEmpty()) {
            Map<T, List<T>> adjMap = null;
            // 入度为 0 的顶点入栈
            while (!s.isEmpty()) {
                T v = s.removeFirst();
                topSeq.addLast(v);
                // 对于 v的每个邻接点入度减1
                adjMap = this.getLeftItemMap(v, itemMap);
            }
            Iterator<T> adjIt = adjMap.keySet().iterator();
            while (adjIt.hasNext()) {
                T adjKeyItem = adjIt.next();
                List<T> dependItems = adjMap.get(adjKeyItem);
                if (dependItems == null || dependItems.isEmpty()) {
                    s.addFirst(adjKeyItem);
                }
            }
        }
        if (topSeq.size() < numberItems) {
            itemMap = this.getCircle(itemMap);
            Set<T> circularItems = itemMap.keySet();
            String strIn = null;
            for (T item : circularItems) {
                if (strIn == null) {
                    strIn = "[" + item.toString() + "]";
                } else {
                    strIn = strIn + ", " + "[" + item.toString() + "]";
                }
            }
            throw new RuntimeException("{0}项目存在环状相互依赖关系！请修改项目。" + strIn);
        } else {
            return topSeq;
        }
    }

    public static void main(String[] args) {

    }

}

