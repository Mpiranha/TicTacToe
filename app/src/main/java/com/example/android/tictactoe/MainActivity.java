package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    boolean PLAYER_X = true;
    boolean isWinner = false;

    int TURN_COUNT = 0;
    int playerX_score = 0;
    int playerO_score = 0;

    TextView scoreForPlayerX;
    TextView scoreForPlayerO;

    Button text00;
    Button text01;
    Button text02;

    Button text10;
    Button text11;
    Button text12;

    Button text20;
    Button text21;
    Button text22;

    TableLayout tableLayout;

    int[][] boardStatus = new int[3][3];

    View[][] buttons = new View[3][3];


    TextView gameStatus;
    CardView resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text00 = (Button) findViewById(R.id.text00);
        text01 = (Button) findViewById(R.id.text01);
        text02 = (Button) findViewById(R.id.text02);

        text10 = (Button) findViewById(R.id.text10);
        text11 = (Button) findViewById(R.id.text11);
        text12 = (Button) findViewById(R.id.text12);

        text20 = (Button) findViewById(R.id.text20);
        text21 = (Button) findViewById(R.id.text21);
        text22 = (Button) findViewById(R.id.text22);

        tableLayout = (TableLayout) findViewById(R.id.table_tic_tac);
        Spinner morePlayerOption = (Spinner) findViewById(R.id.more_items);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.more_play_option, android.R.layout.simple_spinner_dropdown_item);
        morePlayerOption.setAdapter(adapter);
        morePlayerOption.setOnItemSelectedListener(this);


        scoreForPlayerX = (TextView) findViewById(R.id.x_score);
        scoreForPlayerO = (TextView) findViewById(R.id.o_score);


        resetButton = (CardView) findViewById(R.id.reset_button);
        gameStatus = findViewById(R.id.game_status);

        resetButton.setOnClickListener(this);

        tableLayout.setOnClickListener(this);

        text00.setOnClickListener(this);
        text01.setOnClickListener(this);
        text02.setOnClickListener(this);

        text10.setOnClickListener(this);
        text11.setOnClickListener(this);
        text12.setOnClickListener(this);

        text20.setOnClickListener(this);
        text21.setOnClickListener(this);
        text22.setOnClickListener(this);




        initializeBoardStatus();
    }


    @Override
    public void onClick(View view) {
        Log.d(TAG, "Inside onClick");

        boolean resetButtonPressed = false;

        switch (view.getId()) {
            case R.id.text00:
                if (PLAYER_X) {
                    text00.setText(R.string.x);
                    text00.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[0][0] = 1;
                } else {
                    text00.setText(R.string.o);
                    text00.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[0][0] = 0;
                }
                setOnClickGameRestart();
                text00.setEnabled(false);
                break;

            case R.id.text01:
                if (PLAYER_X) {
                    text01.setText(R.string.x);
                    text01.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[0][1] = 1;
                } else {
                    text01.setText(R.string.o);
                    text01.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[0][1] = 0;
                }
                setOnClickGameRestart();
                text01.setEnabled(false);
                break;

            case R.id.text02:
                if (PLAYER_X) {
                    text02.setText(R.string.x);
                    text02.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[0][2] = 1;
                } else {
                    text02.setText(R.string.o);
                    text02.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[0][2] = 0;
                }
                setOnClickGameRestart();
                text02.setEnabled(false);
                break;

            case R.id.text10:
                if (PLAYER_X) {
                    text10.setText(R.string.x);
                    text10.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[1][0] = 1;
                } else {
                    text10.setText(R.string.o);
                    text10.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[1][0] = 0;
                }
                setOnClickGameRestart();
                text10.setEnabled(false);
                break;

            case R.id.text11:
                if (PLAYER_X) {
                    text11.setText(R.string.x);
                    text11.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[1][1] = 1;
                } else {
                    text11.setText(R.string.o);
                    text11.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[1][1] = 0;
                }
                setOnClickGameRestart();
                text11.setEnabled(false);
                break;

            case R.id.text12:
                if (PLAYER_X) {
                    text12.setText(R.string.x);
                    text12.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[1][2] = 1;
                } else {
                    text12.setText(R.string.o);
                    text12.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[1][2] = 0;
                }
                setOnClickGameRestart();
                text12.setEnabled(false);
                break;

            case R.id.text20:
                if (PLAYER_X) {
                    text20.setText(R.string.x);
                    text20.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[2][0] = 1;
                } else {
                    text20.setText(R.string.o);
                    text20.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[2][0] = 0;
                }
                setOnClickGameRestart();
                text20.setEnabled(false);
                break;

            case R.id.text21:
                if (PLAYER_X) {
                    text21.setText(R.string.x);
                    text21.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[2][1] = 1;
                } else {
                    text21.setText(R.string.o);
                    text21.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[2][1] = 0;
                }
                setOnClickGameRestart();
                text21.setEnabled(false);
                break;

            case R.id.text22:
                if (PLAYER_X) {
                    text22.setText(R.string.x);
                    text22.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[2][2] = 1;
                } else {
                    text22.setText(R.string.o);
                    text22.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[2][2] = 0;
                }
                setOnClickGameRestart();
                text22.setEnabled(false);
                break;

            case R.id.reset_button:
                resetButtonPressed = true;
                break;

            case R.id.table_tic_tac:
                if (isWinner) {
                    restartGame();
                }
                break;

            default:
                break;

        }

        if (resetButtonPressed) {
            resetBoard();
        } else {
            TURN_COUNT++;
            PLAYER_X = !PLAYER_X;

            if (PLAYER_X) {
                setGameStatus("Player X turn");
            } else {
                setGameStatus("Player O turn");
            }

            if (TURN_COUNT == 9) {
                result("Game Draw");
                isWinner = true;
            }

            checkWinner();
        }

    }

    private void checkWinner() {
        Log.d(TAG, "inside checkWinner");

        buttons[0][0] = text00;
        buttons[0][1] = text01;
        buttons[0][2] = text02;

        buttons[1][0] = text10;
        buttons[1][1] = text11;
        buttons[1][2] = text12;

        buttons[2][0] = text20;
        buttons[2][1] = text21;
        buttons[2][2] = text22;


        //Horizontal --- rows
        for (int i = 0; i < 3; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]) {
                if (boardStatus[i][0] == 1) {
                    result("Player X winner\n" + (i + 1) + " row");
                    isWinner = true;
                    changeWinBoxes(buttons[i][0], buttons[i][1], buttons[i][2]);
                    playerX_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                } else if (boardStatus[i][0] == 0) {
                    result("Player O winner\n" + (i + 1) + " row");
                    isWinner = true;
                    changeWinBoxes(buttons[i][0], buttons[i][1], buttons[i][2]);
                    playerO_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                }
            }
        }

        //Vertical --- columns
        for (int i = 0; i < 3; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    result("Player X winner\n" + (i + 1) + " column");
                    isWinner = true;
                    changeWinBoxes(buttons[0][i], buttons[1][i], buttons[2][i]);
                    playerX_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                } else if (boardStatus[0][i] == 0) {
                    result("Player O winner\n" + (i + 1) + " column");
                    isWinner = true;
                    changeWinBoxes(buttons[0][i], buttons[1][i], buttons[2][i]);
                    playerO_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                }
            }
        }

        //First diagonal
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                result("Player X winner\nFirst Diagonal");
                isWinner = true;
                changeWinBoxes(buttons[0][0], buttons[1][1], buttons[2][2]);
                playerX_score += 1;
                setScore(playerX_score, playerO_score);
            } else if (boardStatus[0][0] == 0) {
                result("Player O winner\nFirst Diagonal");
                isWinner = true;
                changeWinBoxes(buttons[0][0], buttons[1][1], buttons[2][2]);
                playerO_score += 1;
                setScore(playerX_score, playerO_score);
            }
        }

        //Second diagonal
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                result("Player X winner\nSecond Diagonal");
                isWinner = true;
                changeWinBoxes(buttons[0][2], buttons[1][1], buttons[2][0]);
                playerX_score += 1;
                setScore(playerX_score, playerO_score);
            } else if (boardStatus[0][2] == 0) {
                result("Player O winner\nSecond Diagonal");
                changeWinBoxes(buttons[0][2], buttons[1][1], buttons[2][0]);
                isWinner = true;
                playerO_score += 1;
                setScore(playerX_score, playerO_score);
            }
        }
    }

    private void enableAllBoxes(boolean value) {
        Log.d(TAG, "inside enableAllBoxes");
        text00.setEnabled(value);
        text01.setEnabled(value);
        text02.setEnabled(value);

        text10.setEnabled(value);
        text11.setEnabled(value);
        text12.setEnabled(value);

        text20.setEnabled(value);
        text21.setEnabled(value);
        text22.setEnabled(value);
    }

    public void changeWinBoxes(View firstBox, View secondBox, View thirdBox) {
            Log.d(TAG, "Inside changeWinBoxes");

            firstBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
            secondBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
            thirdBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
    }

    public void resetButtonColor() {
        Log.d(TAG, "inside resetButtonColor");

        text00.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text01.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text02.setBackgroundColor(getResources().getColor(R.color.initial_button));

        text10.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text11.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text12.setBackgroundColor(getResources().getColor(R.color.initial_button));

        text20.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text21.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text22.setBackgroundColor(getResources().getColor(R.color.initial_button));

    }

    private void result(String winner) {
        Log.d(TAG, "inside result");


        setGameStatus(winner);
        enableAllBoxes(false);
        isWinner = false;
    }

    public void setOnClickGameRestart() {
            restartGame();
    }

    public void restartGame() {
        Log.d(TAG, "inside restartGame");

        if (isWinner) {
            text00.setText("");
            text01.setText("");
            text02.setText("");

            text10.setText("");
            text11.setText("");
            text12.setText("");

            text20.setText("");
            text21.setText("");
            text22.setText("");

            enableAllBoxes(true);


            PLAYER_X = true;
            TURN_COUNT = -1;
            isWinner = false;

            resetButtonColor();

            initializeBoardStatus();

            setGameStatus("Start Again!!!");
        }
    }

    private void resetBoard() {
        Log.d(TAG, "inside resetBoard");
        text00.setText("");
        text01.setText("");
        text02.setText("");

        text10.setText("");
        text11.setText("");
        text12.setText("");

        text20.setText("");
        text21.setText("");
        text22.setText("");

        setScore(0, 0);

        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;
        isWinner = false;

        initializeBoardStatus();
        resetButtonColor();
        setGameStatus("Start Again!!!");

        playerO_score = 0;
        playerX_score = 0;

        Toast.makeText(this, "Board Reset", Toast.LENGTH_SHORT).show();
    }

    private void setGameStatus(String text) {
        gameStatus.setText(text);
    }

    private void setScore(int scoreX, int scoreO) {
        Log.d(TAG, "inside setScore");

        scoreForPlayerX.setText(getString(R.string.playerX_score, scoreX));
        scoreForPlayerO.setText(getString(R.string.playerO_score, scoreO));
        Log.v(TAG, playerO_score + "");
        Log.v(TAG, playerO_score + "");
    }


    private void initializeBoardStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
        if (parent.getItemAtPosition(pos).equals(getString(R.string.play_with_comp))) {
            Intent playWithComputer = new Intent(this, ThreeXThreePlayerVsComp.class);
            startActivity(playWithComputer);
        }
        if (parent.getItemAtPosition(pos).equals(getString(R.string.five_five))) {
            // Do nothing yet
            Intent switchToFiveXFive = new Intent(this, FiveXFiveWithHuman.class);
            startActivity(switchToFiveXFive);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
