package it.prova.pokeronline.service.implementation;

import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utente user = utenteRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isAttivo(), true, true, !user.isDisabilitato(), getAuthorities(user));

    }

    //Il metodo è modificato, a differenza dello stream utilizzato nel progetto precedente
    // qui getRuolo restituisce un ruolo, non una lista su cui poter fare una stream !!!
    private static Collection<? extends GrantedAuthority> getAuthorities(Utente user) {
        return AuthorityUtils.createAuthorityList(user.getRuolo().getCodice());
    }


}
