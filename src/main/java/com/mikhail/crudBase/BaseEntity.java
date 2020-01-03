package com.mikhail.crudBase;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @LastModifiedDate
    @Column(name = "update_at")
    private Instant updatedAt;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updatedBy;
}
