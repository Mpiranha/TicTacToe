package com.example.android.tictactoe;

import android.app.Activity;
import android.content.Intent;
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

/**
 * Created by manuel_piranha on 4/14/18.
 */

public class FiveXFiveWithHuman extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
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
    Button text03;
    Button text04;

    Button text10;
    Button text11;
    Button text12;
    Button text13;
    Button text14;

    Button text20;
    Button text21;
    Button text22;
    Button text23;
    Button text24;

    Button text30;
    Button text31;
    Button text32;
    Button text33;
    Button text34;

    Button text40;
    Button text41;
    Button text42;
    Button text43;
    Button text44;


    TableLayout tableLayout;

    int[][] boardStatus = new int[5][5];

    View[][] buttons = new View[5][5];


    TextView gameStatus;
    CardView resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_vs_human);

        text00 = (Button) findViewById(R.id.text00);
        text01 = (Button) findViewById(R.id.text01);
        text02 = (Button) findViewById(R.id.text02);
        text03 = (Button) findViewById(R.id.text03);
        text04 = (Button) findViewById(R.id.text04);



        text10 = (Button) findViewById(R.id.text10);
        text11 = (Button) findViewById(R.id.text11);
        text12 = (Button) findViewById(R.id.text12);
        text13 = (Button) findViewById(R.id.text13);
        text14 = (Button) findViewById(R.id.text14);

        text20 = (Button) findViewById(R.id.text20);
        text21 = (Button) findViewById(R.id.text21);
        text22 = (Button) findViewById(R.id.text22);
        text23 = (Button) findViewById(R.id.text23);
        text24 = (Button) findViewById(R.id.text24);

        text30 = (Button) findViewById(R.id.text30);
        text31 = (Button) findViewById(R.id.text31);
        text32 = (Button) findViewById(R.id.text32);
        text33 = (Button) findViewById(R.id.text33);
        text34 = (Button) findViewById(R.id.text34);

        text40 = (Button) findViewById(R.id.text40);
        text41 = (Button) findViewById(R.id.text41);
        text42 = (Button) findViewById(R.id.text42);
        text43 = (Button) findViewById(R.id.text43);
        text44 = (Button) findViewById(R.id.text44);

        tableLayout = (TableLayout) findViewById(R.id.table_tic_tac);
        Spinner morePlayerOption = (Spinner) findViewById(R.id.more_items);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.more_play_option_5x5_human, android.R.layout.simple_spinner_dropdown_item);
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
        text03.setOnClickListener(this);
        text04.setOnClickListener(this);

        text10.setOnClickListener(this);
        text11.setOnClickListener(this);
        text12.setOnClickListener(this);
        text13.setOnClickListener(this);
        text14.setOnClickListener(this);

        text20.setOnClickListener(this);
        text21.setOnClickListener(this);
        text22.setOnClickListener(this);
        text23.setOnClickListener(this);
        text24.setOnClickListener(this);

        text30.setOnClickListener(this);
        text31.setOnClickListener(this);
        text32.setOnClickListener(this);
        text33.setOnClickListener(this);
        text34.setOnClickListener(this);

        text40.setOnClickListener(this);
        text41.setOnClickListener(this);
        text42.setOnClickListener(this);
        text43.setOnClickListener(this);
        text44.setOnClickListener(this);




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

            case R.id.text03:
                if (PLAYER_X) {
                    text03.setText(R.string.x);
                    text03.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[0][3] = 1;
                } else {
                    text03.setText(R.string.o);
                    text03.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[0][3] = 0;
                }
                setOnClickGameRestart();
                text03.setEnabled(false);
                break;

            case R.id.text04:
                if (PLAYER_X) {
                    text04.setText(R.string.x);
                    text04.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[0][4] = 1;
                } else {
                    text04.setText(R.string.o);
                    text04.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[0][4] = 0;
                }
                setOnClickGameRestart();
                text04.setEnabled(false);
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

            case R.id.text13:
                if (PLAYER_X) {
                    text13.setText(R.string.x);
                    text13.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[1][3] = 1;
                } else {
                    text13.setText(R.string.o);
                    text13.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[1][3] = 0;
                }
                setOnClickGameRestart();
                text13.setEnabled(false);
                break;

            case R.id.text14:
                if (PLAYER_X) {
                    text14.setText(R.string.x);
                    text14.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[1][4] = 1;
                } else {
                    text14.setText(R.string.o);
                    text14.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[1][4] = 0;
                }
                setOnClickGameRestart();
                text14.setEnabled(false);
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

            case R.id.text23:
                if (PLAYER_X) {
                    text23.setText(R.string.x);
                    text23.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[2][3] = 1;
                } else {
                    text23.setText(R.string.o);
                    text23.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[2][3] = 0;
                }
                setOnClickGameRestart();
                text23.setEnabled(false);
                break;

            case R.id.text24:
                if (PLAYER_X) {
                    text24.setText(R.string.x);
                    text24.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[2][4] = 1;
                } else {
                    text24.setText(R.string.o);
                    text24.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[2][4] = 0;
                }
                setOnClickGameRestart();
                text24.setEnabled(false);
                break;

            case R.id.text30:
                if (PLAYER_X) {
                    text30.setText(R.string.x);
                    text30.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[3][0] = 1;
                } else {
                    text30.setText(R.string.o);
                    text30.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[3][0] = 0;
                }
                setOnClickGameRestart();
                text30.setEnabled(false);
                break;

            case R.id.text31:
                if (PLAYER_X) {
                    text31.setText(R.string.x);
                    text31.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[3][1] = 1;
                } else {
                    text31.setText(R.string.o);
                    text31.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[3][1] = 0;
                }
                setOnClickGameRestart();
                text31.setEnabled(false);
                break;

            case R.id.text32:
                if (PLAYER_X) {
                    text32.setText(R.string.x);
                    text32.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[3][2] = 1;
                } else {
                    text32.setText(R.string.o);
                    text32.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[3][2] = 0;
                }
                setOnClickGameRestart();
                text32.setEnabled(false);
                break;

            case R.id.text33:
                if (PLAYER_X) {
                    text33.setText(R.string.x);
                    text33.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[3][3] = 1;
                } else {
                    text33.setText(R.string.o);
                    text33.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[3][3] = 0;
                }
                setOnClickGameRestart();
                text33.setEnabled(false);
                break;

            case R.id.text34:
                if (PLAYER_X) {
                    text34.setText(R.string.x);
                    text34.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[3][4] = 1;
                } else {
                    text34.setText(R.string.o);
                    text34.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[3][4] = 0;
                }
                setOnClickGameRestart();
                text34.setEnabled(false);
                break;

            case R.id.text40:
                if (PLAYER_X) {
                    text40.setText(R.string.x);
                    text40.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[4][0] = 1;
                } else {
                    text40.setText(R.string.o);
                    text40.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[4][0] = 0;
                }
                setOnClickGameRestart();
                text40.setEnabled(false);
                break;

            case R.id.text41:
                if (PLAYER_X) {
                    text41.setText(R.string.x);
                    text41.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[4][1] = 1;
                } else {
                    text41.setText(R.string.o);
                    text41.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[4][1] = 0;
                }
                setOnClickGameRestart();
                text41.setEnabled(false);
                break;

            case R.id.text42:
                if (PLAYER_X) {
                    text42.setText(R.string.x);
                    text42.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[4][2] = 1;
                } else {
                    text42.setText(R.string.o);
                    text42.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[4][2] = 0;
                }
                setOnClickGameRestart();
                text42.setEnabled(false);
                break;

            case R.id.text43:
                if (PLAYER_X) {
                    text43.setText(R.string.x);
                    text43.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[4][3] = 1;
                } else {
                    text43.setText(R.string.o);
                    text43.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[4][3] = 0;
                }
                setOnClickGameRestart();
                text43.setEnabled(false);
                break;

            case R.id.text44:
                if (PLAYER_X) {
                    text44.setText(R.string.x);
                    text44.setTextColor(getResources().getColor(R.color.playerX_color));
                    boardStatus[4][4] = 1;
                } else {
                    text44.setText(R.string.o);
                    text44.setTextColor(getResources().getColor(R.color.playerO_color));
                    boardStatus[4][4] = 0;
                }
                setOnClickGameRestart();
                text44.setEnabled(false);
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

            if (TURN_COUNT == 25) {
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
        buttons[0][3] = text03;
        buttons[0][4] = text04;

        buttons[1][0] = text10;
        buttons[1][1] = text11;
        buttons[1][2] = text12;
        buttons[1][3] = text13;
        buttons[1][4] = text14;

        buttons[2][0] = text20;
        buttons[2][1] = text21;
        buttons[2][2] = text22;
        buttons[2][3] = text23;
        buttons[2][4] = text24;

        buttons[3][0] = text20;
        buttons[3][1] = text21;
        buttons[3][2] = text22;
        buttons[3][3] = text23;
        buttons[3][4] = text24;

        buttons[4][0] = text20;
        buttons[4][1] = text21;
        buttons[4][2] = text22;
        buttons[4][3] = text23;
        buttons[4][4] = text24;




        //Horizontal --- rows
        for (int i = 0; i < 5; i++) {
            if (boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2] && boardStatus[i][0] == boardStatus[i][3] && boardStatus[i][0] == boardStatus[i][4]) {
                if (boardStatus[i][0] == 1) {
                    result("Player X winner\n" + (i + 1) + " row");
                    isWinner = true;
                    changeWinBoxes(buttons[i][0], buttons[i][1], buttons[i][2], buttons[i][3], buttons[i][4]);
                    playerX_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                } else if (boardStatus[i][0] == 0) {
                    result("Player O winner\n" + (i + 1) + " row");
                    isWinner = true;
                    changeWinBoxes(buttons[i][0], buttons[i][1], buttons[i][2], buttons[i][3], buttons[i][4]);
                    playerO_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                }
            }
        }

        //Vertical --- columns
        for (int i = 0; i < 5; i++) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i] && boardStatus[0][i] == boardStatus[3][i] && boardStatus[0][i] == boardStatus[4][i]) {
                if (boardStatus[0][i] == 1) {
                    result("Player X winner\n" + (i + 1) + " column");
                    isWinner = true;
                    changeWinBoxes(buttons[0][i], buttons[1][i], buttons[2][i], buttons[3][i], buttons[4][i]);
                    playerX_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                } else if (boardStatus[0][i] == 0) {
                    result("Player O winner\n" + (i + 1) + " column");
                    isWinner = true;
                    changeWinBoxes(buttons[0][i], buttons[1][i], buttons[2][i], buttons[3][i], buttons[4][i]);
                    playerO_score += 1;
                    setScore(playerX_score, playerO_score);
                    break;
                }
            }
        }

        //First diagonal
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2] && boardStatus[0][0] == boardStatus[3][3] && boardStatus[0][0] == boardStatus[4][4]) {
            if (boardStatus[0][0] == 1) {
                result("Player X winner\nFirst Diagonal");
                isWinner = true;
                changeWinBoxes(buttons[0][0], buttons[1][1], buttons[2][2], buttons[3][3], buttons[4][4]);
                playerX_score += 1;
                setScore(playerX_score, playerO_score);
            } else if (boardStatus[0][0] == 0) {
                result("Player O winner\nFirst Diagonal");
                isWinner = true;
                changeWinBoxes(buttons[0][0], buttons[1][1], buttons[2][2], buttons[3][3], buttons[4][4]);
                playerO_score += 1;
                setScore(playerX_score, playerO_score);
            }
        }

        //Second diagonal
        if (boardStatus[0][4] == boardStatus[1][3] && boardStatus[0][4] == boardStatus[2][2] && boardStatus[0][4] == boardStatus[3][1] && boardStatus[0][4] == boardStatus[4][0]) {
            if (boardStatus[0][2] == 1) {
                result("Player X winner\nSecond Diagonal");
                isWinner = true;
                changeWinBoxes(buttons[0][4], buttons[1][3], buttons[2][2], buttons[3][1], buttons[4][0]);
                playerX_score += 1;
                setScore(playerX_score, playerO_score);
            } else if (boardStatus[0][2] == 0) {
                result("Player O winner\nSecond Diagonal");
                changeWinBoxes(buttons[0][4], buttons[1][3], buttons[2][2], buttons[3][1], buttons[4][0]);
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
        text03.setEnabled(value);
        text04.setEnabled(value);

        text10.setEnabled(value);
        text11.setEnabled(value);
        text12.setEnabled(value);
        text13.setEnabled(value);
        text14.setEnabled(value);

        text20.setEnabled(value);
        text21.setEnabled(value);
        text22.setEnabled(value);
        text23.setEnabled(value);
        text24.setEnabled(value);

        text30.setEnabled(value);
        text31.setEnabled(value);
        text32.setEnabled(value);
        text33.setEnabled(value);
        text34.setEnabled(value);

        text40.setEnabled(value);
        text41.setEnabled(value);
        text42.setEnabled(value);
        text43.setEnabled(value);
        text44.setEnabled(value);
    }

    public void changeWinBoxes(View firstBox, View secondBox, View thirdBox, View fourthBox, View fifthBox) {
        Log.d(TAG, "Inside changeWinBoxes");

        firstBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
        secondBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
        thirdBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
        fourthBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
        fifthBox.setBackgroundColor(getResources().getColor(R.color.victory_white));
    }

    public void resetButtonColor() {
        Log.d(TAG, "inside resetButtonColor");

        text00.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text01.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text02.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text03.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text04.setBackgroundColor(getResources().getColor(R.color.initial_button));

        text10.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text11.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text12.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text13.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text14.setBackgroundColor(getResources().getColor(R.color.initial_button));

        text20.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text21.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text22.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text23.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text24.setBackgroundColor(getResources().getColor(R.color.initial_button));

        text30.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text31.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text32.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text33.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text34.setBackgroundColor(getResources().getColor(R.color.initial_button));

        text40.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text41.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text42.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text43.setBackgroundColor(getResources().getColor(R.color.initial_button));
        text44.setBackgroundColor(getResources().getColor(R.color.initial_button));

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
            text03.setText("");
            text04.setText("");

            text10.setText("");
            text11.setText("");
            text12.setText("");
            text13.setText("");
            text14.setText("");

            text20.setText("");
            text21.setText("");
            text22.setText("");
            text23.setText("");
            text24.setText("");

            text30.setText("");
            text31.setText("");
            text32.setText("");
            text33.setText("");
            text34.setText("");

            text40.setText("");
            text41.setText("");
            text42.setText("");
            text43.setText("");
            text44.setText("");



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
        text03.setText("");
        text04.setText("");

        text10.setText("");
        text11.setText("");
        text12.setText("");
        text13.setText("");
        text14.setText("");

        text20.setText("");
        text21.setText("");
        text22.setText("");
        text23.setText("");
        text24.setText("");

        text30.setText("");
        text31.setText("");
        text32.setText("");
        text33.setText("");
        text34.setText("");

        text40.setText("");
        text41.setText("");
        text42.setText("");
        text43.setText("");
        text44.setText("");



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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boardStatus[i][j] = -1;
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
        if (parent.getItemAtPosition(pos).equals(getString(R.string.play_with_me))) {
//            Intent playWithComputer = new Intent(this, ThreeXThreePlayerVsComp.class);
//            startActivity(playWithComputer);
        }
        if (parent.getItemAtPosition(pos).equals(getString(R.string.three_three))) {
            // Do nothing yet
            Intent threeXThreeGrid = new Intent(this, MainActivity.class);
            startActivity(threeXThreeGrid);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}


