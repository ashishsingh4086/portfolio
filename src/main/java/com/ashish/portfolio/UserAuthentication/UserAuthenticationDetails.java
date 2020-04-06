package com.ashish.portfolio.UserAuthentication;

import com.ashish.portfolio.UserAuthentication.model.UserAuthentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserAuthenticationDetails implements UserDetails {

  private String userName;
  private String password;
  private boolean isActive;
  private List<GrantedAuthority> authorities;

  public UserAuthenticationDetails(UserAuthentication userAuthentication) {
    this.userName = userAuthentication.getUsername();
    this.password = userAuthentication.getPassword();
    this.isActive = userAuthentication.isActive();
    this.authorities =
        Arrays.stream(userAuthentication.getUserROles().split(","))
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
  }

  public UserAuthenticationDetails() {}

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
