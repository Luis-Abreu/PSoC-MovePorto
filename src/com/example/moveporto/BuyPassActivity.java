package com.example.moveporto;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BuyPassActivity extends ActionBarActivity {

	private Button btnhourly;
	private Button btnDaily;
	private Button btnWeekly;
	private Button btnMonthly;
	private Button btnYearly;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy_pass);

		btnhourly = (Button) findViewById(R.id.btn1);
		btnDaily = (Button) findViewById(R.id.btn5);
		btnWeekly = (Button) findViewById(R.id.btn4);
		btnMonthly = (Button) findViewById(R.id.btn3);
		btnYearly = (Button) findViewById(R.id.btn2);

		btnhourly.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						BuyPassActivity.this);
				// Add the buttons
				builder.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Passe passe = new Passe(TipoPasse.HOURLY,
										DashboardActivity.user);
								DashboardActivity.user.setCurrentpass(passe);
								
								Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
								startActivity(i);
								finish();
							}
						});
				builder.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				builder.setMessage(R.string.confirm_buy).setTitle(
						R.string.buy_pass);
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});

		btnDaily.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						BuyPassActivity.this);
				// Add the buttons
				builder.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Passe passe = new Passe(TipoPasse.DAYLY,
										DashboardActivity.user);
								DashboardActivity.user.setCurrentpass(passe);
								
								Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
								startActivity(i);
								finish();
							}
						});
				builder.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				builder.setMessage(R.string.confirm_buy).setTitle(
						R.string.buy_pass);
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});

		btnWeekly.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						BuyPassActivity.this);
				// Add the buttons
				builder.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Passe passe = new Passe(TipoPasse.WEEKLY,
										DashboardActivity.user);
								DashboardActivity.user.setCurrentpass(passe);
								
								Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
								startActivity(i);
								finish();
							}
						});
				builder.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				builder.setMessage(R.string.confirm_buy).setTitle(
						R.string.buy_pass);
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});

		btnMonthly.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						BuyPassActivity.this);
				// Add the buttons
				builder.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Passe passe = new Passe(TipoPasse.MONTHLY,
										DashboardActivity.user);
								DashboardActivity.user.setCurrentpass(passe);
								
								Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(i);
								finish();
							}
						});
				builder.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				builder.setMessage(R.string.confirm_buy).setTitle(
						R.string.buy_pass);
				AlertDialog dialog = builder.create();
				dialog.show();

			}
		});

		btnYearly.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						BuyPassActivity.this);
				// Add the buttons
				builder.setPositiveButton("ok",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Passe passe = new Passe(TipoPasse.YEARLY,
										DashboardActivity.user);
								DashboardActivity.user.setCurrentpass(passe);
								
								Intent i = new Intent(getApplicationContext(),DashboardActivity.class);
								startActivity(i);
								finish();
							}
						});
				builder.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.cancel();
							}
						});
				builder.setMessage(R.string.confirm_buy).setTitle(
						R.string.buy_pass);
				AlertDialog dialog = builder.create();
				dialog.show();
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
