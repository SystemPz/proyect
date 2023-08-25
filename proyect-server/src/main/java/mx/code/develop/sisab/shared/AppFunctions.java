package mx.code.develop.sisab.shared;

import org.apache.commons.lang3.StringUtils;

public class AppFunctions {
    public static String fullName(String name, String firstLastName, String secondLastName) {
        return String.format("%s %s%s", name, firstLastName, StringUtils.isBlank(secondLastName) ? "" : " " + secondLastName);
    }
    public static boolean positiveInteger(Integer number) {
        return number != null && number > 0;
    }
}
