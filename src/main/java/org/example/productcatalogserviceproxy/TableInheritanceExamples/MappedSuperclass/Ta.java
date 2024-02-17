package org.example.productcatalogserviceproxy.TableInheritanceExamples.MappedSuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="c_msc_ta")
public class Ta extends User {
    private int ratings;
}
