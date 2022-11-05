package org.lakers.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created on 2022/11/3 13:40
 *
 * @author lakers
 */
public class WebUtils {

    public static void renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(string);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
