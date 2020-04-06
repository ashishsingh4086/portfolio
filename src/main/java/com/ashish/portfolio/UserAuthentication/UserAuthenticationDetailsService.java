package com.ashish.portfolio.UserAuthentication;

import com.ashish.portfolio.UserAuthentication.model.UserAuthentication;
import com.ashish.portfolio.UserAuthentication.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthenticationDetailsService implements UserDetailsService {
  private UserAuthenticationRepository userAuthenticationRepository;

  @Autowired
  public UserAuthenticationDetailsService(
      UserAuthenticationRepository userAuthenticationRepository) {
    this.userAuthenticationRepository = userAuthenticationRepository;
  }

  public UserAuthenticationDetailsService() {}

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    Optional<UserAuthentication> userAuthentication =
        userAuthenticationRepository.findByUsername(userName);

    userAuthentication.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
    return userAuthentication.map(UserAuthenticationDetails::new).get();
  }
}
