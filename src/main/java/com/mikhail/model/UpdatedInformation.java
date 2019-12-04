package com.mikhail.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class UpdatedInformation {

    @LastModifiedDate
    @Column(name = "update_at")
    private Date updatedAt;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updatedBy;
}
