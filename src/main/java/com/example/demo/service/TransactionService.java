package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookCartDto;
import com.example.demo.dto.TransactionDto;
import com.example.demo.entity.Book;
import com.example.demo.entity.TransactionBook;
import com.example.demo.entity.TransactionHistory;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
	private final TransactionRepository transactionRepository;
	private final BookService bookService;
	private final UserService userService;

	public List<TransactionHistory> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public TransactionHistory getTransactionById(Integer id) {
		return transactionRepository.findById(id).orElse(null);
	}
	public List<TransactionHistory> getTransactionByUserId(Integer id) {
		return transactionRepository.findByUserId(id);
	}

	public void deleteTransactionById(Integer id) {
		transactionRepository.deleteById(id);
	}

	public TransactionHistory createTransaction(TransactionDto transactionDto) {
		UserEntity user = userService.getUserById(transactionDto.getUserId());
		List<TransactionBook> transactionBookList = new ArrayList<>();
		TransactionHistory transactionHistory = new TransactionHistory();
		List<BookCartDto> requiredBooks = transactionDto.getBooks(); // id,quantity
		List<Integer> booksIds = requiredBooks.stream().map(bookObj -> bookObj.getBookId()).toList();
		List<Book> books = bookService.getAllBooksByIds(booksIds);
		Double totalPrice = 0.0;
		for (Book book : books) {
			for (BookCartDto bookObj : requiredBooks) {
				if (book.getId() == bookObj.getBookId()) {
					book.setQuantity(book.getQuantity() - bookObj.getQuantity());
					totalPrice += book.getPrice() * bookObj.getQuantity();
					TransactionBook transactionBook = new TransactionBook();
					transactionBook.setBook(book);
					transactionBook.setQuantity(bookObj.getQuantity());
					transactionBook.setName(book.getName());
					transactionBook.setPrice(book.getPrice());
					transactionBook.setTransactionHistory(transactionHistory);
					transactionBookList.add(transactionBook);
					
				}

			}
		}
	
	
	
		transactionHistory.setUser(user);
		transactionHistory.setTransactionBook(transactionBookList);
		transactionHistory.setTotalprice(totalPrice);
		transactionHistory.setProccessDate(new Date());
		return transactionRepository.save(transactionHistory);
	}
}
