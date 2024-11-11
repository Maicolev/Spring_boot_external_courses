package service;

import dao.UserDao;
import domain.Rol;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        ArrayList<GrantedAuthority> role = new ArrayList<GrantedAuthority>();

        for (Rol rol : user.getRols()){
            role.add(new SimpleGrantedAuthority(rol.getRolName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), role);
    }
}
