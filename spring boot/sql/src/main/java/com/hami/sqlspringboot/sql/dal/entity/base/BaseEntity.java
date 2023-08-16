package com.hami.sqlspringboot.sql.dal.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<ID> {

    @Version
    @Column(name = "version")
    protected Long version;
    @Column(name = "deleted")
    protected Boolean deleted = Boolean.FALSE;
    @CreationTimestamp
    @Column(name = "created_date", columnDefinition = "TIMESTAMP")
    protected LocalDateTime createdDate;

    public abstract ID getId();
    public abstract void setId(ID id);













}
