package com.xuan.erp.jwt;

import java.io.Serializable;
import java.util.Set;

public class JwtAuthenticationResponse  implements Serializable {
	
    private static final long serialVersionUID = 1250166508152483573L;
    
    private String token;
    
    private Set<String> authorities;

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
        this.authorities = null;
    }
    
    public JwtAuthenticationResponse(String token, Set<String> authorities) {
        this.token = token;
        this.authorities = authorities;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
