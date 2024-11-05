package com.erkosh.services;

import com.erkosh.auth.security.UserAuthDetails;
import com.erkosh.dto.UserAuthDTO;
import com.erkosh.entities.UserAuthEntity;
import com.erkosh.mappers.UserAuthMapper;
import com.erkosh.repositories.UserAuthRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserAuthService implements UserDetailsService {

    private final UserAuthRepository userAuthRepository;
    private final UserAuthMapper userAuthMapper;

    public UserAuthService(UserAuthRepository userAuthRepository, UserAuthMapper userAuthMapper) {
        this.userAuthRepository = userAuthRepository;
        this.userAuthMapper = userAuthMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAuthEntity> user = userAuthRepository.findByUsername(username);
        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new UserAuthDetails(user.get());
    }

    public List<UserAuthDTO> getAllUserAuth() {
        List<UserAuthEntity> users = userAuthRepository.findAll();
        return users.stream()
                .map(userAuthMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserAuthDTO getUserAuthById(long id) {
        UserAuthEntity user = userAuthRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User data not found"));
        return userAuthMapper.toDTO(user);
    }

    @Transactional
    public UserAuthDTO createUserAuth(UserAuthDTO userAuthDTO) {
        UserAuthEntity user = userAuthMapper.toEntity(userAuthDTO);
        UserAuthEntity createdUser = userAuthRepository.save(user);
        return userAuthMapper.toDTO(createdUser);
    }

    @Transactional
    public UserAuthDTO updateUserAuth(long id, UserAuthDTO userAuthDTO) {
        UserAuthEntity user = userAuthRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User data not found"));
        user.setUsername(userAuthDTO.getUsername());
        user.setPassword(userAuthDTO.getPassword());
        return userAuthMapper.toDTO(userAuthRepository.save(user));
    }

    @Transactional
    public void deleteUserAuth(long id) {
        userAuthRepository.deleteById(id);
    }
}
