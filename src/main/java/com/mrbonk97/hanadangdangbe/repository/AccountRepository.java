package com.mrbonk97.hanadangdangbe.repository;

import com.mrbonk97.hanadangdangbe.model.Account;
import com.mrbonk97.hanadangdangbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUser(User user);
}
