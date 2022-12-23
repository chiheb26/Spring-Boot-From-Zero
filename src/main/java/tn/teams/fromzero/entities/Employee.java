package tn.teams.fromzero.entities;
import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "nom_prenom", nullable = false)
    private String fullName ;
    private Integer age ;

    @Column(unique = true)
    private String email ;
}
