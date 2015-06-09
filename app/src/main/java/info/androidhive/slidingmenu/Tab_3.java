package info.androidhive.slidingmenu;


import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Tab_3 extends Fragment {
	
	private static Thread thread;
	
	private GraphicalView view1;
	
	private TimeSeries dataset = new TimeSeries("Heart Rate vs Time"); 
	private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();
	
	private XYSeriesRenderer renderer = new XYSeriesRenderer(); // This will be used to customize line 1
	private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer(); // Holds a collection of XYSeriesRenderer and customizes the graph
	final int CHART_SCROLL_INC = 20;	//Size of jumps when scrolling to the left

	public LinearLayout chartContainer;
	
	public Tab_3(){}
	
	public void FragmentButton()
	{
		
	} 

	 	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
	{
       View rootView = inflater.inflate(R.layout.fragment_tab_3, container, false);

        
		//final TextView t1 = (TextView)rootView.findViewById(R.id.textView1);       

        final Button start=(Button)rootView.findViewById(R.id.button1);
        final Button stop=(Button)rootView.findViewById(R.id.button2);
        TextView testTextView = (TextView) rootView.findViewById(R.id.dummyTextView);
        float textSize = testTextView.getTextSize();
        
        chartContainer = (LinearLayout) rootView.findViewById(R.id.chart_container);
        
        start.setOnClickListener(new OnClickListener ()
        {
        	@Override
        	 public void onClick(View v) 
        	{ switch (v.getId())
 	 	        {   case (R.id.button1):
 	 	         
 	 	 			openChart();
 		            break; 
 	 	        }
            }
        	
        });   
        return rootView;
       	}
	 	
	 	void openChart()
		 {  
			 thread = new Thread() {
						public void run()
						{
							for (int i = 0; i >= 0; i++) 
							{
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}						
		           
				              		
								Random random = new Random();

							    int someInt = random.nextInt(40);
							    
							 // Getting the clicked Date ( x value )
			                    DateFormat.getDateTimeInstance().format(new Date());
			                
			//	                SeriesSelection seriesSelection = view1.getCurrentSeriesAndPoint();
                    
			 //               long clickedDateSeconds = (long) seriesSelection.getXValue();
		
			   //              Date [] clickedDate = null;
			     //            clickedDate [i]  = new Date(clickedDateSeconds);
				      
					final long now = new Date().getTime();           
				    Date date = new Date ();
                    dataset.add(new Date(now - 1000 * 60 * 10), someInt);              
	      	       	view1.repaint() ;
															
							}
						}
					};
					thread.start();
					
				
					
					mDataset.addSeries(dataset);
					
					// Customization time for line 1!
					renderer.setColor(Color.RED);
					renderer.setPointStyle(PointStyle.DIAMOND);
					renderer.setFillPoints(true);
					
					// Enable Zoom
					mRenderer.setZoomButtonsVisible(true);
					
					//Enable external zoom buttons
					mRenderer.setZoomEnabled(true);
					mRenderer.setExternalZoomEnabled(true);
					
				     String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

				     
					mRenderer.setXTitle(currentDateTimeString);
					
					//xAxis.titleLabel.textColor 
					
				    mRenderer.setShowGrid(true);

					mRenderer.setYTitle("Heart Rate (bpm)");
					
					mRenderer.setYLabels(10);
			        mRenderer.setXLabels(5);
			        
				//	mRenderer.setAxisTitleTextSize(20);
					// Add single renderer to multiple renderer
					mRenderer.addSeriesRenderer(renderer);	
					
					mRenderer.setZoomEnabled(true, true);
					mRenderer.setPanEnabled(true, true); //use to lock or unlock the x-axis and the y-axis
					mRenderer.setScale((float) 1);

	             //   mRenderer.setYLabels(15);
	                mRenderer.setYLabelsAlign(Align.RIGHT);
				//mRenderer.setYtitleAlign(Align.LEFT);

	             //   mRenderer.setXLabels(15);
	                mRenderer.setXLabelsAlign(Align.CENTER);
	                
	                DisplayMetrics metrics = getResources().getDisplayMetrics();
	                float textSize;
	                float textSizeMini;
	                
	                switch (getResources().getDisplayMetrics().densityDpi) {
	                case DisplayMetrics.DENSITY_XHIGH:
	                	mRenderer.setMargins(new int[]{40, 60, 25, 10});
	                 textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
	                   Chart.TEXT_SIZE_XHDPI,
	                   metrics);
	                 textSizeMini = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
	                   Chart.TEXT_SIZE_XHDPI_MINI,
	                   metrics);
						mRenderer.setPointSize(30);

	                 break;
	                case DisplayMetrics.DENSITY_HIGH:
	                 mRenderer.setMargins(new int[]{30, 50, 20, 10});
	                 textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
	                   Chart.TEXT_SIZE_HDPI,
	                   metrics);
	                 textSizeMini = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
	                   Chart.TEXT_SIZE_HDPI_MINI,
	                   metrics);
						mRenderer.setPointSize(30);

	                 break;
	                default:
	                	mRenderer.setMargins(new int[]{30, 50, 20, 10});
	                 textSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
	                   Chart.TEXT_SIZE_MDPI,
	                   metrics);
	                 mRenderer.setAxisTitleTextSize(textSize);
	                 textSizeMini = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
	                   Chart.TEXT_SIZE_MDPI_MINI,
	                   metrics);
						mRenderer.setPointSize(10);

	                 break;
	               }

	                mRenderer.setAxisTitleTextSize(textSize);
	                mRenderer.setLegendTextSize(textSizeMini);
	                mRenderer.setChartTitleTextSize(textSize);
	               //the num in the axis
	                mRenderer.setLabelsTextSize(textSizeMini);


	                mRenderer.setYLabelsAlign(Align.RIGHT);
	                mRenderer.setSelectableBuffer(20);
	                mRenderer.setMargins(new int[]{ 80, 80, 80, 80 });	                

					view1 =  ChartFactory.getLineChartView(getActivity().getApplicationContext(), mDataset, mRenderer);
				      
			   		mRenderer.setClickEnabled(true);
			     	mRenderer.setSelectableBuffer(30); // this makes it easier for clicking the point
		       	
			     // Setting a click event listener for the graph
			        view1.setOnClickListener(new View.OnClickListener() {
			            
			            public void onClick(View v) {
			            	
			            	Format formatter = new SimpleDateFormat("MMM-dd-yyyy");
			           
			                SeriesSelection seriesSelection = view1.getCurrentSeriesAndPoint();
			            //    TimeSeriesSelection ts= +;
			                if (seriesSelection != null) {
			                    int seriesIndex = seriesSelection.getSeriesIndex();
			                    String selectedSeries="Heart Rate";
			                    if(seriesIndex==0)
			                        selectedSeries = "Heart Rate";
			                    else
			                        selectedSeries = "Heart Rate";
			 
			                    // Getting the clicked Date ( x value )
			                    DateFormat.getDateTimeInstance().format(new Date());
			                
			                 long clickedDateSeconds = (long) seriesSelection.getXValue();
			                 Date clickedDate = new Date(clickedDateSeconds);
			                 String strDate = formatter.format(clickedDate);
			 
			                    // Getting the y value
			                    int hrt = (int) seriesSelection.getValue();
			                    
			                    
			                    // Displaying Toast Message
			                    Toast.makeText(getActivity().getApplicationContext(),
			                        selectedSeries + " at "  + clickedDate + " : " + hrt ,
			                        Toast.LENGTH_SHORT).show();
			                    }
			                }
			            });

			        
			        // Adding the Line Chart to the LinearLayout
			        chartContainer.addView(view1,new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		 
			        
		 }
		 
		 
		
			
	 	


	 	    
}
