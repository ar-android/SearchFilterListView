package com.example.searchfilterlistview;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView lvFiltter;
	private EditText etFilter;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etFilter = (EditText) findViewById(R.id.etIput);
		lvFiltter = (ListView) findViewById(R.id.lvFilter);

		String dataFilter[] = new String[] { "Satu", "Dua", "Tiga", "Empat" };

		adapter = new ArrayAdapter<String>(
				getApplicationContext(), R.layout.itemlist, R.id.txItemlist,
				dataFilter);
		lvFiltter.setAdapter(adapter);
		
		TextWatcher txWatcher = new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				MainActivity.this.adapter.getFilter().filter(s);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}
			
			@Override
			public void afterTextChanged(Editable s) {
				
			}
		};
		
		etFilter.addTextChangedListener(txWatcher);
	}
}
