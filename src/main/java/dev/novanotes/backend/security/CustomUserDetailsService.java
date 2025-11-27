package dev.novanotes.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.novanotes.backend.dao.UsersDao;
import dev.novanotes.backend.entity.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		Users user = usersDao.findByLoginId(loginId);
		if(user == null) throw new UsernameNotFoundException("User not found");
		return new CustomUserDetails(user);
	}

}
