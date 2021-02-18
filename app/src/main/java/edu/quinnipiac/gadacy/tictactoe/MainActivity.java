/*
Thomas Gadacy
Assignment 1 Part 2
2/18/21
 */

package edu.quinnipiac.gadacy.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//Starting activity where the user enters name and is presented with rules of the game.
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartClick(View view) {
        EditText nameView = (EditText) findViewById(R.id.userName_editText);
        String nameText = nameView.getText().toString();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("userName", nameText);
        startActivity(intent);
    }
}