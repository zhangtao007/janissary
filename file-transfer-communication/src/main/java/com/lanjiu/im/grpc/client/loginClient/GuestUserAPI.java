package com.lanjiu.im.grpc.client.loginClient;

import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;

public class GuestUserAPI {

    public ResponseUser loginGuestUser(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.loginGuestUser(request);
        return responseUser;
    }

    public ResponseUser storageGuestUserInfo(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.storageGuestUserInfo(request);
        return responseUser;
    }

    public ResponseUser logoutGuestUser(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.logoutGuestUser(request);
        return responseUser;
    }

    public ResponseUser selectGuestUserInfo(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.selectGuestUserInfo(request);
        return responseUser;
    }

    public ResponseUser updateGuestUserInfo(RequestUser request) {
        LoginRegistCommon loginRegistCommon = new LoginRegistCommon();
        ResponseUser responseUser = loginRegistCommon.updateGuestUserInfo(request);
        return responseUser;
    }



}
