package com.sapuglha.espressotips;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    static final String CURRENT_TEXT = "current_text";

    @BindView(R.id.main_activity_parent_view)
    View parentView;

    @BindView(R.id.main_activity_text_output)
    TextView textOutput;

    @BindView(R.id.main_activity_text_input)
    EditText textInput;

    @BindView(R.id.main_activity_checkbox_new_window)
    CheckBox cbxNewWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            textOutput.setText(savedInstanceState.getString(CURRENT_TEXT));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putString(CURRENT_TEXT, textOutput.getText().toString());

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @OnClick(R.id.main_activity_button_upper)
    public void upper() {
        String input = textInput.getText().toString();
        textOutput.setText(input.toUpperCase());

        Snackbar.make(parentView, "You entered: " + input, Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.main_activity_button_lower)
    public void lower() {
        String input = textInput.getText().toString();
        textOutput.setText(input.toLowerCase());

        if (cbxNewWindow.isChecked()) {
            Intent intent = new Intent(MainActivity.this, HelloActivity.class);
            intent.putExtra("name", input);

            startActivity(intent);
//            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        } else {
            Snackbar.make(parentView, "You entered: " + input, Snackbar.LENGTH_LONG).show();
        }
    }
}
