package br.com.springback.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
	 
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        Optional<String> userName = Optional.of(((User) authentication.getPrincipal()).getUsername());
        return userName ;
    } 
}