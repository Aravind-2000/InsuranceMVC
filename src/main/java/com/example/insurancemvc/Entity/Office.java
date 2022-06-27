package com.example.insurancemvc.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeId;

    private String officeName;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long companyId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "companyId",updatable = false,insertable = false)
    private Company company;


//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long officeLevelId;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "officeLevelId",updatable = false,insertable = false)
    private OfficeLevelParam officeLevelParam;

    private Long upLevelOfficeId;

    @OneToMany(mappedBy = "upLevelOfficeId",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Office> downLevelOffice;

    @OneToMany(mappedBy = "officeId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agent> agents;

    private int validFlag;

    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime modifiedDate;

}