package com.example.moveporto;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BuyPassActivity extends ActionBarActivity {

	private TextView btnhourly;
	private TextView btnDaily;
	private TextView btnWeekly;
	private TextView btnMonthly;
	private TextView btnYearly;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_pass);

		btnhourly = (TextView) findViewById(R.id.textView1);
		btnDaily = (TextView) findViewById(R.id.textView5);
		btnWeekly = (TextView) findViewById(R.id.textView4);
		btnMonthly = (TextView) findViewById(R.id.textView3);
		btnYearly = (TextView) findViewById(R.id.textView2);

		btnhourly.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setBackgroundColor(getResources().getColor(
						R.color.abc_search_url_text_pressed));

				// CENAS n' stuff

			}
		});

		btnDaily.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setBackgroundColor(getResources().getColor(
						R.color.abc_search_url_text_pressed));

				// CENAS n' stuff

			}
		});

		btnWeekly.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setBackgroundColor(getResources().getColor(
						R.color.abc_search_url_text_pressed));

				// CENAS n' stuff

			}
		});

		btnMonthly.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setBackgroundColor(getResources().getColor(
						R.color.abc_search_url_text_pressed));

				// CENAS n' stuff

			}
		});

		btnYearly.setOnClickListener(new TextView.OnClickListener() {

			@Override
			public void onClick(View v) {
				v.setBackgroundColor(getResources().getColor(
						R.color.abc_search_url_text_pressed));

				// CENAS n' stuff

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy_pass, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void newPass() {

	}
}
