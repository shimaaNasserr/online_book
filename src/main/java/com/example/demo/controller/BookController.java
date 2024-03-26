package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
private final BookService bookService;

@GetMapping
public ResponseEntity<List<Book>> getAllBooks(){
    return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
}
//@GetMapping("/{bookIds}")
//public ResponseEntity<List<Book>> getAllBooksByIds(@PathVariable List<Integer> bookIds){
//    return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooksByIds(bookIds));
//}
@GetMapping("/{id}")
public ResponseEntity<Book> getBookById(@PathVariable Integer id){
    return ResponseEntity.ok(bookService.getBookById(id));
}

@PostMapping
public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto) {
  return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookDto));
}
@PutMapping("/{id}")
public ResponseEntity<Book> replaceBook(@PathVariable Integer id, @RequestBody BookDto bookDto) {
    return ResponseEntity.ok(bookService.replaceBook(id, bookDto));
}
@PatchMapping("/{id}")
public ResponseEntity<Book> updateBook(@PathVariable Integer id, @RequestBody BookDto bookDto) {
    return ResponseEntity.ok(bookService.updateBook(id, bookDto));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
     bookService.deleteBookById(id);
   return  ResponseEntity.ok().build();
}
}
