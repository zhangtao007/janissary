package com.lanjiu.im.grpc.util;

import java.util.List;

public class CommonUtils<T> {

    public boolean isHave(List<T> list){
        if((null != list) && (list.size() > 0)){
            return true;
        }else {
            return false;
        }
    }

    public Object[] deleteSubString(String str1,String str2) {
        StringBuffer sb = new StringBuffer(str1);
        int delCount = 0;
        Object[] obj = new Object[2];
        while (true) {
            int index = sb.indexOf(str2);
            if(index == -1) {
                break;
            }
            sb.delete(index, index+str2.length());
            delCount++;

        }
        if(delCount!=0) {
            obj[0] = sb.toString();
            obj[1] = delCount;
        }else {
            //不存在返回-1
            obj[0] = -1;
            obj[1] = -1;
        }
        return obj;
    }
}
