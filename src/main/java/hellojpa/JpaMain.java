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

//            Movie movie = new Movie();
//            movie.setDirector("BBB");
//            movie.setActor("AAAAA");
//            movie.setName("ddd");
//            movie.setPrice(100);
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//            Movie find = em.find(Movie.class, movie.getId());
//            System.out.println("find : "  + find);


            tx.commit(); // insert 쿼리를 transaction commit 순간 발생
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
