/**
 * @author jeade - jeaden
 * CIS175 - Fall 2023
 *Oct 30, 2023
 */
package jaden.beans;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne	
	private Book book;
	
	private int quantity;
	
	public CartItem() {
		
	}
	
	public CartItem(Book book, int quantity) {
		this.book = book;
		this.quantity = quantity;
	}

}
