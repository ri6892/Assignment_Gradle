package com.accolite.bookstore.Controller;

import com.accolite.bookstore.Service.BookService;
import com.accolite.bookstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bs;
//usecase1
    @GetMapping("/User")
    private ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok().body(this.bs.getUser());
    }

    @PostMapping("/User")
    private ResponseEntity<User> saveUser(@RequestBody User u){
        return ResponseEntity.ok().body(this.bs.createUser(u));
    }

    @PutMapping("/User/{user_id}")
    private ResponseEntity<User> updateUser(@RequestBody User u){
        return ResponseEntity.ok().body(this.bs.updateUser(u));
    }
    @DeleteMapping("User/{user_id}")
    private HttpStatus suspendUser(@PathVariable String user_id,@RequestBody User u){
        u.setSuspended(true);
        this.bs.deleteUser(user_id);
        return HttpStatus.OK;
    }

    //usecase2
    @GetMapping("/Wallet/{user_id}")
    private ResponseEntity<Double> getamount(@RequestBody User u){
        return ResponseEntity.ok().body(this.bs.getwallet(u));
    }
    @PostMapping("/Wallet/{user_id}")
    private ResponseEntity<User> addwalletamount(@RequestBody User u){
        return ResponseEntity.ok().body(this.bs.updateWallet(u));
    }
    //usecase3

}
