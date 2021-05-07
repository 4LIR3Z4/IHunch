package ir.alirezab.ihunch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ir.alirezab.ihunch.ui.profile.ProfileFragment;
import ir.alirezab.ihunch.ui.wizard.WizardActivity;

public class MainActivity extends AppCompatActivity {
	private static final String SETTINGS_ID = "Settings";
	private AppBarConfiguration mAppBarConfiguration;
	
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		setTheme(R.style.Theme_IHunch_NoActionBar);
		super.onCreate (savedInstanceState);
		setContentView (R.layout.activity_main);
		
		Toolbar toolbar = findViewById (R.id.toolbar);
		setSupportActionBar (toolbar);
		SharedPreferences sharedPreferences = getSharedPreferences (SETTINGS_ID, MODE_PRIVATE);
		try {
			boolean first_run = sharedPreferences.getBoolean ("first_run", true);
			if(!first_run){
				SharedPreferences.Editor editor = sharedPreferences.edit ();
				editor.putBoolean ("first_run", false);
				editor.apply ();
				Intent intent=new Intent (MainActivity.this, WizardActivity.class);
				//intent.putExtra ("textval", et.getText ().toString ().trim ());
				startActivity(intent);
			}
			
			
			
		}
		catch (Exception e){
		
		}
		
		//FloatingActionButton fab = findViewById (R.id.fab);
		/*fab.setOnClickListener (new View.OnClickListener () {
			@Override
			public void onClick (View view) {
				Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction ("Action", null).show ();
			}
		});*/
		DrawerLayout drawer = findViewById (R.id.drawer_layout);
		
		
		NavigationView navigationView = findViewById (R.id.nav_view);
		
		
		// Passing each menu ID as a set of Ids because each
		// menu should be considered as top level destinations.
		mAppBarConfiguration = new AppBarConfiguration.Builder (
				R.id.nav_home,R.id.nav_about,  R.id.nav_settings,R.id.nav_exercise_list)
				.setOpenableLayout (drawer)
				.build ();
		
		NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
				.findFragmentById(R.id.nav_host_fragment);
		
		NavController navController= null;
		
		if (navHostFragment != null) {
			navController = navHostFragment.getNavController();
			//NavController navController = Navigation.findNavController (this, R.id.nav_host_fragment);
			NavigationUI.setupActionBarWithNavController (this, navController, mAppBarConfiguration);
			NavigationUI.setupWithNavController (navigationView, navController);
			
			/* */
			
			CircularImageView circularImageView = navigationView.getHeaderView (0).findViewById (R.id.nav_header_profile_image);
			NavController finalNavController = navController;
			circularImageView.setOnClickListener (new View.OnClickListener () {
				@Override
				public void onClick (View v) {
					/// todo : Profile
					//finalNavController.navigate (R.id.nav_profile);
					//drawer.close ();
				}
			});
			/* */
			
		}
		
		
	}
	
	
	
	@Override
	public boolean onSupportNavigateUp () {
		NavController navController = Navigation.findNavController (this, R.id.nav_host_fragment);
		return NavigationUI.navigateUp (navController, mAppBarConfiguration)
				|| super.onSupportNavigateUp ();
	}
}