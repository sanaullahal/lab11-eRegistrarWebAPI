package edu.miu.cs.cs425.eregistrar.Service;


import edu.miu.cs.cs425.eregistrar.Repository.UserRepository;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EregistrarUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public EregistrarUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return user;
    }

}

