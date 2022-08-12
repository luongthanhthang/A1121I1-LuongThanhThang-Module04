package com.codegym.repository.security;

import com.codegym.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    @Query("select accountRole.role.roleName from AccountRole accountRole where accountRole.account.username = :username")
    List<String> findAllRoleByUser(String username);
}
