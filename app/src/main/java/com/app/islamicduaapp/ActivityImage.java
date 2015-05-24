package com.app.islamicduaapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.islamicduaapp.R;
import com.google.android.gms.ads.AdSize;

public class ActivityImage extends Activity implements OnClickListener{

	private LinearLayout img_Main;
	private TextView txtHeading;
	private int imageNumber = 0 , screenHeight = 0 , screenWidth = 0;
	private RelativeLayout rel_bac , rel_list , rel_forward , rel_rate;
	private String[] arrData = new String[]{
			"1. For Morning & Evening" , 
			"2. At the time of difficulty when Sleeping" ,
			"3. After having a nightmare",
			"4. On awakening from sleep",
			"5. When entering the toilet",
			"6. When coming out of the toilet",
			"7. At the begining of making wudu",
			"8. On completion of wudu",
			"9. When going for Fajr Prayer",
			"10. When entering the Masjid",
			"11. After completion of prayer in Masjid",
			"12. On hearing the Athan",
			"13. Upon hearing the Muazzin give Athan",
			"14. After Witr Prayer",
			"15. After Chasht",
			"16. After Fajr",
			"17. When entering ones home",
			"18. When leaving the house",
			"19. When entering the Market",
			"20. When buying or selling at the Market",
			"21. Before meals",
			"22. After Meals",
			"23. At the time of lifting the table cloth",
			"24. When drinking milk",
			"25. At meal times when visiting someone",
			"26. When leaving the residence of the host",
			"27. When drinking water",
			"28. Drinking Zam Zam water",
			"29. When breaking fast",
			"30. After Iftaar",
			"31. Making Iftaar at someone's place",
			"32. When dressing",
			"33. When wearing new clothes",
			"34. When seeing a muslim in new clothes",
			"35. When looking in the mirror",
			"36. Arrival of a bride or a new animal",
			"37. Congratulating the bridegroom",
			"38. Intention of having relation with wife",
			"39. At the time of emission of sperm",
			"40. When the child begins to talk",
			"41. When sighting the new moon",
			"42. When Beginnig the Journey ",
			"43. When someone is in a difficulty",
			"44. When one sees a muslim laughing",
			"45. When fearing the enemy",
			"46. When the enemy surrounds",
			"47. Before rising from a gathering",
			"48. When in any difficult",
			"49. For the progression of wealth",
			"50. Dua For the Night of Qadr",
			"51. Loving someone or when one helps",
			"52. When one sees the things one loves",
			"53. When one's heart is filled with emotion",
			"54. When something is lost",
			"55. When one talks too fast",
			"56. When eating new fruit of the season",
			"57. At the time of anger or when hearing a donkey or a dog",
			"58. Dua For Rain",
			"59. When one sees heavy clouds",
			"60. At the time of rain",
			"61. When rain exceeds the limits",
			"62. At the time of thunder",
			"63. At the time of heavy winds",
			"64. Talbiya of Hajj",
			"65. Dua to be read at Arafat",
			"66. While making Tawaaf",
			"67. When making Qurbani",
			"68. When meeting another Muslim",
			"69. Returning Salaam",
			"70. Dua when sneezing",
			"71. When hearing someone sneeze",
			"72. Upon the thought of a bad omen",
			"73. Dua to pay off debts",
			"74. Dua after salaat of need",
			"75. Istikhara",
			"76. When visiting the sick",
			"77. For any calamity",
			"78. For the cure of any illness",
			"79. To soothe ill children",
			"80. Dua by an ill person",
			"81. When death is eminent",
			"82. When the soul is leaving the body",
			"83. When the soul has left the body",
			"84. When going to the deceased house",
			"85. When someone child die",
			"86. When burying the dead",
			"87. When entering the cemetry",
			"88. When consoling someone",
			"89. At the time of fire",
			"90. For any animal",
			"91. For pain of the eye",
			"92. For kidney stone or urination problems",
			"93. When fever or pain increases",
			"94. Dua on a burn injury",
			"95. When tired of life",
			"96. During wudu",
			"97. Istikhara for Marriage",
	};

