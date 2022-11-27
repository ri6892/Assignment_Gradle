package com.accolite.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Book {
    @Id
    @GeneratedValue
    String book_id;
    String book_name;
    double book_cost;
    String book_author;
    String book_category;
    String book_review;
    int book_inventory;
    int book_likes;

    public int getBook_likes() {
        return book_likes;
    }

    public void setBook_likes(int book_likes) {
        this.book_likes = book_likes;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public double getBook_cost() {
        return book_cost;
    }

    public void setBook_cost(double book_cost) {
        this.book_cost = book_cost;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_category() {
        return book_category;
    }

    public void setBook_category(String book_category) {
        this.book_category = book_category;
    }

    public String getBook_review() {
        return book_review;
    }

    public void setBook_review(String book_review) {
        this.book_review = book_review;
    }

    public int getBook_inventory() {
        return book_inventory;
    }

    public void setBook_inventory(int book_inventory) {
        this.book_inventory = book_inventory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", book_cost=" + book_cost +
                ", book_author='" + book_author + '\'' +
                ", book_category='" + book_category + '\'' +
                ", book_review='" + book_review + '\'' +
                ", book_inventory=" + book_inventory +
                '}';
    }
}
