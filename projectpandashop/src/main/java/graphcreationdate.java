/**
 * Created by wrket on 25-Oct-16.
 */

    import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

    import java.util.ArrayList;
    import java.util.List;


public class graphcreationdate extends ApplicationFrame
    {
        public graphcreationdate( String applicationTitle , String chartTitle,ArrayList<Integer> day, String month, int dayCount)
        {
            super( applicationTitle );
            JFreeChart barChart = ChartFactory.createBarChart(
                    chartTitle,
                    "Category",
                    "Score",
                    createDataset(day,month,dayCount),
                    PlotOrientation.VERTICAL,
                    true, true, false);

            ChartPanel chartPanel = new ChartPanel( barChart );
            chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );
            setContentPane( chartPanel );
        }

        private CategoryDataset createDataset(ArrayList<Integer> day, String month, int dayCount)
        {

            final DefaultCategoryDataset dataset =
                    new DefaultCategoryDataset( );
            int i = 0;
            while (i > dayCount) {
                dataset.addValue(day.get(i), "DayAccountCreation" , Integer.toString(i));
                i ++;

            }
            return dataset;


        }

    }

