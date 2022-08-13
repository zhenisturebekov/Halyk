package kz.halykbank.testtaskhalyk.repositories;

import kz.halykbank.testtaskhalyk.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String Username);
}
