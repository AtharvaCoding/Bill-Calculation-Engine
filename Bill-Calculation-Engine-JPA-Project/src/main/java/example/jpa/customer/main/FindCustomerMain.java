package example.jpa.customer.main;

import example.jpa.entity.Customer;
import example.jpa.utils.JpaUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class FindCustomerMain {

	public FindCustomerMain() {
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
//			em.find(entityClassType,101);
			System.out.println(foundCustomer);
			System.out.println(foundCustomer.toString());
		}
		catch(Exception e ) {
			e.printStackTrace();
		}

	}

}
