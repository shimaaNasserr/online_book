package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public List<Book> getAllBooksByIds(List<Integer> bookIds ){
        return bookRepository.findAllByIdIn(bookIds);
    }
    
    public Book getBookById(Integer id){
        return bookRepository.findById(id).orElse(null);
    }
    
    public Book addBook(BookDto bookDto) {
    	Book newbook = new Book();
    	newbook.setName(bookDto.getName());
    	newbook.setPrice(bookDto.getPrice());
    	newbook.setQuantity(bookDto.getQuantity());
    	return bookRepository.save(newbook);
    }
    public Book replaceBook(Integer id,BookDto bookDto) {
    	Book newbook = new Book();
    	newbook.setId(id);
    	newbook.setName(bookDto.getName());
    	newbook.setPrice(bookDto.getPrice());
    	newbook.setQuantity(bookDto.getQuantity());
    	return bookRepository.save(newbook);
    }
    public Book updateBook(Integer id,BookDto bookDto) {
    	Book oldbook = bookRepository.findById(id).orElse(null);
    	if(bookDto.getName()!=null) {
    		System.out.println("#### Here ####");
    		oldbook.setName(bookDto.getName());
    	}
    	if(bookDto.getPrice()!=null) {
    		oldbook.setPrice(bookDto.getPrice());
    	}
    	if(bookDto.getQuantity()!=null) {
    		oldbook.setQuantity(bookDto.getQuantity());
    	}
    	return bookRepository.save(oldbook);
    } 
    public void deleteBookById(Integer id) {
    	 bookRepository.deleteById(id);
    }
    
}