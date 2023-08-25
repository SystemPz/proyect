package mx.code.develop.sisab.log;

import mx.code.develop.sisab.dto.CitizenDetailData;
import org.apache.log4j.Logger;

public class CitizenLogger {
    public static void newCitizen(Logger log, String message, CitizenDetailData citizen) {
        StringBuilder error = new StringBuilder();
        error.append("Method: ").append("newCitizen");
        error.append(". Error: ").append(message);
        error.append(". CitizenDetailData: ").append(citizen);
        log.error(error);
    }

    public static void getCitizenAll(Logger log, String message, Integer citizenId) {
        StringBuilder error = new StringBuilder();
        error.append("Method: ").append("getCitizenAll");
        error.append(". Error: ").append(message);
        error.append(". CitizenId: ").append(citizenId);
        log.error(error);
    }


    public static void deleteCitizen(Logger log, String message, Integer citizenId) {
        StringBuilder error = new StringBuilder();
        error.append("Method: ").append("deleteCitizen");
        error.append(". Error: ").append(message);
        error.append(". CitizenId: ").append(citizenId);
        log.error(error);
    }
}
