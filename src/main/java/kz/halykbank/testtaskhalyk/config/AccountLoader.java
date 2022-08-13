package kz.halykbank.testtaskhalyk.config;

import kz.halykbank.testtaskhalyk.entities.Account;
import kz.halykbank.testtaskhalyk.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountLoader implements CommandLineRunner {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Account account = new Account();
        account.username = "user";
        account.password = passwordEncoder.encode("password");
        account.role = "ROLE_ADMIN";

        accountRepository.save(account);
    }
}
