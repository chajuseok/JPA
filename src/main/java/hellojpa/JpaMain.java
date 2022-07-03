package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); //persistence의 persistence-unit name을 설정 정보 hello

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("AA");
            member.setAddress(new Address("dd","DD","CC"));
            member.setWorkPeriod(new Period());
            em.persist(member);
//
//            Parent parent = new Parent();
//            Child child1 = new Child();
//            Child child2 = new Child();
//
////            parent.addChild(child1);
////            parent.addChild(child2);
//            em.persist(child1);
//            em.persist(child2);
//            em.persist(parent);



            tx.commit(); // insert 쿼리를 transaction commit 순간 발생
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
