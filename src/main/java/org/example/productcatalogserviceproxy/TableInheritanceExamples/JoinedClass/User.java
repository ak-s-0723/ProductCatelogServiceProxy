package org.example.productcatalogserviceproxy.TableInheritanceExamples.JoinedClass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name="c_jc_user")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String email;
}
