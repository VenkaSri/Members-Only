package ca.venkasritharan.data.jpa;

import ca.venkasritharan.data.LoginDataService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LoginDataServiceJpaImpl implements LoginDataService {


    private final PetDataRepositoryJpa petDataRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginDataServiceJpaImpl(PetDataRepositoryJpa petDataRepositoryJpa, PasswordEncoder passwordEncoder) {
        this.petDataRepository = petDataRepositoryJpa;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean userExists(String userName) {
        return petDataRepository.findPetEntityJpaByUserName(userName) != null;
    }



    @Override
    public String getPassword(String userName) {
        PetEntityJpa petEntity = petDataRepository.findPetEntityJpaByUserName(userName);
        if (petEntity != null) {
            return petEntity.getPassword();
        } else {
            return null;
        }
        }

        @Override
        public List<String> getAllRoleNames(String userName) {
        List<String> roleNames = new ArrayList<>();
        PetEntityJpa petEntity = petDataRepository.findPetEntityJpaByUserName(userName);
        if(petEntity != null){
            List<RoleEntityJpa> roles = petEntity.getRoles();
            for(RoleEntityJpa roleEntity: roles){
                roleNames.add(roleEntity.getRoleName());
            }
        }
        return roleNames;
        }
}

