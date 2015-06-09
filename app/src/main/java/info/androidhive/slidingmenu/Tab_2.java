package info.androidhive.slidingmenu;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab_2 extends Fragment {
	
	TextView t1;
	
	public Tab_2(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) 
	{
 
        View rootView = inflater.inflate(R.layout.fragment_tab_2, container, false);
  
        
        t1 = (TextView)rootView.findViewById(R.id.textView1);
        String myTag = getTag();
        
        

        return rootView;
    }
	
	public void b_updateText(String t){
		  t1.setText(t);
		 }
}
