package com.kiari.jobmanagement.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Entity(name = "Companies")
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank(message = "Name can not be empty or blank")
    private String name;
    @Email(message = "Invalid email provided")
    private String email;
    private String phone;
    private String website;
    private String description;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public CompanyEntity() {
    }
}
