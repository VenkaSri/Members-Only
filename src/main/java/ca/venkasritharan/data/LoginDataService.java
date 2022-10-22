package ca.venkasritharan.data;

import java.util.List;

public interface LoginDataService {

    String getPassword(String userName);
    boolean userExists(String userName);
    List<String> getAllRoleNames(String userName);
}
