package com.lanjiu.im.storage.enums;

import java.util.HashMap;

public enum  MemberType {
    OWNER(0, "群主"),
    MEMBER(1, "成员");

    private int key;

    private String text;

    MemberType(int key, String text) {
        this.key = key;
        this.text = text;
    }

    private static HashMap<Integer,MemberType> map = new HashMap<>();
    static {
        for(MemberType d : MemberType.values()){
            map.put(d.key, d);
        }
    }

    public static MemberType parse(Integer index) {
        if(map.containsKey(index)){
            return map.get(index);
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public String getText() {
        return text;
    }
}
