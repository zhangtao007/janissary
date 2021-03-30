package com.lanjiu.im.grpc.server.controller;

public class InsertResultEntity {

    private boolean bResult;

    private int memberId;

    public boolean isbResult() {
        return bResult;
    }

    public void setbResult(boolean bResult) {
        this.bResult = bResult;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
