package example.jpa.customer.main;

import example.jpa.entity.Customer;
import example.jpa.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class UpdateCustomer {

	public UpdateCustomer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(
				EntityManagerFactory emf = JpaUtils.getEntityManagerFactory();
				EntityManager em = emf.createEntityManager();
			){
			Class<Customer> entityClassType = Customer.class;
			Customer foundCustomer = em.find(entityClassType,6l);
			
			if (foundCustomer!=null) {
				EntityTransaction tx = em.getTransaction();
				tx.begin();
				foundCustomer.setName("Viraj Sarjerao Kiledar");
//				foundCustomer.setContact("1234567890");
//				
				tx.commit();
				System.out.println("Record updated");
			}
			else {
				System.out.println("Customer with given id does not exists");
			}
		}
		catch(Exception e ) {
			e.printStackTrace();
		}


	}

}
