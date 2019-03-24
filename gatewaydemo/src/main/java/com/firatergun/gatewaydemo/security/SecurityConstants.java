package com.firatergun.gatewaydemo.security;

public class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 600000L; // 10min
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api/v3/merchant/users/sign-up";
    public static final String LOGIN_URL = "/api/v3/merchant/users/login";
}
