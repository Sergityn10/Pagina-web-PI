package es.unex.pi.resources;
import java.util.Date;
import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
public class jwtUtil {



    private static final String SECRET_KEY = "your_secret_key"; // Cambia esto por una clave secreta segura
    private static final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos

    public static String generateToken(String username) {
    	
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    
}
}
