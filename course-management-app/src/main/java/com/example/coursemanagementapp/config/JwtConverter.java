package com.example.coursemanagementapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class JwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    private String resourceId;


    public JwtConverter(@Value("${keycloak.resource}") String resourceId) {
        this.resourceId = resourceId;

    }

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> authorities = Stream.concat(
                        Stream.concat(extractRealmRoles(jwt).stream(), extractResourceRoles(jwt).stream())
                        , jwtGrantedAuthoritiesConverter.convert(jwt).stream())
                .collect(Collectors.toSet());
        log.info("Extracted Authorities: {}", authorities);
        log.info("JWT Claims: {}", jwt.getClaims());
        return new JwtAuthenticationToken(jwt, authorities);
    }


    private Collection<? extends GrantedAuthority> extractResourceRoles(Jwt jwt) {
        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess == null) {
            return Set.of();
        }
        return resourceAccess.values().stream()
                .filter(Map.class::isInstance)
                .map(Map.class::cast)
                .map(resource -> (Collection<String>) resource.get("roles"))
                .filter(roles -> roles != null)
                .flatMap(Collection::stream)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    private Collection<? extends GrantedAuthority> extractRealmRoles(Jwt jwt) {
        Map<String, Object> realmAccess = jwt.getClaim("realm_access");
        if (realmAccess == null) {
            return Set.of();
        }
        return ((Collection<String>) realmAccess.get("roles")).stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }
}