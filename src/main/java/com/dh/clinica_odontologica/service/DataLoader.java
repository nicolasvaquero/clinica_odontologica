package com.dh.clinica_odontologica.service;


import com.dh.clinica_odontologica.entity.AppUser;
import com.dh.clinica_odontologica.entity.AppUserRole;
import com.dh.clinica_odontologica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password");
        userRepository.save(new AppUser("Diego", "diego", "nico@dh.com", hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Paula", "paula", "nico2@dh.com", hashedPassword2, AppUserRole.USER));
    }
}
