package jpashop.home;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpashop.home.domain.Member;

public class JPQL기본함수 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		// JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행 되어야 한다.
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member1 =new Member();
			member1.setName("관리자1");
			em.persist(member1);

			Member member2 =new Member();
			member2.setName("관리자2");
			em.persist(member2);
			
			em.flush();
			em.clear();
			
			String query ="select function('group_concat', m.name ) FROM Member m";
			List<String> result =em.createQuery(query, String.class).getResultList();

			for(String s : result) {
				System.out.println("s = " + s);
			}
			
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}

}
