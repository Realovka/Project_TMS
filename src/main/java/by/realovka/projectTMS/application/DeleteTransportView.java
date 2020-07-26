package by.realovka.projectTMS.application;

import by.realovka.projectTMS.dao.DBConnectionDao;
import by.realovka.projectTMS.util.InPut;

import java.util.List;
import java.util.Scanner;

public class DeleteTransportView {
    private static boolean viewOFTransportDelete=true;
    private static String viewOfTransport;

    public static String deleteViewOfTransport(){
        List<String> viewOfTransports= DBConnectionDao.getViewOfTransport();
        while (viewOFTransportDelete) {
            System.out.println("Выберите из списка транспорт, который хотите удалить");
            Scanner scanner = new Scanner(System.in);
            viewOfTransport = scanner.nextLine();
            viewOFTransportDelete= InPut.getViewOfTransport(viewOfTransports, viewOfTransport);
        }
        viewOFTransportDelete=true;
        return viewOfTransport;
    }
}
