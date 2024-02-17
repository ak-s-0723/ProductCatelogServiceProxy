package org.example.productcatalogserviceproxy.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="c_msc_instructor")
public class Instructor extends User {
    private String company;
}
