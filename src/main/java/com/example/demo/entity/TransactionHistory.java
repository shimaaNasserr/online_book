package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class TransactionHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
//	@ManyToMany
//	private List<Book> books;
	
	@ManyToOne
	@JsonManagedReference
	private UserEntity user;
	  @OneToMany(mappedBy = "transactionHistory",  cascade = CascadeType.ALL)
	   @JsonManagedReference
	    private List<TransactionBook> transactionBook;
	  private Double totalprice;
	@Temporal(TemporalType.TIMESTAMP)
	private Date proccessDate;
	 
		
}
