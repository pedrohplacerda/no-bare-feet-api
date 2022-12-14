package com.nobarefeet.controllers;

import com.nobarefeet.entities.Response;
import com.nobarefeet.models.UsuarioModel;
import com.nobarefeet.repositories.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
@AllArgsConstructor
public class LoginController {

    public static final String URL_ISSUER = "https://no-bare-feet-api-1670964769587.azurewebsites.net";
    private final SecretKey CHAVE = Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6".getBytes(StandardCharsets.UTF_8));
    private final UsuarioRepository repository;

    @PostMapping(value = "/login")
    public Response post(@RequestBody UsuarioModel usuarioModel) {
        UsuarioModel usuario = repository.findAllByNome(usuarioModel.getNome());
        try {
            if (repository.existsByNomeAndSenha(usuarioModel.getNome(), usuarioModel.getSenha())) {
                String jwtToken = Jwts.builder()
                        .setSubject(usuarioModel.getNome())
                        .setIssuer(URL_ISSUER)
                        .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L).atOffset(ZoneOffset.UTC).toInstant()))
                        .signWith(CHAVE)
                        .compact();

                return new Response(HttpStatus.OK, jwtToken, usuarioModel.getNome(), usuario.getId());
            } else {
                return new Response(HttpStatus.UNAUTHORIZED, "Usuário e/ou senha inválidos.", usuario.getNome(), usuario.getId());
            }
        } catch (Exception e) {
            return new Response(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), usuarioModel.getNome(), usuario.getId());
        }

    }

}
