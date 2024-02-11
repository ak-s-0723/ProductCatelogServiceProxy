package org.example.productcatalogserviceproxy.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; /*  A class that represents an immutable universally unique identifier (UUID). A UUID represents a 128-bit value. */
    private Date createdAt;
    private Date lastUpdatedAt;
    private Status status;
}
