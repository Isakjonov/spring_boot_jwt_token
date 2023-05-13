package com.example.spring_boot_jwt_token.entitys.template;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbsEntity {

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Timestamp updatedAt;

    @CreatedBy
    @Column(name = "created_by_id")
    private UUID createdBy;

    @LastModifiedBy
    @Column(name = "updated_by_id")
    private UUID updatedBy;


}
