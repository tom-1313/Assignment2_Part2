/*
Thomas Gadacy
Assignment 1 Part 2
2/18/21
 */

package edu.quinnipiac.gadacy.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Activity where the gameplay takes place.
 */
public class GameActivity extends Activity {
    private TicTacToe game = new TicTacToe();
    private final Pattern GRID_LOCATION = Pattern.compile("edu.quinnipiac.gadacy.tictactoe:id/button(\\d+)");
    private String nameText;
    private boolean playerTurn = true;
    private TextView playerTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState != null) {
            nameText = savedInstanceState.getString("nameText");
        }

        Intent intent = getIntent();
        nameText = intent.getStringExtra("userName");
        playerTextView = (TextView) findViewById(R.id.userName_textView);
        playerTextView.setText(nameText);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("nameText", nameText);
    }

    //When the button is clicked it sets the ImageViews to X and O based on the player's and computer's move
    public void onButtonClick(View view) {
        int viewID = view.getId();
        ImageView imageView = (ImageView) findViewById(viewID);
        imageView.setImageResource(R.drawable.redx);
        playerTextView.setText("Computer");
        playerTurn = false;
        game.checkForWinner();

        if (!playerTurn) {

            //Sets the correct ImageView at the location the player clicked based on the ID of the view using Pattern matching
            String stringID = view.getResources().getResourceName(viewID);
            Matcher matcher = GRID_LOCATION.matcher(stringID);
            if (matcher.matches()) {
                int location = Integer.parseInt(matcher.group(1));
                game.setMove(1, location);
            }
            computerMove();
        }
        int winner = game.checkForWinner();
        gameOver(winner);
    }

    //Moves the computer
    public void computerMove() {
        int compMove = game.getComputerMove();
        game.setMove(2, compMove);
        computerMove(compMove);
        playerTurn = true;
        playerTextView.setText(nameText);
    }

    //Displays the winning text and sets two images to sad/smile face depending on win condition
    public void gameOver(int winner) {
        if (game.isGameOver()) {
            TextView gameOver = (TextView) findViewById(R.id.win_message_textView);
            ImageView winImageView = (ImageView) findViewById(R.id.win_imageView);
            ImageView winImageView2 = (ImageView) findViewById(R.id.win_imageView2);
            switch (winner) {
                case 0:
                    gameOver.setText("No one has won yet!");
                    break;
                case 1:
                    gameOver.setText("It is a tie!");
                    break;
                case 2:
                    gameOver.setText(nameText + " has won!");
                    winImageView.setImageResource(R.drawable.smileface);
                    winImageView2.setImageResource(R.drawable.smileface);
                    break;
                case 3:
                    gameOver.setText("Computer has won!");
                    winImageView.setImageResource(R.drawable.sad2);
                    winImageView2.setImageResource(R.drawable.sad2);
                    break;

            }

        }
    }

    //Reset button functionality. Resets the game only when the current round is over.
    public void onResetButton(View view) {
        //Reinnitalize the GameActivity screen, call the reset in TicTacToe
        if (game.isGameOver()) {
            this.onCreate(null);
            game.clearBoard();
        } else {
            Toast.makeText(this,"The game isn't over yet!", Toast.LENGTH_SHORT).show();
        }
    }

    //Sets the computer location on the activity based on the number generated in computerMove()
    public void computerMove(int spot) {
        ImageView imageView;
        switch (spot) {
            case 0:
                imageView = (ImageView) findViewById(R.id.button0);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 1:
                imageView = (ImageView) findViewById(R.id.button1);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 2:
                imageView = (ImageView) findViewById(R.id.button2);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 3:
                imageView = (ImageView) findViewById(R.id.button3);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 4:
                imageView = (ImageView) findViewById(R.id.button4);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 5:
                imageView = (ImageView) findViewById(R.id.button5);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 6:
                imageView = (ImageView) findViewById(R.id.button6);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 7:
                imageView = (ImageView) findViewById(R.id.button7);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 8:
                imageView = (ImageView) findViewById(R.id.button8);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 9:
                imageView = (ImageView) findViewById(R.id.button9);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 10:
                imageView = (ImageView) findViewById(R.id.button10);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 11:
                imageView = (ImageView) findViewById(R.id.button11);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 12:
                imageView = (ImageView) findViewById(R.id.button12);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 13:
                imageView = (ImageView) findViewById(R.id.button13);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 14:
                imageView = (ImageView) findViewById(R.id.button14);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 15:
                imageView = (ImageView) findViewById(R.id.button15);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 16:
                imageView = (ImageView) findViewById(R.id.button16);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 17:
                imageView = (ImageView) findViewById(R.id.button17);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 18:
                imageView = (ImageView) findViewById(R.id.button18);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 19:
                imageView = (ImageView) findViewById(R.id.button19);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 20:
                imageView = (ImageView) findViewById(R.id.button20);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 21:
                imageView = (ImageView) findViewById(R.id.button21);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 22:
                imageView = (ImageView) findViewById(R.id.button22);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 23:
                imageView = (ImageView) findViewById(R.id.button23);
                imageView.setImageResource(R.drawable.redo);
                break;
            case 24:
                imageView = (ImageView) findViewById(R.id.button24);
                imageView.setImageResource(R.drawable.redo);
                break;
        }
    }
}
