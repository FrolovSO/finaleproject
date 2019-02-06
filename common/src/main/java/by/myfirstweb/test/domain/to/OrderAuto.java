package by.myfirstweb.test.domain.to;

import java.io.Serializable;

public class OrderAuto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long orderId;
    private Long autoIdOrd;
    private String dateTo;
    private String dateFrom;
    private Long userIdOrd;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAutoIdOrd() {
        return autoIdOrd;
    }

    public void setAutoIdOrd(Long autoIdOrd) {
        this.autoIdOrd = autoIdOrd;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Long getUserIdOrd() {
        return userIdOrd;
    }

    public void setUserIdOrd(Long userIdOrd) {
        this.userIdOrd = userIdOrd;
    }
}
