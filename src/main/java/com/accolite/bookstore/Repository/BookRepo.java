package com.accolite.bookstore.Repository;

import com.accolite.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
