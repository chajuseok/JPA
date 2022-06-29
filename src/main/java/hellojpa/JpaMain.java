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

            Team team = new Team();
            team.setName("TeamA");

            //멤버 관리
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            Member member1 = new Member();
            member1.setUsername("member2");
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();
            System.out.println("#####");
            Member findMember = em.find(Member.class, member.getId());

            List<Member> members = findMember.getTeam().getMembers();

            for(Member m : members){
                System.out.println("m = " + m.getUsername());
            }
            tx.commit(); // insert 쿼리를 transaction commit 순간 발생
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
