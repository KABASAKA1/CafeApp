package com.sunrise.monetcafeapplicationapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_time" , updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(name = "last_modified_time")
    @LastModifiedDate
    private Date updatedAt;
}
