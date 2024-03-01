package com.stepanov.library.dao;

import com.stepanov.library.models.Book;
import com.stepanov.library.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("select * from book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("select * from book where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream()
                .findAny()
                .orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("insert into book(title, author, year) values(?, ?, ?)", book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("update book set title=?, author=?, year=? where id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from book where id=?", id);
    }

    public Optional<Person> getBookOwner(int id) {
        return jdbcTemplate.query("select person.* from book join person on Book.person_id = Person.id " + "where book.id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream()
                .findAny();
    }

    public void release(int id) {
        jdbcTemplate.update("update book set person_id=null where id=?", id);
    }

    public void assign(int id, Person selectedPerson) {
        jdbcTemplate.update("update book set person_id=? where id=?", selectedPerson.getId(), id);
    }
}
