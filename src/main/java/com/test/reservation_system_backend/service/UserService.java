package com.test.reservation_system_backend.service;

import com.test.reservation_system_backend.entity.User;
import com.test.reservation_system_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Registra un nuevo usuario después de codificar su contraseña.
     *
     * @param user El usuario a registrar.
     * @return El usuario registrado.
     */
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param username El nombre de usuario a buscar.
     * @return Una instancia de Optional con el usuario si se encuentra.
     */
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }

    /**
     * Verifica si las credenciales proporcionadas son correctas.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña proporcionada.
     * @return true si las credenciales son válidas, de lo contrario false.
     */
    public boolean authenticateUser(String username, String password) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
