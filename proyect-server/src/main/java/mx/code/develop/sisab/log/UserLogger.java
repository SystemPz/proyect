package mx.code.develop.sisab.log;

import mx.code.develop.sisab.shared.UserSession;
import org.apache.log4j.Logger;

public class UserLogger {

    public static void adminSearch(Logger log, String message, UserSession userSession, Integer adminType) {
        StringBuilder error = new StringBuilder();
        error.append("Method: ").append("adminSearch");
        error.append(". Error: ").append(message);
        error.append(". User: ").append(userSession == null ? "null" : userSession.getUsername());
        error.append(". AdminType: ").append(adminType);
        log.error(error);
    }
}
