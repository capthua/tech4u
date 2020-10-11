package me.ffulauh.springsource.context.propertyeditor;

import java.util.Date;

public class UserManager {
    private Date dateValue;

    @Override
    public String toString() {
        return "UserManager{" +
                "dateValue=" + dateValue +
                '}';
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
}
