package com.accolite.bookstore.Service;

import com.accolite.bookstore.model.*;

import java.util.List;

public interface BookService {
    // use case 1
    User createUser(User u);
    User updateUser(User u);
    List<User> getUser();
    void deleteUser(String user_id);
// usecase2
    double getwallet(User u);
    User updateWallet(User u);
//usecase 3
    Book createBook(Book b);
    Book getBookById(Book b);
   // Book getBookReviewById(Book b);
    List<Book> getBook();
    //Book postReviewById(Book b);
    //Book postLikeById(Book b);
    List<Book> sortByLike();

}
