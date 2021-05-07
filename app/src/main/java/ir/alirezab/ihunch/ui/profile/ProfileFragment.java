package ir.alirezab.ihunch.ui.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ir.alirezab.ihunch.R;

public class ProfileFragment extends Fragment {
	
	private ProfileViewModel profileViewModel;
	
	public View onCreateView (@NonNull LayoutInflater inflater,
	                          ViewGroup container, Bundle savedInstanceState) {
		profileViewModel =
				new ViewModelProvider (this).get (ProfileViewModel.class);
		View root = inflater.inflate (R.layout.fragment_profile, container, false);

//		getSupportActionBar().setTitle(null);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		//final TextView textView = root.findViewById (R.id.text_profile);
		profileViewModel.getText ().observe (getViewLifecycleOwner (), new Observer<String> () {
			@Override
			public void onChanged (@Nullable String s) {
				//textView.setText (s);
			}
		});
		return root;
	}
	
	@Override
	public void onActivityCreated (@Nullable Bundle savedInstanceState) {
		super.onActivityCreated (savedInstanceState);
		/*try {
			((AppCompatActivity) getActivity ()).getSupportActionBar ().setTitle (null);
			((AppCompatActivity) getActivity ()).getSupportActionBar ().hide ();
		} catch (Exception e) {
			Log.d ("TAG", "onActivityCreated: " +
					e.getMessage ());
		}*/
	}
}