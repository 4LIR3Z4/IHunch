package ir.alirezab.ihunch.ui.exercise;

import androidx.lifecycle.ViewModelProvider;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import ir.alirezab.ihunch.R;

public class ExerciseFragment extends Fragment {
	
	private ExerciseViewModel mViewModel;
	//	VideoView videoview;
	ImageView img_exercise;
	
	Handler timerHandler = new Handler (Looper.getMainLooper ());
	long startTime = 0;
	int i = 2;
	Runnable timerRunnable = new Runnable () {
		
		@Override
		public void run () {

//			timerTextView.setText(String.format("%d:%02d", minutes, seconds));
			
			//timerHandler.postDelayed(this, 500);
			Bitmap bm = null;
			try {
				bm = getBitmapFromAsset ("front_squat_" + i + ".png", getView ());
			} catch (IOException e) {
				e.printStackTrace ();
			}
			if (i == 2) {
				i = 1;
			}
			else{
				i +=1;
			}
			img_exercise.setImageBitmap (bm);
			timerHandler.postDelayed (this, 500);
			//timerHandler.removeCallbacks(timerRunnable);
		}
	};
	
	@Override
	public void onPause () {
		super.onPause ();
		//timerHandler.removeCallbacks (timerRunnable);
	}
	
	@Override
	public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
	                          @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate (R.layout.fragment_exercise, container, false);
		img_exercise = (ImageView) view.findViewById (R.id.img_exercise);
		
		Bitmap bm = null;
		try {
			bm = getBitmapFromAsset ("front_squat_2.png", view);
		} catch (IOException e) {
			e.printStackTrace ();
		}
		
		img_exercise.setImageBitmap (bm);
		startTime = System.currentTimeMillis ();
		timerHandler.postDelayed (timerRunnable, 500);
		return view;
	}
	
	@Override
	public void onActivityCreated (@Nullable Bundle savedInstanceState) {
		super.onActivityCreated (savedInstanceState);
		mViewModel = new ViewModelProvider (this).get (ExerciseViewModel.class);


//		videoview = (VideoView) getView ().findViewById (R.id.videoView);
//
//		Uri uri = Uri.parse ("android.resource://" + getView ().getContext ().getPackageName () + "/" + R.raw.video1);
//		Log.d ("urii", "onCreateView: " + uri.toString ());
//		videoview.setVideoURI (uri);
//		videoview.start ();
//		videoview.setOnPreparedListener (new MediaPlayer.OnPreparedListener () {
//			@Override
//			public void onPrepared (MediaPlayer mp) {
//				mp.setLooping (true);
//			}
//		});
		// TODO: Use the ViewModel
	}
	
	private Bitmap getBitmapFromAsset (String strName, View view) throws IOException {
		AssetManager assetManager = view.getContext ().getAssets ();
		InputStream inputStream = assetManager.open (strName);
		return BitmapFactory.decodeStream (inputStream);
	}
}