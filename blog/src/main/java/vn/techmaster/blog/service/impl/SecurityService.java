package vn.techmaster.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.techmaster.blog.model.Role;
import vn.techmaster.blog.model.User;
import vn.techmaster.blog.repository.RoleRepository;
import vn.techmaster.blog.repository.UserRepository;
import vn.techmaster.blog.service.ISecurityService;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SecurityService implements ISecurityService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User createUser(String fullname, String email, String password, Role... roles){
        User user = new User(fullname,email, encoder.encode(password));
        for (Role role:roles
             ) {
            user.addRole(role);
        }
        return user;
    }

    @Override
    @Transactional
    public void generateUserRoles() {
        Role roleAdmin = new Role("ADMIN");
        Role roleAuthor = new Role("AUTHOR");
        Role roleEditor = new Role("EDITOR");

        roleRepository.save(roleAdmin);
        roleRepository.save(roleAuthor);
        roleRepository.save(roleEditor);
        roleRepository.flush();

        User admin = createUser("admin","admin@gmail.com", "123", roleAdmin);
        userRepository.save(admin);

        User bob =  createUser("bob","bob@gmail.com", "123", roleAuthor);
        userRepository.save(bob);

        User alice =  createUser("alice","alice@gmail.com", "123", roleEditor);
        userRepository.save(alice);

        User jane =  createUser("jane","jane@gmail.com", "123", roleAuthor);
        userRepository.save(jane);

        userRepository.flush();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("Could not find user");
        }
        return user.get();
    }
}
