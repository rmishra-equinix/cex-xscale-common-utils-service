package com.rmishra.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "projects")
public class ProjectEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3386014171135314717L;
    @Id
    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "project_type")
    private String projectType;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "metro", length = 20)
    private String metro;

    @Column(name = "ibx", length = 20)
    private String ibx;

    @Column(name = "updated_datetime")
    private ZonedDateTime updatedDateTime;
}