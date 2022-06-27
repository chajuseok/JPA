package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // JPA가 매핑할 클래스
//@Table(name = "USER") 데이터베이스 USER table에 매핑
public class Member {

    @Id // pk 매핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 값 할당
    private Long id;

    @Column(name = "name", nullable = false) //DB 컬럼에 맞게 설정
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Member() {
    }
}
