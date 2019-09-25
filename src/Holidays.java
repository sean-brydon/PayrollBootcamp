import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Holidays {
    //
    // Start DATE
    // End DATE
    // Status of Holiday
        // status = ["Approved","Denied","Pending"]
    // Employee ID
    private Date startDate;
    private Date endDate;
    private int EID;
    String status;
    private int HID;

    public Holidays(Date startDate, Date endDate, int EID, String status,int HID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.EID = EID;
        this.status = status;
        this.HID = HID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHID() {
        return HID;
    }
    public void setHID(int HID) {
        this.HID = HID;
    }
}
