package com.rizki.mufrizal.belajar.oauth2.mvc.repository;

import com.rizki.mufrizal.belajar.oauth2.mvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rizki on 03/02/15.
 */

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
