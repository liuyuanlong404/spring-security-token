package org.lakers.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

/**
 * Created on 2022/11/3 13:21
 *
 * @author lakers
 */
public class JWTUtils {

    private static final String SECRET_KEY = "lakers123456";

    private static final String ISSUER = "LAKERS";

    public static String createToken(Integer userId) {
        return JWT.create().withJWTId(userId.toString())
                .withIssuer(ISSUER)
                .withIssuedAt(new Date())
                //todo 设置过期时间为1个月，由于jwt无法修改过期时间，所以做权限过期验证根据redis的来实现
                .withExpiresAt(getNextMonth())
                .withClaim("userId", userId)
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    public static DecodedJWT verifyJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(ISSUER)
                .build();
        return verifier.verify(token);
    }

    public static void main(String[] args) {
        String token = createToken(111);
        Integer userId = verifyJWT(token).getClaim("userId").asInt();
        System.out.println(token);
        System.out.println(userId);
    }
    public static Date getNextMonth(){
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.MONTH, 1);
        return instance.getTime();
    }
}
