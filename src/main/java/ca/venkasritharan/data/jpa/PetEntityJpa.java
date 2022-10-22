package ca.venkasritharan.data.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "pet")
public class PetEntityJpa {

    @Id
    @Column(name = "petID")
    private Integer id;

    @Column(name = "userName", unique = true, nullable = false)
    private String userName = "";

    @Column(name = "password", nullable = false)
    private String password = "";

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name= "PetRoles", joinColumns = {@JoinColumn(name = "petID", referencedColumnName = "petID")},
    inverseJoinColumns = {@JoinColumn(name = "roleID", referencedColumnName = "roleId")})
    private List<RoleEntityJpa> roles;

}
