package jpashop.home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpashop.home.domain.Book;
import jpashop.home.domain.Item;

public class JPQL타입표현과기타식 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		// JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행 되어야 한다.
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {


			Book book = new Book();
			book.setPrice(10000);
			book.setName("JPA");
			book.setIsbn("d33523");
			book.setAuthor("김영한2");
			book.setStockQuantity(10);

			em.persist(book);

			System.out.println("===============================");
			em.createQuery("select i from Item  i  where type(i) = Book ", Item.class).getResultList();
			System.out.println("===============================");

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
