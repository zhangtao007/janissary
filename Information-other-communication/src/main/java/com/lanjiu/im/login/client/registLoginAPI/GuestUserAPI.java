package com.lanjiu.im.login.client.registLoginAPI;

import com.lanjiu.im.login.client.FriendMessageCommon;
import com.lanjiu.pro.login.RequestUser;
import com.lanjiu.pro.login.ResponseUser;

public class GuestUserAPI {

    public ResponseUser loginGuestUser(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.loginGuestUser(request);
        return responseUser;
    }

    public ResponseUser storageGuestUserInfo(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.storageGuestUserInfo(request);
        return responseUser;
    }

    public ResponseUser logoutGuestUser(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.logoutGuestUser(request);
        return responseUser;
    }

    public ResponseUser selectGuestUserInfo(RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.selectGuestUserInfo(request);
        return responseUser;
    }

   /* public com.lanjiu.im.storage.ResponseUser selectGuestUser(com.lanjiu.im.storage.RequestUser request) {
        FriendMessageCommon friendMessageCommon = new FriendMessageCommon();
        ResponseUser responseUser = friendMessageCommon.selectGuestUser(request);
        return responseUser;
    }*/

}
