package ca.venkasritharan.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDataRepositoryJpa extends JpaRepository<PetEntityJpa, Integer> {

    PetEntityJpa findPetEntityJpaByUserName(String userName);


}
