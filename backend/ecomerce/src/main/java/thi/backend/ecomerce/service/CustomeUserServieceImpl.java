package thi.backend.ecomerce.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import thi.backend.ecomerce.model.User;
import thi.backend.ecomerce.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomeUserServieceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public CustomeUserServieceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found with email - " + username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassWord(), authorities);
    }
}
