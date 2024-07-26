package example.jpa.customer.main;

import example.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CreateCustomerMain {

	public CreateCustomerMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfRef = Persistence.createEntityManagerFactory("my-bill-calculation-unit");
		EntityManager emRef = emfRef.createEntityManager();
		
		Customer rst = new Customer(2L , "Viraj Killedar" , "123 Baner Rd, Pune, Maharashtra" , "7066025859");
		
		EntityTransaction etRef = emRef.getTransaction(); 
		etRef.begin();// transaction begins 
			emRef.persist(rst);
		etRef.commit();
		emRef.close();
		emfRef.close();
		System.out.println("record added...");

	}

}
