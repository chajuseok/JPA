package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // JPA가 매핑할 클래스
//@Table(name = "USER") 데이터베이스 USER table에 매핑
public class Member extends BaseEntity {

    @Id // pk 매핑
    @GeneratedValue // 자동 값 할당
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") //DB 컬럼에 맞게 설정
    private String username;

//    @Column(name= "TEAM_ID")
//    private Long teamID;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;



//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

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

    public Team getTeam() {
        return team;
    }

//    public Locker getLocker() {
//        return locker;
//    }
//
//    public void setLocker(Locker locker) {
//        this.locker = locker;
//    }

    public void setTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
//    public Long getTeamID() {
//        return teamID;
//    }
//
//    public void setTeamID(Long teamID) {
//        this.teamID = teamID;
//    }
}
