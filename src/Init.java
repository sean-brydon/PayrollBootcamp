import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Init {

    //Employee's Seed Data
    ArrayList<Employees> seedEmployee() {
        ArrayList<Employees> e = new ArrayList();
        e.add(new Employees(1, "Sean", "Brydon", "Developer", "Sean4755", "Password99!", (float) 37.50, false));
        e.add(new Employees(2, "Dean", "Lewis", "Developer", "Dean", "Password99!", (float) 37.50, false));
        e.add(new Employees(3, "Dan", "Clark", "HR", "dClark", "Password99!", (float) 37.50, true));
        return e;

    }


    ArrayList<Payments> seedPayments() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Payments> p = new ArrayList();
        Date d;
        p.add(new Payments(1, createDate("12/05/2014"), 1));
        p.add(new Payments(1, createDate("1/03/2018"), 2));
        p.add(new Payments(2, createDate("5/05/2015"), 3));
        p.add(new Payments(2, createDate("8/01/2017"), 4));
        p.add(new Payments(3, createDate("1/09/2011"), 5));
        p.add(new Payments(3, createDate("12/03/2011"), 6));
        p.add(new Payments(3, createDate("12/12/2018"), 7));
        return p;
    }

    ArrayList<Holidays> seedHolidays() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Holidays> h = new ArrayList();
        Date d;
        h.add(new Holidays(createDate("27/10/2019"),createDate("1/11/2019"),1,"Pending",1));
        h.add(new Holidays(createDate("27/09/2019"),createDate("2/10/2019"),2,"Pending",3));
        h.add(new Holidays(createDate("11/1/2019"),createDate("14/1/2019"),3,"Denied",3));
        h.add(new Holidays(createDate("1/2/2019"),createDate("5/2/2019"),3,"Accepted",4));
        return h;
    }

    static public Date createDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d = sdf.parse(date);
        return d;
    }


    //Holidays Seed Data

    //
}
