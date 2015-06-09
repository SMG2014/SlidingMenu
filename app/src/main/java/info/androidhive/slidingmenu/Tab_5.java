package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tab_5 extends Fragment {
	
	public Tab_5(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) 
	{
		
		       View rootView = inflater.inflate(R.layout.fragment_tab_5, container, false);

		  	 final Button start=(Button)rootView.findViewById(R.id.button3);
    	     final Button stop=(Button)rootView.findViewById(R.id.button4);
		      
		        
		        start.setOnClickListener(new OnClickListener ()
		        {
		        	@Override
		        	 public void onClick(View v) 
		        	{

		 	 	       
		 				 start.setEnabled(false);
		 		         stop.setEnabled(true);
		 	          

		 	 	    }
		        	
		        });
		        
		        stop.setOnClickListener(new OnClickListener ()
		        {
		        	@Override
		        	 public void onClick(View v) 
		        	{

		 	 	        
		 	           
		 				 start.setEnabled(true);
		 		         stop.setEnabled(false);
		 		



		 	 	    }
		        	
		        });
		       
		       return rootView;
		        
		       	
	}
    

}
