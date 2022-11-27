package com.accolite.bookstore.Service;

import com.accolite.bookstore.Exception.BookException;
import com.accolite.bookstore.Repository.*;
import  com.accolite.bookstore.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class BookServiceImple implements BookService{
    @Autowired
    private UserRepo ur;
    private BookRepo br;
//usecase1
    @Override
    public User createUser(User u) {
        String email=u.getEmail();
        double wallet_amount=u.getWallet_amount();
        if(isEmailValid(email) && wallet_amount%500==0){
            return ur.save(u);
        } else if (wallet_amount%500!=0) {
            throw new BookException("The amount should be in multiple of 500");
        } else{
            throw new BookException("please check the email");
        }
    }
    @Override
    public User updateUser(User u) {
        Optional<User> uobj=this.ur.findById(Long.valueOf(u.getUser_id()));

        if(uobj.isPresent() ) {
            User user_update = uobj.get();
            user_update.setUser_name(u.getUser_name());
            user_update.setUser_id(u.getUser_id());
            user_update.setEmail(u.getEmail());
            user_update.setSuspended(u.isSuspended());
            user_update.setPhone_no((int) u.getPhone_no());
            user_update.setWallet_amount(u.getWallet_amount());
            return this.ur.save(user_update);

        } else{
            throw new BookException("User with id " +u.getUser_id()+" is not present");
        }

    }

    @Override
    public List<User> getUser() {
        return this.ur.findAll();
    }

    @Override
    public void deleteUser(String user_id) {
     Optional<User> uobj=this.ur.findById(Long.valueOf(user_id));
if(uobj.isPresent()){
    this.ur.deleteById(Long.valueOf(user_id));
}
else{
    throw new BookException("User with id " + user_id+ " is not present");
}
    }
    public boolean isEmailValid(String email) {
        String exp="^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(exp,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            return true;
        }
        else return false;
    }

    //usecase 2
    @Override
    public double getwallet(User u) {
        Optional<User> uobj=this.ur.findById(Long.valueOf(u.getUser_id()));
        if(uobj.isPresent()){
            return uobj.get().getWallet_amount();
        }
        else{
            throw new BookException("User with id " +u.getUser_id()+" is not present");
        }
    }

    @Override
    public User updateWallet(User u) {
        Optional<User> uobj=this.ur.findById(Long.valueOf(u.getUser_id()));
        if(uobj.isPresent() && u.getWallet_amount()%500==0) {
            double current_wallet_value=uobj.get().getWallet_amount();
            User user_update = uobj.get();
            user_update.setWallet_amount(u.getWallet_amount()+current_wallet_value);
            return this.ur.save(user_update);

        }else if (u.getWallet_amount()%500!=0) {
            throw new BookException("The wallet value added should be multiple of 500");
        }
        else{
            throw new BookException("User with id " +u.getUser_id()+" is not present");
        }
    }
    // usecase 3

    @Override
    public Book createBook(Book b) {
        return br.save(b);
    }

    @Override
    public Book getBookById(Book b) {
        Optional<Book> bobj=this.br.findById(Long.valueOf(b.getBook_id()));
        if(bobj.isPresent()){
            return  bobj.get();
        }
        else{
            throw new BookException("no such book exist");
        }
    }
/*
    @Override
    public Book getBookReviewById(Book b) {
        Optional<Book> bobj=this.br.findById(Long.valueOf(b.getBook_id()));
        if(bobj.isPresent()){
            return  bobj.;
        }
        else{
            throw new BookException("no such book exist");
        }
    }*/

    @Override
    public List<Book> getBook() {
        return this.br.findAll();
    }

/*    @Override
    public Book postReviewById(Book b) {
        Optional<Book> bobj=this.br.findById(b.getBook_id());
        if(bobj.isPresent()){
            Book bupd=bobj.get();
            bupd.setBook_review(b.getBook_review());
            return this.br.save(bupd);
        }
        else {
            throw new BookException("No such OOK");
        }
    }*/
/*
    @Override
    public Book postLikeById(Book b) {
        return null;
    }*/

    @Override
    public List<Book> sortByLike() {
        return Collections.sort(br.getClass() ,br.getClass());
    }
        Collections.sort(Book, new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.ge.compareTo(u2.getCreatedOn());
        }
    });

}
