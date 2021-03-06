package com.rizki.mufrizal.belajar.oauth2.mvc.repository;

import com.rizki.mufrizal.belajar.oauth2.mvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by rizki on 03/02/15.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select u from User u left join fetch u.userRoles pd where u.username = :username")
    public User getUserByUsername(@Param("username") String username);
}
