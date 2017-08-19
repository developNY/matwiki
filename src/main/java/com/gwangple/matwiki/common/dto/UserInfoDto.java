package com.gwangple.matwiki.common.dto;

public class UserInfoDto {

    private String userId;
    private String ipAddr;
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getIpAddr() {
        return ipAddr;
    }
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }
    
    @Override
    public String toString() {
        return "LoginUserInfoDto [userId=" + userId + ", ipAddr=" + ipAddr + "]";
    }
}
