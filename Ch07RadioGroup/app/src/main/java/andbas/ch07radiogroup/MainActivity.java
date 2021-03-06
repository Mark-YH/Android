package andbas.ch07radiogroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btOk;
	private EditText etName;
    private RadioGroup rdgSex;
	String stSex,st = new String();
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		stSex = "男性";
        buildViews();  //user define
    }
 
    private void buildViews(){
    	etName = (EditText)findViewById(R.id.etIdName);    
    	rdgSex = (RadioGroup)findViewById(R.id.rdgIdSex);    
    	btOk = (Button)findViewById(R.id.btIdOk);    

        rdgSex.setOnCheckedChangeListener(rdgSexchkChListener);
        btOk.setOnClickListener(btListener); 
    }
    
    private OnCheckedChangeListener rdgSexchkChListener = new OnCheckedChangeListener () {
    	public void onCheckedChanged(RadioGroup group, int checkedId){
/*
    		if (checkedId == R.id.rbIdMale) 
				{stSex ="男性";}
			else
			    {stSex ="女性";}
*/				
    		int intChkRb = rdgSex.getCheckedRadioButtonId();
			switch (intChkRb) {
			case R.id.rbIdMale:
				stSex ="男性";
				break;
			case R.id.rbIdFemale:
				stSex ="女性";
				break;
			}
    	}
    };
    
    private OnClickListener btListener = new OnClickListener() {    
    	public void onClick(View v) {
    		CharSequence csName=etName.getText();
    		if (stSex.equals("男性"))
    			{st=csName.toString()+"先生, 你好!";}
    		else
    			{st=csName.toString()+"小姐, 妳好!";}
    		Toast.makeText(MainActivity.this,
    				st,
    				Toast.LENGTH_SHORT)
					.show();
   	     }
    };
}
