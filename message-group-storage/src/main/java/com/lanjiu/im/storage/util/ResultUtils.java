package com.lanjiu.im.storage.util;

import com.google.protobuf.Any;
import com.lanjiu.pro.groupStorage.ResponseResult;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ResultUtils {

    public static ResponseResult responseResultSuccessful(){
        return ResponseResult.newBuilder().setSuccess(true).setMsg(CommKeys.RESULT_SUCCESS_MSG).build();
    }

    public static ResponseResult responseResultSuccessful(Any data){
        return ResponseResult.newBuilder().setSuccess(true).setMsg(CommKeys.RESULT_SUCCESS_MSG).setData(data).build();
    }

    public static ResponseResult responseResultFail(){
        return ResponseResult.newBuilder().setSuccess(false).setMsg(CommKeys.RESULT_FAIL_MSG).build();
    }

    public static ResponseResult responseResult(boolean success){
        return responseResult(success, CommKeys.RESULT_SUCCESS_MSG, Any.newBuilder().build());
    }

    public static ResponseResult responseResult(boolean success, String msg, Any data){
        return ResponseResult.newBuilder().setSuccess(success).setMsg(msg).setData(data).build();
    }

    public static Timestamp nowTime(){
        return Timestamp.valueOf(LocalDateTime.now().withNano(0));
    }


}
