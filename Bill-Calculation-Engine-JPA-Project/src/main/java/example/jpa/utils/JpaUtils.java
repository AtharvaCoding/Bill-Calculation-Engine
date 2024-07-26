package example.jpa.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtils {

	public static EntityManagerFactory getEntityManagerFactory() {
		EntityManagerFactory emfRef = Persistence.createEntityManagerFactory("my-bill-calculation-unit");
		return emfRef;
	}

}
