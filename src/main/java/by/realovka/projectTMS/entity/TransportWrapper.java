package by.realovka.projectTMS.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "orders")
public class TransportWrapper {
    private List<ReportInformation> wrapper;

    public TransportWrapper(List<ReportInformation> wrapper) {
        this.wrapper = wrapper;
    }

    public TransportWrapper() {
    }
 @XmlElement(name = "order")
    public List<ReportInformation> getWrapper() {
        return wrapper;
    }

    public void setWrapper(List<ReportInformation> wrapper) {
        this.wrapper = wrapper;
    }
}
