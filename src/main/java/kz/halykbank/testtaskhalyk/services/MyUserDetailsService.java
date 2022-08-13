package kz.halykbank.testtaskhalyk.services;

import kz.halykbank.testtaskhalyk.entities.Account;
import kz.halykbank.testtaskhalyk.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Autowired
    public MyUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String enteredUsername) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(enteredUsername);

        if (account == null) {
            throw new UsernameNotFoundException(enteredUsername);
        }

        String storedPassword = account.password;

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.role));

        UserDetails userDetails = new User(enteredUsername, storedPassword, authorities);

        return userDetails;

    }
}
