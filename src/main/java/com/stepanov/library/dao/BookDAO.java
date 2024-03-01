package com.stepanov.library.dao;

import com.stepanov.library.models.Book;
import com.stepanov.library.models.Person;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDAO {
    public Object index() {
    }

    public Object show(int id) {
    }

    public Optional<Person> getBookOwner(int id) {
    }

    public void save(Book book) {
    }

    public void update(int id, Book book) {
    }

    public void delete(int id) {
    }

    public void release(int id) {
    }

    public void assign(int id, Person selectedPerson) {
    }
}
