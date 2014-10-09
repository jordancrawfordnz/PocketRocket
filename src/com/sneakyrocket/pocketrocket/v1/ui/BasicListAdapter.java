package com.sneakyrocket.pocketrocket.v1.ui;

import java.util.ArrayList;
import java.util.List;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public class BasicListAdapter implements ListAdapter {
	private List<View> items;
	private List<DataSetObserver> observers;
	
	public BasicListAdapter() {
		items = new ArrayList<View>();
		observers = new ArrayList<DataSetObserver>();
	}
	
	public void addView(View view) {
		items.add(view);
		for (DataSetObserver observer : observers)
			observer.onChanged();
	}
	
	public void removeView(View view) {
		items.remove(view);
		for (DataSetObserver observer : observers)
			observer.onChanged();
	}

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return items.get(position);
	}

	@Override
	public int getViewTypeCount() {
		return 1;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return items.isEmpty();
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		observers.add(observer);
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		observers.remove(observer);
	}

	@Override
	public boolean areAllItemsEnabled() {
		for (View view : items)
			if (!view.isClickable())
				return false;
		return true;
	}

	@Override
	public boolean isEnabled(int position) {
		return items.get(position).isEnabled();
	}
}
