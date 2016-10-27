/**
 * Created by wrket on 25-Oct-16.
 */
import org.jfree.ui.RefineryUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PostgreSQLJDBC {
    public static void main( String args[] )
    {
        data dataProbeersel = new data();
        //List list_of_Januari = dataProbeersel.monthGenerator("feb", 31, "02");
        //graphcreationdate ababababa = new graphcreationdate("Harrys!", "Harry registratie", (ArrayList<Integer>) list_of_Januari, "jan" ,31);
        List list_of_feb = dataProbeersel.DrawOneMonth("feb");
        System.out.println("Operation done successfully");
        System.out.println(list_of_feb.get(1));
        System.out.println(list_of_feb.get(5));
        System.out.println(list_of_feb.get(6));
        System.out.println(list_of_feb.get(7));
//        graphcreationdate chart = new graphcreationdate("Harrys!", "Harry registratie", (ArrayList<Integer>) list_of_feb, "feb" ,31);
//                chart.pack( );
//        RefineryUtilities.centerFrameOnScreen( chart );
//        chart.setVisible( true );
    }
}
