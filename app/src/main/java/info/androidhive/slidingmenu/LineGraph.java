package info.androidhive.slidingmenu;

import java.text.DateFormat;
import java.util.Date;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


import android.content.Context;
import android.graphics.Color;

public class LineGraph {

	private GraphicalView view;
	
	private TimeSeries dataset = new TimeSeries("Heart Rate vs Time"); 
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	
	private XYSeriesRenderer renderer = new XYSeriesRenderer(); // This will be used to customize line 1
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer(); // Holds a collection of XYSeriesRenderer and customizes the graph
	
	//private GraphicalView mChart;
	


	public LineGraph()
	{
		//DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		//float val = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 18, metrics);
		// Add single dataset to multiple dataset
		mDataset.addSeries(dataset);
		
		// Customization time for line 1!
		renderer.setColor(Color.RED);
		renderer.setPointStyle(PointStyle.DIAMOND);
		renderer.setFillPoints(true);
		
		// Enable Zoom
		mRenderer.setZoomButtonsVisible(true);
		
	     String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

	     
		mRenderer.setXTitle(currentDateTimeString);
		
		//xAxis.titleLabel.textColor 
		
	    mRenderer.setShowGrid(true);

		mRenderer.setYTitle("Heart Rate (bpm)");
		
		mRenderer.setAxisTitleTextSize(20);
		// Add single renderer to multiple renderer
		mRenderer.addSeriesRenderer(renderer);	
		
		mRenderer.setZoomEnabled(true, true);
		mRenderer.setPanEnabled(true, true); //use to lock or unlock the x-axis and the y-axis
		mRenderer.setScale(1);




	}
	
	

	public GraphicalView getView(Context context) 
	{
		view =  ChartFactory.getLineChartView(context, mDataset, mRenderer);
		
     	return view;
	}
	


	

}


/**
 * set ontouch listener for double tap
 */


/* @Override
 protected void onResume() 
 {
   super.onResume();
   if (mChartView == null) {
     LinearLayout layout = (LinearLayout) findViewById(R.id.chart);
     mChartView = ChartFactory.getLineChartView(this, mDataset, mRenderer);
     // enable the chart click events
     mRenderer.setClickEnabled(true);
     mRenderer.setSelectableBuffer(10);
     mChartView.setOnClickListener(new View.OnClickListener() {
       public void onClick(View v) {
         // handle the click event on the chart
         SeriesSelection seriesSelection = mChartView.getCurrentSeriesAndPoint();
         if (seriesSelection == null) {
           Toast.makeText(XYChartBuilder.this, "No chart element", Toast.LENGTH_SHORT).show();
         } else {
           // display information of the clicked point
           Toast.makeText(
               XYChartBuilder.this,
               "Chart element in series index " + seriesSelection.getSeriesIndex()
                   + " data point index " + seriesSelection.getPointIndex() + " was clicked"
                   + " closest point value X=" + seriesSelection.getXValue() + ", Y="
                   + seriesSelection.getValue(), Toast.LENGTH_SHORT).show();
         }
       }
     });
     layout.addView(mChartView, new LayoutParams(LayoutParams.FILL_PARENT,
         LayoutParams.FILL_PARENT));
     boolean enabled = mDataset.getSeriesCount() > 0;
     setSeriesWidgetsEnabled(enabled);
   } else {
     mChartView.repaint();
   }
 }

*/
