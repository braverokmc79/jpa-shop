package jpashop.home;

import java.lang.reflect.Member;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hello");
		
		EntityManager em=emf.createEntityManager();
		
		//JPA 의 모든 데이터 변경은  트랜잭션 안에서 실행 되어야 한다.
		EntityTransaction tx=em.getTransaction();
		tx.begin();
			
		try {
			
			/*수정 */
			Member findMember  =em.find(Member.class, 1L);
			//findMember.("JH");
		
			List<Member> reuslt=em.createQuery("select m from Member as m " , Member.class)
					.setFirstResult(5)
					.setMaxResults(8)
					.getResultList();
			
			for(Member member : reuslt) {
			
			}
			
			
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
	
		
		emf.close();	
	}
	
	
}
