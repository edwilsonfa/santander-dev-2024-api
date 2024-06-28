package bootcamp.santander_dev_2024_api.service.impl;

import bootcamp.santander_dev_2024_api.model.User;
import bootcamp.santander_dev_2024_api.repository.UserRepository;
import bootcamp.santander_dev_2024_api.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists.");
        }
        return this.userRepository.save(userToCreate);
    }
}
