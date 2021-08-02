package org.alkemy.controllers;

import org.alkemy.domain.Usuario;
import org.alkemy.service.UsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristian
 */
@RestController
@RequestMapping(path = "/auth")
public class LoginController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    
    @PostMapping("/register")
    public Usuario registro(@RequestBody Usuario usuario){ 
        return usuarioService.registrar(usuario);
    }

    
    private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60000000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
    
 
    
  
   @PostMapping("/login")
    public Usuario login(@RequestParam("username") String username,@RequestParam("password") String password){
          
        
        Usuario usuario = usuarioService.findByUsername(username);
      
            
            if(usuario != null && passwordEncoder.matches(password, usuario.getPassword())){
                       String token = getJWTToken(password);
                       usuario.setUsername(username);
                       usuario.setPassword(token);
            }
     
          
        return usuario;
       
    }    
   
}  
    
    
    

