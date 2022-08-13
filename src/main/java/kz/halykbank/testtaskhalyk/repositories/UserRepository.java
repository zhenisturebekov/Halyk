package kz.halykbank.testtaskhalyk.repositories;

import kz.halykbank.testtaskhalyk.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByPersonnelNumber(int personnelNumber);
}
