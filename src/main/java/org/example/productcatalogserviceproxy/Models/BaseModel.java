package org.example.productcatalogserviceproxy.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class BaseModel {
    private UUID id; /*  A class that represents an immutable universally unique identifier (UUID). A UUID represents a 128-bit value. */
    private Date createdAt;
    private Date lastUpdatedAt;
    private Status status;
}
