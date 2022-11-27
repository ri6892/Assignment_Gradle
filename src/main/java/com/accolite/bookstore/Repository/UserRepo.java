package com.accolite.bookstore.Repository;

import com.accolite.bookstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
