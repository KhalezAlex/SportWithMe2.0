package com.klozevitz.sportwithme2_0.services.securityService;

public interface SecurityService {
    String findLoggedUserName();
    boolean login(String username, String password);
}
