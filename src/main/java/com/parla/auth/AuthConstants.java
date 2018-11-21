package com.parla.auth;

public interface AuthConstants {
    long ACCESS_TOKEN_VALIDITY_SECONDS = 5*60*60;
    String SIGNING_KEY = "devglan123r";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String AUTHORITIES_KEY = "scopes";
}
