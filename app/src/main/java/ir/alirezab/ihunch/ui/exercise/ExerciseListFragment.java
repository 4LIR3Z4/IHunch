package ir.alirezab.ihunch.ui.exercise;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ir.alirezab.ihunch.R;
import ir.alirezab.ihunch.ui.exercise.dummy.DummyContent;

/**
 * A fragment representing a list of Items.
 */
public class ExerciseListFragment extends Fragment{
	
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container,
	                          Bundle savedInstanceState) {
		View view = inflater.inflate (R.layout.fragment_exercise_list, container, false);
		View listRecyclerView=view.findViewById (R.id.list);
		// Set the adapter
		if (listRecyclerView instanceof RecyclerView) {
			Context context = view.getContext ();
			RecyclerView recyclerView = (RecyclerView) listRecyclerView;
			recyclerView.setLayoutManager (new LinearLayoutManager (context));
			MyExerciseRecyclerViewAdapter myExerciseRecyclerViewAdapter=new MyExerciseRecyclerViewAdapter (DummyContent.ITEMS);
			recyclerView.setAdapter (myExerciseRecyclerViewAdapter);
			myExerciseRecyclerViewAdapter.setOnItemClickListener (new MyExerciseRecyclerViewAdapter.OnItemClickListener () {
				@Override
				public void onItemClick (View view, DummyContent.DummyItem obj, int position) {
					Log.d ("clicked", "onItemClick: ");
					Navigation.findNavController(getActivity (),R.id.nav_host_fragment).navigate(R.id.nav_exercise);
				}
			});
		}
		return view;
	}

}