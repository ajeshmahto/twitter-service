package com.intuit.twitter.twitterservice.repository;

import com.intuit.twitter.twitterservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ajesh on 9/17/17.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
