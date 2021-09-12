package com.tik.mysystem.system.repository;


import com.tik.mysystem.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author shuang.kou
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

    @Query(value = "select * from USER_JWT  where username= :username and password=:password", nativeQuery = true)
    Optional<User> findUserByNameAndPwd(@Param("username") String username, @Param("password") String password);
}
