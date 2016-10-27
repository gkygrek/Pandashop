
/**
 * Created by wrket on 26-Oct-16.
 */
import org.jfree.ui.RefineryUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class data {


    public int createDataGraphsMonth(String month, String monthNumber) {
        int monthResult = 0;
        Connection c = null;
        Statement stat = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/TestGrafiekenBouwen",
                            "postgres", "12345");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stat = c.createStatement();
            String query = ("Select count(*) as " + month + " from harrys where SUBSTR(creationdate, 6,2) = '" + monthNumber + "';");
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                monthResult = rs.getInt(month);
            }
            rs.close();
            stat.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return monthResult;
    }

    public int createDataGraphsDay(String day, String dayNumber, String monthNumber) {
        int dayResult = 0;
        Connection c = null;
        Statement stat = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/TestGrafiekenBouwen",
                            "postgres", "12345");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stat = c.createStatement();
            String query = ("Select count(*) as " + day + " from harrys where SUBSTR(creationdate, 9,2) = '" + dayNumber + "' and SUBSTR(creationdate, 6,2) = '" + monthNumber + "';");
            ResultSet rs = stat.executeQuery(query);

            while (rs.next()) {
                dayResult = rs.getInt(day);
            }
            rs.close();
            stat.close();
            c.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return dayResult;
    }

    public List monthGenerator(String month, int days, String monthNumber) {
        int a = 0;
        String dayNumber = "0";
        List<Integer> daylist = new ArrayList<Integer>();
        int i = 0;
        while (i > days) {
            if (i < 10) {
                dayNumber = "0" + Integer.toString(i);
            }
            if (i > 9) {
                dayNumber = Integer.toString(i);
            }
            a = createDataGraphsDay(month, dayNumber, monthNumber);
            daylist.add(a);
            i = i + 1;
        }
        return daylist;

    }

    public List DrawOneMonth(String month) {
        String monthNumber = "00";
        int AmountOfDays = 0;
        if (month == "jan") {
            monthNumber = "01";
            AmountOfDays = 31;
        }

        if (month == "feb") {
            monthNumber = "02";
            AmountOfDays = 31;
        }
        if (month == "mar") {
            monthNumber = "03";
            AmountOfDays = 31;
        }
        if (month == "apr") {
            monthNumber = "04";
            AmountOfDays = 31;
        }

        if (month == "may") {
            monthNumber = "05";
            AmountOfDays = 31;
        }
        if (month == "jun") {
            monthNumber = "06";
            AmountOfDays = 31;
        }
        if (month == "jul") {
            monthNumber = "07";
            AmountOfDays = 31;
        }

        if (month == "aug") {
            monthNumber = "08";
            AmountOfDays = 31;
        }
        if (month == "sep") {
            monthNumber = "09";
            AmountOfDays = 31;
        }
        ;
        if (month == "oct") {
            monthNumber = "10";
            AmountOfDays = 31;
        }

        if (month == "nov") {
            monthNumber = "11";
            AmountOfDays = 31;
        }
        if (month == "dec") {
            monthNumber = "12";
            AmountOfDays = 31;
        }


        int dayResult = 0;
        Connection c = null;
        Statement stat = null;
        List<Integer> myList = new ArrayList<Integer>();

        try {
            int CountThisDay = 1;

            while (AmountOfDays > 0) {
                Class.forName("org.postgresql.Driver");
                c = DriverManager
                        .getConnection("jdbc:postgresql://localhost:5432/TestGrafiekenBouwen",
                                "postgres", "12345");
                c.setAutoCommit(false);
                System.out.println("Opened database successfully");
                stat = c.createStatement();

                String Daynumber;


                if (CountThisDay <= 9) {


                    Daynumber = "0" + Integer.toString(CountThisDay);
                } else {
                    Daynumber = Integer.toString(CountThisDay);
                }

                String query = ("Select count(*) as " + Daynumber + " from harrys where SUBSTR(creationdate, 6,2) = '" + Daynumber + "' and SUBSTR(creationdate, 9,2) = '" + monthNumber + "';");
                ResultSet rs = stat.executeQuery(query);


                while (rs.next()) {
                    dayResult = rs.getInt(CountThisDay);
                    rs.close();
                    stat.close();
                    c.close();
                }
                myList.add(dayResult);
                AmountOfDays =-1;
                CountThisDay =+1;
            }


        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return myList;
    }
}