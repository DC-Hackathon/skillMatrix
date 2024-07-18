package com.bravuthon.skillmatrix.entity.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@EnableJpaAuditing
@ToString
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by")
    private String createdBy;

}
