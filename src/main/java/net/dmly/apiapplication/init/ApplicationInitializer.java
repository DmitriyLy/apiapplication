package net.dmly.apiapplication.init;

import lombok.RequiredArgsConstructor;
import net.dmly.apiapplication.model.Role;
import net.dmly.apiapplication.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationInitializer implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.findByName("ROLE_USER") == null) {
            Role roleUser = new Role(1L, "123", "ROLE_USER");
            roleRepository.save(roleUser);
        }

        if (roleRepository.findByName("USER_ADMIN") == null) {
            Role roleAdmin = new Role(2L, "456", "ROLE_ADMIN");
            roleRepository.save(roleAdmin);
        }
    }
}
