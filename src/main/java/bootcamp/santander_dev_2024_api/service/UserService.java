package bootcamp.santander_dev_2024_api.service;

import bootcamp.santander_dev_2024_api.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
