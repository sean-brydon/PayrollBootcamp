import org.joda.time.DateTime;



public class Holidays {
    //
    // Start DATE
    // End DATE
    // Status of Holiday
        // status = ["Approved","Denied","Pending"]
    // Employee ID
    private DateTime startDate;
    private DateTime endDate;
    private int EID;
    String status;
    private int HID;

    public Holidays(DateTime startDate, DateTime endDate, int EID, String status,int HID) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.EID = EID;
        this.status = status;
        this.HID = HID;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
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
