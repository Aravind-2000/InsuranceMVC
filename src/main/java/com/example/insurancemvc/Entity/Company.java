package com.example.insurancemvc.Entity;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Getter
@Setter
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String companyId;

	private String companyName;

	private String companyCountry;

	private String companyLicenseNumber;

//	@JsonFormat(pattern = "MM-dd-yyyy")
	private String companyLicenseIssueDate;

	private String companyCurrency;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "companyCurrency", updatable = false, insertable = false)
//	private CurrencyCode currencyCode;

//	private String companyStatus;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int validFlag;

	@CreationTimestamp
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private LocalDateTime companyCreatedDate;

	@UpdateTimestamp
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private LocalDateTime companyModifiedDate;

}
