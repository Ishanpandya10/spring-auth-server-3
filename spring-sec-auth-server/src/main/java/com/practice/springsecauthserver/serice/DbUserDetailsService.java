package com.practice.springsecauthserver.serice;

import com.practice.springsecauthserver.model.Users;
import com.practice.springsecauthserver.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DbUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUserName(username).orElseThrow();
        DbUserDetails dbUserDetails = new DbUserDetails(users);
        return dbUserDetails;
    }
}
