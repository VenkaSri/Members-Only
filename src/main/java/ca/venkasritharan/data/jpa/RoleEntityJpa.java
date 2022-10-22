package ca.venkasritharan.data.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class RoleEntityJpa {

    @Column(name = "roleID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roleName", unique = true, nullable = false)
    private String roleName;

    @ManyToMany(mappedBy = "roles")
    private List<PetEntityJpa> petEntitypetEntity;
}
