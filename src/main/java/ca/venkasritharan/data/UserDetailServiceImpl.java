package ca.venkasritharan.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

    private final LoginDataService loginDataService;

    public UserDetailServiceImpl(@Qualifier("loginDataServiceJpaImpl") LoginDataService loginDataService) {
        this.loginDataService = loginDataService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(loginDataService.userExists(username)) {
            log.trace("user " + username + " is found");
            String password = loginDataService.getPassword(username);
            return new User(username, password, getAuthorities(username));
        } else {
            throw new UsernameNotFoundException("Login " + username + " is not found");
        }
    }



    private List<GrantedAuthority> getAuthorities(String login) {
        log.trace("getAuthorities() is called");
        List<String> listOfRoles = loginDataService.getAllRoleNames(login);
        String[] arrayOfRoles = listOfRoles.toArray(new String[0]);
        log.trace("roles for login=" +
                login + ":[" + String.join(",", arrayOfRoles) + "]");
        return AuthorityUtils.createAuthorityList(arrayOfRoles);
    }
}
