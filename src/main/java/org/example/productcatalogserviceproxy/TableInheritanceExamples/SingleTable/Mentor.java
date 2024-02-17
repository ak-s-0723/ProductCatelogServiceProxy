package org.example.productcatalogserviceproxy.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="c_st_mentor")
@DiscriminatorValue(value="2")
public class Mentor extends User {
    private int numOfHours;
}
