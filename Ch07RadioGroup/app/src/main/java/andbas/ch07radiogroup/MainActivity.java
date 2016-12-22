package andbas.ch07radiogroup;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btOk;
	private AutoCompleteTextView acName;
	private Spinner spnImage;
    private RadioGroup rdgSex;

	String stSex,st,stSpn = new String();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		stSex = "男性";
        buildViews();  //user define
    }

    private void buildViews(){
		acName = (AutoCompleteTextView)findViewById(R.id.acIdName);
    	rdgSex = (RadioGroup)findViewById(R.id.rdgIdSex);
    	btOk = (Button)findViewById(R.id.btIdOk);
		spnImage = (Spinner)findViewById(R.id.spnIdImage);

		String[] stImgAry = {"圖片一","圖片二"};
		ArrayAdapter<String> adImageList = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item,stImgAry);
		adImageList.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spnImage.setAdapter(adImageList);
		spnImage.setOnItemSelectedListener(spnImageListener);

		String[] nameAry = getResources().getStringArray(R.array.nameArray);
		ArrayAdapter<String> adapterName =
				new ArrayAdapter<String>(this, R.layout.listitem, nameAry);
		acName.setAdapter(adapterName);

        rdgSex.setOnCheckedChangeListener(rdgSexchkChListener);
        btOk.setOnClickListener(btListener);
    }

	private AdapterView.OnItemSelectedListener spnImageListener = new AdapterView.OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
			ImageView img = (ImageView)findViewById(R.id.ivIdSpn);
			stSpn = adapterView.getSelectedItem().toString();
			if(stSpn.equals("圖片一")){
				img.setImageResource(R.drawable.img1);
			}else if(stSpn.equals("圖片二")){
				img.setImageResource(R.drawable.img2);
			}else{
				img.setImageResource(R.drawable.blank);
			}
		}
		@Override
		public void onNothingSelected(AdapterView<?> adapterView) {
		}
	};

    private OnCheckedChangeListener rdgSexchkChListener =
    		new OnCheckedChangeListener () {
    	public void onCheckedChanged(RadioGroup group,
    			                     int checkedId){
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


    		CharSequence csName=acName.getText();
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
