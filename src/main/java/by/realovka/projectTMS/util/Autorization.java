package by.realovka.projectTMS.util;

public class Autorization {
    private static final String LOGINOFADMINISTRATOR="Adm";
    private static final String PASSWORDOFADMINISTRATOR="ADM";
    private static final String LOGINOFUSER="User";
    private static final String PASSWORDOFUSER="USER";

    public static String getLoginOfAdministrator() {
        return LOGINOFADMINISTRATOR;
    }

    public static String getPasswordOfAdministrator() {
        return PASSWORDOFADMINISTRATOR;
    }

    public static String getLoginOfUser() {
        return LOGINOFUSER;
    }

    public static String getPasswordOfUser() {
        return PASSWORDOFUSER;
    }
}