	private Bitmap bit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		getScreenWidth();

		Bundle bundle = getIntent().getExtras();
		imageNumber = bundle.getInt("ImageNumber");

		img_Main = (LinearLayout) findViewById(R.id.img_Main);

		rel_bac = (RelativeLayout) findViewById(R.id.rel_back);
		rel_list = (RelativeLayout) findViewById(R.id.rel_list);
		rel_rate = (RelativeLayout) findViewById(R.id.rel_rate);
		rel_forward = (RelativeLayout) findViewById(R.id.rel_forward);
		txtHeading = (TextView) findViewById(R.id.txtHeading);

		rel_bac.setOnClickListener(this);
		rel_list.setOnClickListener(this);
		rel_rate.setOnClickListener(this);
		rel_forward.setOnClickListener(this);

		if(img_Main.getBackground() != null){
			img_Main.setBackgroundResource(0);
		}
		setImageNumber(imageNumber);
		
		BitmapDrawable background = new BitmapDrawable(bit);
		img_Main.setBackgroundDrawable(background);
		
		ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
		if(cd.isConnectingToInternet()){
		showAdd();
		}
	}

	
	private void showAdd() {
		com.google.android.gms.ads.AdView adView = new com.google.android.gms.ads.AdView(ActivityImage.this);
		adView.setAdUnitId("ca-app-pub-1878227272753934/2746266001");
		adView.setAdSize(AdSize.BANNER);
		RelativeLayout layout = (RelativeLayout)findViewById(R.id.rel_bottom_image);        
		layout.addView(adView);
		layout.setGravity(Gravity.CENTER);
		com.google.android.gms.ads.AdRequest request = new com.google.android.gms.ads.AdRequest.Builder().build();
		adView.loadAd(request);
	}
	
	
	private void getScreenWidth() {
		DisplayMetrics metrics = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		screenWidth = metrics.widthPixels;
		screenHeight = metrics.heightPixels;
	}

	private void setImageNumber(int number) {
		switch (number) {
		case 0:
			txtHeading.setText(arrData[number]);
			//bit =decodeSampledBitmapFromResource(getResources(), R.drawable.one , screenWidth , screenHeight);
			
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.one , screenWidth , screenHeight);
							
			break;
		case 1:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.two , screenWidth , screenHeight);
			
			break;
		case 2:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.three , screenWidth , screenHeight);
			break;
		case 3:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.four , screenWidth , screenHeight);
			break;
		case 4:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.five , screenWidth , screenHeight);
			break;
		case 5:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.six , screenWidth , screenHeight);
			break;
		case 6:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.seven , screenWidth , screenHeight);
			break;
		case 7:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource( getResources(), R.drawable.eight , screenWidth , screenHeight);
			break;
		case 8:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.nine , screenWidth , screenHeight);
			break;
		case 9:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.ten , screenWidth , screenHeight);
			break;
		case 10:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.eleven , screenWidth , screenHeight);
			break;
		case 11:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.twelve , screenWidth , screenHeight);
			break;
		case 12:
			txtHeading.setText(arrData[number]);
			bit = decodeSampledBitmapFromResource(getResources(), R.drawable.thirteen , screenWidth , screenHeight);
			break;
		case 13:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fourteen , screenWidth , screenHeight);
			break;
		case 14:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fifteen , screenWidth , screenHeight);
			break;
		case 15:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixteen , screenWidth , screenHeight);
			break;
		case 16:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventeen , screenWidth , screenHeight);
			break;
		case 17:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eighteen , screenWidth , screenHeight);
			break;
		case 18:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.ninteen , screenWidth , screenHeight);
			break;
		case 19:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twenty , screenWidth , screenHeight);
			break;
		case 20:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentyone , screenWidth , screenHeight);
			break;
		case 21:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentytwo , screenWidth , screenHeight);
			break;
		case 22:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentythree , screenWidth , screenHeight);
			break;
		case 23:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentyfour , screenWidth , screenHeight);
			break;
		case 24:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentyfive , screenWidth , screenHeight);
			break;
		case 25:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentysix , screenWidth , screenHeight);
			break;
		case 26:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentyseven , screenWidth , screenHeight);
			break;
		case 27:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentyeight , screenWidth , screenHeight);
			break;
		case 28:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.twentynine , screenWidth , screenHeight);
			break;
		case 29:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirty , screenWidth , screenHeight);
			break;
		case 30:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtyone , screenWidth , screenHeight);
			break;
		case 31:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtytwo , screenWidth , screenHeight);
			break;
		case 32:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtythree , screenWidth , screenHeight);
			break;
		case 33:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtyfour , screenWidth , screenHeight);
			break;
		case 34:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtyfive , screenWidth , screenHeight);
			break;
		case 35:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtysix , screenWidth , screenHeight);
			break;
		case 36:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtyseveb , screenWidth , screenHeight);
			break;
		case 37:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtyeight , screenWidth , screenHeight);
			break;
		case 38:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.thirtynine , screenWidth , screenHeight);
			break;
		case 39:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.forty , screenWidth , screenHeight);
			break;
		case 40:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortyone , screenWidth , screenHeight);
			break;
		case 41:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortytwo , screenWidth , screenHeight);
			break;
		case 42:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortythree , screenWidth , screenHeight);
			break;
		case 43:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortyfour , screenWidth , screenHeight);
			break;
		case 44:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortyfife , screenWidth , screenHeight);
			break;
		case 45:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortysix , screenWidth , screenHeight);
			break;
		case 46:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortyseven , screenWidth , screenHeight);
			break;
		case 47:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortyeight , screenWidth , screenHeight);
			break;
		case 48:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fortynine , screenWidth , screenHeight);
			break;
		case 49:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fifty , screenWidth , screenHeight);
			break;
		case 50:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftyone , screenWidth , screenHeight);
			break;
		case 51:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftytwo , screenWidth , screenHeight);
			break;
		case 52:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftythree , screenWidth , screenHeight);
			break;
		case 53:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftyfour , screenWidth , screenHeight);
			break;
		case 54:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftyfife , screenWidth , screenHeight);
			break;
		case 55:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftysix , screenWidth , screenHeight);
			break;
		case 56:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftyseven , screenWidth , screenHeight);
			break;
		case 57:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftyeight , screenWidth , screenHeight);
			break;
		case 58:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.fiftynine , screenWidth , screenHeight);
			break;
		case 59:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixty , screenWidth , screenHeight);
			break;
		case 60:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtyone , screenWidth , screenHeight);
			break;
		case 61:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtytwo , screenWidth , screenHeight);
			break;
		case 62:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtythree , screenWidth , screenHeight);
			break;
		case 63:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtyfour , screenWidth , screenHeight);
			break;
		case 64:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtyfive , screenWidth , screenHeight);
			break;
		case 65:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtysix , screenWidth , screenHeight);
			break;
		case 66:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtyseven , screenWidth , screenHeight);
			break;
		case 67:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtyeight , screenWidth , screenHeight);
			break;
		case 68:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.sixtynine , screenWidth , screenHeight);
			break;
		case 69:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventy , screenWidth , screenHeight);
			break;
		case 70:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventyone , screenWidth , screenHeight);
			break;
		case 71:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventytwo , screenWidth , screenHeight);
			break;
		case 72:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventythree , screenWidth , screenHeight);
			break;
		case 73:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventyfour , screenWidth , screenHeight);
			break;
		case 74:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventyfive , screenWidth , screenHeight);
			break;
		case 75:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventysix , screenWidth , screenHeight);
			break;
		case 76:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventyseven , screenWidth , screenHeight);
			break;
		case 77:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventyeight , screenWidth , screenHeight);
			break;
		case 78:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.seventynine , screenWidth , screenHeight);
			break;
		case 79:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eighty , screenWidth , screenHeight);
			break;
		case 80:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightyone , screenWidth , screenHeight);
			break;
		case 81:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightytwo , screenWidth , screenHeight);
			break;
		case 82:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightythree , screenWidth , screenHeight);
			break;
		case 83:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightyfour , screenWidth , screenHeight);
			break;
		case 84:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightyfive , screenWidth , screenHeight);
			break;
		case 85:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightysix , screenWidth , screenHeight);
			break;
		case 86:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightyseven , screenWidth , screenHeight);
			break;
		case 87:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightyeigth , screenWidth , screenHeight);
			break;
		case 88:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.eightynine , screenWidth , screenHeight);
			break;
		case 89:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.ninty , screenWidth , screenHeight);
			break;
		case 90:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintyone , screenWidth , screenHeight);
			break;
		case 91:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintytwo , screenWidth , screenHeight);
			break;
		case 92:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintythree , screenWidth , screenHeight);
			break;
		case 93:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintyfour , screenWidth , screenHeight);
			break;
		case 94:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintyfive , screenWidth , screenHeight);
			break;
		case 95:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintysix , screenWidth , screenHeight);
			break;
		case 96:
			txtHeading.setText(arrData[number]);
			bit =decodeSampledBitmapFromResource(getResources(), R.drawable.nintyseven , screenWidth , screenHeight);
			break;
		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rel_back:
			if(imageNumber == 0){				
			}else{				
				imageNumber = imageNumber - 1;	
				
				if(bit != null){
					bit.recycle();
				}
				
				setImageNumber(imageNumber);
				
				BitmapDrawable background = new BitmapDrawable(bit);
				img_Main.setBackgroundDrawable(background);
			}
			break;
		case R.id.rel_list:
			finish();
			break;
		case R.id.rel_rate:
			Uri uri = Uri.parse("market://details?id=" + ActivityImage.this.getPackageName());
			Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
			try {
				startActivity(goToMarket);
			} catch (ActivityNotFoundException e) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + ActivityImage.this.getPackageName())));
			}
			break;
		case R.id.rel_forward:
			if(imageNumber == 96){				
			}else{				
				imageNumber = imageNumber + 1;
				
				if(bit != null){
					bit.recycle();
				}
				
				setImageNumber(imageNumber);
				
				BitmapDrawable background = new BitmapDrawable(bit);
				img_Main.setBackgroundDrawable(background);
				
			}
			break;
		default:
			break;
		}
	}

	static Bitmap decodeSampledBitmapFromResource(Resources res, int resId , int width , int height) {

		final BitmapFactory.Options options = new BitmapFactory.Options();
		//BitmapFactory.decodeResource(res, resId, options);
		
		options.inDither=false;     
		options.inPurgeable=true;   
		options.inInputShareable=true;
		options.inTempStorage=new byte[32 * 1024]; 
		
		options.inSampleSize =  1 ;
		
		return BitmapFactory.decodeResource(res, resId, options);
	}

	//Given the bitmap size and View size calculate a subsampling size (powers of 2) 
	static int calculateInSampleSize( BitmapFactory.Options options, int reqWidth, int reqHeight) {
		int inSampleSize = 2;	//Default subsampling size
		// See if image raw height and width is bigger than that of required view
		if (options.outHeight > reqHeight || options.outWidth > reqWidth) {
			//bigger
			final int halfHeight = options.outHeight / 2;
			final int halfWidth = options.outWidth / 2;
			// Calculate the largest inSampleSize value that is a power of 2 and keeps both
			// height and width larger than the requested height and width.
			while ((halfHeight / inSampleSize) > reqHeight
					&& (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}
		return inSampleSize;
	}

}
