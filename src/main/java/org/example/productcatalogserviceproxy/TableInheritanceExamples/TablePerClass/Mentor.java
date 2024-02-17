package org.example.productcatalogserviceproxy.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="c_tpc_mentor")
public class Mentor extends User {
    private int numOfHours;
}
