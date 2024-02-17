package org.example.productcatalogserviceproxy.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name="c_tpc_instructor")
public class Instructor extends User {
    private String company;
}
