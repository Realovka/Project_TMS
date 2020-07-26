package by.realovka.projectTMS.controller;

import by.realovka.projectTMS.entity.ReportInformation;
import by.realovka.projectTMS.entity.TransportWrapper;
import by.realovka.projectTMS.util.DBConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;



public class Report implements Runnable {


        public void run () {

         getXMLReport();

    }


    public void getXMLReport() {
        try {
            List<ReportInformation> reportInformations=DBConnection.getOrders();
            TransportWrapper transportWrapper=new TransportWrapper(reportInformations);
            JAXBContext context = JAXBContext.newInstance(ReportInformation.class, TransportWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(transportWrapper, new FileWriter("report.xml"));

        } catch (JAXBException | IOException e) {
            e.printStackTrace();


        }

    }

}
