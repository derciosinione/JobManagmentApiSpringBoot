package com.kiari.jobmanagement.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity(name = "Jobs")
@AllArgsConstructor
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private String benefits;
    @NotBlank(message = "This field is required, please provide the level")
    private String level;

    @Column(name = "company_id")
    private UUID companyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public JobEntity() {
    }
}
