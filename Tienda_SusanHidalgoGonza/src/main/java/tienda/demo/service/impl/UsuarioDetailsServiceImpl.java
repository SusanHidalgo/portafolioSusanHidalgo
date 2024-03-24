
package tienda.demo.service.impl;

import tienda.demo.service.UsuarioDetailsService;
import tienda.demo.dao.UsuarioDao;
import tienda.demo.domain.Usuario;
import tienda.demo.domain.Rol;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService{
    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        //Buscar el usuario por el username en la tabla
        Usuario usuario = usuarioDao.findByUsername(username);
        //Si no existe el usuaio lanza una excepcion
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
    }
    session.removeAttribute("usuarioImagen");
    session.setAttribute("usuarioImagen", usuario.getRutaImagen());
    //si esta aca es porque existe el usuario... sacamos los roles que tiene
    var roles = new ArrayList<GrantedAuthority>();
    for (Rol rol : usuario.getRoles()){  //Se sacan los roles
        roles.add(new SimpleGrantedAuthority(rol.getNombre()));
    }
    //Se devuelve User (clase de userDetails
    return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
 
}
