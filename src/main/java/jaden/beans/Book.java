/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 30, 2023
 */
package jaden.beans;
import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;
    private int quantity;
    
    public Book() {
    	super();
    }
    
    public Book(Long id, String title, String author, double price, String isbn, int quantity) {
    	this.id = id;
    	this.title = title;
    	this.author = author;
    	this.price = price;
    	this.quantity = quantity;
    }

}