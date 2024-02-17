package org.example.productcatalogserviceproxy.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="c_msc_mentor")
public class Mentor extends User {
    private int numOfHours;
}
