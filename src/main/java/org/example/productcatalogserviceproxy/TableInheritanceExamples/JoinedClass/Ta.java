package org.example.productcatalogserviceproxy.TableInheritanceExamples.JoinedClass;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="c_jc_ta")
@PrimaryKeyJoinColumn(name="user_id")
public class Ta extends User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long ta_id;
    private int ratings;
}
