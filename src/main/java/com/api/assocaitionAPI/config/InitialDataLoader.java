package com.api.assocaitionAPI.config;

import com.api.assocaitionAPI.model.account.user.Admin;
import com.api.assocaitionAPI.model.account.Role;
import com.api.assocaitionAPI.repo.AdminRepo;
import com.api.assocaitionAPI.repo.RoleRepo;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader {

    private final AdminRepo adminRepository;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public InitialDataLoader(AdminRepo adminRepository, RoleRepo roleRepo,
                             PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    public void loadData() {

        if (roleRepo.count() == 0) {
            loadRole();
        }


        if (adminRepository.count() == 0) {
            loadAdmin();
        }
    }

    private void loadRole() {
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepo.save(adminRole);

        Role writerRole = new Role();
        writerRole.setName("WRITER");
        roleRepo.save(writerRole);
    }

    private void loadAdmin() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("password"));

        Role admin_role = roleRepo.findByName("ADMIN");
        admin.getRoles().add(admin_role);
        adminRepository.save(admin);
    }
}
