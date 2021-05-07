package ir.alirezab.ihunch.ui.exercise;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import ir.alirezab.ihunch.R;
import ir.alirezab.ihunch.ui.exercise.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyExerciseRecyclerViewAdapter extends RecyclerView.Adapter<MyExerciseRecyclerViewAdapter.ViewHolder> {
	
	public interface OnItemClickListener {
		void onItemClick(View view, DummyItem obj, int position);
	}
	public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
		this.mOnItemClickListener = mItemClickListener;
	}
	
	private final List<DummyItem> mValues;
	private OnItemClickListener mOnItemClickListener;
	
	public MyExerciseRecyclerViewAdapter (List<DummyItem> items) {
		mValues = items;
	}
	
	@NotNull
	@Override
	public ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
		View view = LayoutInflater.from (parent.getContext ())
				.inflate (R.layout.exercise_item, parent, false);
		return new ViewHolder (view);
	}
	
	@Override
	public void onBindViewHolder (final ViewHolder holder, int position) {
		holder.mItem = mValues.get (position);
		holder.mIdView.setText (mValues.get (position).content);
		if (position < 3) {
			holder.progressBar.setProgress (100);
			holder.txtPercentage.setText ("100%");
		} else if (position == 3) {
			holder.progressBar.setProgress (60);
			holder.txtPercentage.setText ("60%");
		} else {
			holder.progressBar.setProgress (0);
			holder.txtPercentage.setText ("0%");
		}
		holder.exercise_item_parent.setOnClickListener (new View.OnClickListener () {
			@Override
			public void onClick (View v) {
				if (mOnItemClickListener != null) {
					mOnItemClickListener.onItemClick(v, mValues.get(position), position);
				}
			}
		});
		//holder.mContentView.setText (mValues.get (position).content);
	}
	
	@Override
	public int getItemCount () {
		return mValues.size ();
	}
	
	public class ViewHolder extends RecyclerView.ViewHolder {
		
		public final RelativeLayout exercise_item_parent;
		public final TextView mIdView;
		public final TextView txtPercentage;
		public final ProgressBar progressBar;
		//public final MaterialButton materialButton;
		//public final TextView mContentView;
		public DummyItem mItem;
		
		public ViewHolder (View view) {
			super (view);
			exercise_item_parent=(RelativeLayout)view.findViewById (R.id.exercise_item_parent);
			mIdView = (TextView) view.findViewById (R.id.exercise_item_name);
			txtPercentage = (TextView) view.findViewById (R.id.exercise_item_Percentage);
			progressBar = (ProgressBar) view.findViewById (R.id.exercise_item_progressBar);
			//materialButton=(MaterialButton)view.findViewById (R.id.buttonIcon1);
			//mContentView = (TextView) view.findViewById (R.id.content);
		}
		
		@Override
		public String toString () {
			return super.toString () + " '"; //+ mContentView.getText () + "'";
		}
	}
}