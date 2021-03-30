package com.lanjiu.im.grpc.server.controller.query;

import java.util.List;

public class CommonUtils<T> {

    public boolean isHave(List<T> list){
        if((null != list) && (list.size() > 0)){
            return true;
        }else {
            return false;
        }
    }
}
