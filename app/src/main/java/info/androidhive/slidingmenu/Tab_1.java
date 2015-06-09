package info.androidhive.slidingmenu;


import java.text.DateFormat;
import java.util.Date;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


import android.app.Fragment;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Tab_1 extends Fragment 
{
	  /** The chart view that displays the data. */
	  private GraphicalView mChartView;
	  private XYSeries series = new XYSeries("PPG");
	  private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
      private XYSeriesRenderer renderer = new XYSeriesRenderer(); // This will be used to customize line 1
	  private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer(); // Holds a collection of XYSeriesRenderer and customizes the graph
	  public LinearLayout PPGchartContainer;

		private static Thread thread;


	
	public Tab_1(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
	{
 
        View rootView = inflater.inflate(R.layout.fragment_tab_1, container, false);
        final Button btn2=(Button)rootView.findViewById(R.id.button2);
        final EditText et1=(EditText)rootView.findViewById(R.id.et);
	    PPGchartContainer = (LinearLayout) rootView.findViewById(R.id.chart_container1);

        btn2.setOnClickListener(new OnClickListener ()
        {
        	@Override
        	 public void onClick(View v) 
        	{

 	 	        switch (v.getId())
 	 	        {
 	 	            case (R.id.button2):
 	 	            	String item = et1.getText().toString();

 	 	          if(item!=null&& !item.isEmpty())
 	 	          {
 	 	        	 
 	 	           Toast.makeText(getActivity().getApplicationContext(), "Heart Rate Saved", Toast.LENGTH_LONG).show();
 	 	           
 	 	           
 	 	          }
 	 	          
 		            break;
 	 	              

 	 	        }


 	 	    }
        	
        });

       ImageButton PPG = (ImageButton) rootView.findViewById(R.id.PPG);
        PPG.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
        	  switch (v.getId())
	 	        {
	 	            case (R.id.PPG):
	 	            
	 	         	  graph_intial_SetUP();
	 	 	          // Toast.makeText(getActivity().getApplicationContext(), "Heart Rate Saved", Toast.LENGTH_LONG).show();

		            break;
	                  }
        		}
        });
        return rootView;
}
	
	void graph_intial_SetUP()
	{
		Toast.makeText(getActivity().getApplicationContext(), "Heart Rate Saved", Toast.LENGTH_LONG).show();
        mDataset.addSeries(series);
        mRenderer.setXAxisMin(0);
        mRenderer.setXAxisMax(50);
        mRenderer.setYAxisMin(0);
        mRenderer.setYAxisMax(90);   
    //    mRenderer.addSeriesRenderer(renderer);
        // set some renderer properties
        renderer.setPointStyle(PointStyle.CIRCLE);
        renderer.setFillPoints(true);
    //    renderer.setDisplayChartValues(true);
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
		mRenderer.setScale((float) 1);
		mRenderer.setYLabels(15);
        mRenderer.setYLabelsAlign(Align.RIGHT);
        mRenderer.setXLabels(15);
        mRenderer.setXLabelsAlign(Align.RIGHT);
        
		
          
        mChartView = ChartFactory.getLineChartView(getActivity().getApplicationContext(),mDataset , mRenderer);
	      
        PPGchartContainer.addView(mChartView,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));


	}
	

	
	
	
} 
