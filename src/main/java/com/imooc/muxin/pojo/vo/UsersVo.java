package com.imooc.muxin.pojo.vo;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Users
 *
 * @author : binbin
 * @description : ToDo
 * @date : 2019/11/17
 **/
public class UsersVo {
    private String id;
    private String username;
    private String faceImage;
    private String faceImageBig;
    private String nickname;
    private String qrcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    public String getFaceImageBig() {
        return faceImageBig;
    }

    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }
}
