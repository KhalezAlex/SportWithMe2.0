package com.swm.sportwithme.services.securityService;

public interface SecurityService {
    String findLoggedUserName();
    boolean login(String username, String password);
}
