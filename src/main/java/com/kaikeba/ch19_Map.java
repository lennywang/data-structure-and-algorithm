package com.kaikeba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 **/
public class ch19_Map {

    public static void main(String[] args) {
        MyTree myTree = new MyTree();
        myTree.add("世界", "亚洲");
        myTree.add("世界", "欧洲");
        myTree.add("世界", "美洲");
        myTree.add("亚洲", "日本");
        myTree.add("亚洲", "韩国");
        myTree.add("亚洲", "中国");
        myTree.add("中国", "北京");
        myTree.add("中国", "上海");
        myTree.add("中国", "深圳");
        System.out.println(myTree.getParent("上海"));

        System.out.println(myTree.getChild("中国"));
    }
}

class MyTree {
    private Map map_up = new HashMap();
    private Map map_down = new HashMap();

    public void add(String parent, String child) {
        map_up.put(child, parent);
        List list = (List) map_down.get(parent);
        if (list == null) {
            list = new ArrayList();
            map_down.put(parent, list);
        }
        list.add(child);
    }

    public String getParent(String key) {
        return (String) map_up.get(key);
    }

    public List getChild(String key){
        return (List) map_down.get(key);
    }
}