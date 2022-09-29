package com.pk.commonserver.util;

public enum MqTopic {

    ORDER("order-topic"),
    PRODUCT("product-topic"),
    USER("user-topic"),
    ;

    private final String str;

    MqTopic(String str) {
        this.str = str;
    }


}
