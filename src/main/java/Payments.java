import org.joda.time.DateTime;



public class Payments
{
    //EID,  datePaymentWasMade, grossValuePayment.
    private int EID;
    private DateTime datePayment;
    private float grossValue;
    private int paymentID;
    private float netPay;

    public Payments(int EID, DateTime datePayment,int paymentID) {
        this.EID = EID;
        this.datePayment = datePayment;
        this.paymentID = paymentID;

        for(Employees e: Login.employees){
            float netPay = e.getContHours() * (float)e.getrOfPay();
            float gPay;
            gPay = netPay * (float)0.8;
            this.grossValue = gPay;
            this.netPay = netPay;
        }
    }

    public int getEID() {
        return EID;
    }

    public void setEID(int EID) {
        this.EID = EID;
    }

    public DateTime getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(DateTime datePayment) {
        this.datePayment = datePayment;
    }

    public float getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(int grossValue) {
        this.grossValue = grossValue;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public void setGrossValue(float grossValue) {
        this.grossValue = grossValue;
    }

    public float getNetPay() {
        return netPay;
    }

    public void setNetPay(float netPay) {
        this.netPay = netPay;
    }
}
