package tamal.lcms_spring_boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Court {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long acCourtId;

    @Column
    private String acCourtType;
    @Column
    private String acCourtCity;
    private String acCourtName;
    private String acCourtNo;
    private String acTribunalName;
    private String acChiefJustice;
    private String acChiefJusticeId;
    private String acPublicProsecutor;
    private String acPublicProsecutorId;
    private String acEmail;
    private String acCourtPhone;
    private String acUserName;
    private String acPassword;
    private String acConfirmPassword;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
