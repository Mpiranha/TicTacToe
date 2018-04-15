package com.example.android.tictactoe;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.android.tictactoe.R;

import brown.games.Evaluation;
import brown.games.GameMove;
import brown.games.algos.MiniMaxEvaluation;
import brown.games.tictac.TicTacGameMove;
import brown.games.tictac.TicTacGameState;
import brown.games.tictac.TicTacPlayer;
import brown.games.tictac.Tile;

public class ThreeXThreePlayerVsComp extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    /**
     * Log tag
     */
    private static final String TAG = ThreeXThreePlayerVsComp.class.getSimpleName();

    private static final int EVALUATION_PLY = 2;

    protected int[] buttonId = new int[]{R.id.text00, R.id.text01, R.id.text02, R.id.text10,
            R.id.text11, R.id.text12, R.id.text20, R.id.text21, R.id.text22};

    protected Button[] tileViews = new Button[buttonId.length];
    protected TextView statusBar;
    protected Evaluation eval;
    protected TicTacPlayer human;
    protected TicTacPlayer computer;
    protected TicTacGameState state;
    protected TextView scoreForPlayer;
    protected TextView scoreForComputer;
    protected CardView resetGamePressed;
    private Map<Tile, Integer> resourceMap;
    private Map<Tile, Tile> nextTileMap;
    private Button btnPlayAgain;

    private int playerScore = 0;

    private int computerScore = 0;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3_vs_computer);

        resourceMap = new HashMap<Tile, Integer>();
        resourceMap.put(Tile.X, R.string.x);
        resourceMap.put(Tile.O, R.string.o);
        resourceMap.put(null, R.string.empty_string);

        nextTileMap = new HashMap<Tile, Tile>();
        nextTileMap.put(null, Tile.X);
        nextTileMap.put(Tile.X, Tile.O);
        nextTileMap.put(Tile.O, null);

        // TODO restorable state
        eval = new MiniMaxEvaluation(EVALUATION_PLY);
        human = new TicTacPlayer(Tile.X);
        computer = new TicTacPlayer(Tile.O);
        state = new TicTacGameState();

        statusBar = (TextView) findViewById(R.id.game_status);
        btnPlayAgain = findViewById(R.id.play_again);
        resetGamePressed = findViewById(R.id.reset_button);

        Spinner morePlayerOption = (Spinner) findViewById(R.id.more_items);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.more_play_option_comp, android.R.layout.simple_spinner_dropdown_item);
        morePlayerOption.setAdapter(adapter);
        morePlayerOption.setOnItemSelectedListener(this);

        scoreForPlayer = findViewById(R.id.x_score);
        scoreForComputer = findViewById(R.id.o_score);

        for (int i = 0; i < buttonId.length; i++) {
            int id = buttonId[i];
            Log.d(TAG, "finding id " + id);
            tileViews[i] = (Button) findViewById(id);
            tileViews[i].setOnClickListener(this);
        }

        btnPlayAgain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                playAgain();
            }
        });
        resetGamePressed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        Log.d(TAG, "onCreate: complete");
    }

    protected void playAgain() {
        for (Button tile : tileViews) {
            tile.setText(R.string.empty_string);
            tile.setClickable(true);
        }
        statusBar.setText(R.string.game_start);
        btnPlayAgain.setVisibility(View.INVISIBLE);

        state = new TicTacGameState();
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: " + v);
        Button thisButtonView = (Button) v;

        // which view am i? find index in array
        int ix = -1;
        for (int i = 0; i < buttonId.length; i++) {
            if (buttonId[i] == v.getId()) {
                ix = i;
                break;
            }
        }

        // clicked on something other than game board
        if (ix == -1) return;

        int row = ix % 3;
        int col = ix / 3;

        GameMove move = new TicTacGameMove(human.getTile(), row, col);
        if (move.isValid(state)) {
            move.execute(state);
            thisButtonView.setText(R.string.x);
            checkForGameOver();

            if (!state.isDraw() && !state.isWin()) {
                Log.d(TAG, "onClick: launching EvaluateMovesTask");
                new EvaluateMovesTask().execute();
            }
        }

    }

    protected void checkForGameOver() {
        boolean gameOver = false;

        if (state.isDraw()) {
            statusBar.setText(R.string.game_draw);
            gameOver = true;
        } else if (state.isWin()) {
            gameOver = true;
            if (state.isWinner(human)) {
                statusBar.setText(R.string.you_win);
                playerScore += 1;
                setScore(playerScore, computerScore);
            } else {
                statusBar.setText(R.string.computer_win);
                computerScore += 1;
                setScore(playerScore, computerScore);
            }
        }

        // remove onclick listeners
        if (gameOver) {
            for (int id : buttonId) {
                findViewById(id).setClickable(false);
            }
            btnPlayAgain.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (parent.getItemAtPosition(pos).equals(R.string.play_with_friend)) {
            Intent playWithFriend = new Intent(this, MainActivity.class);
            startActivity(playWithFriend);
        }
        if (parent.getItemAtPosition(pos).equals(R.string.five_five)) {
            Intent fiveXFive = new Intent(this, FiveXFiveWithHuman.class);
            startActivity(fiveXFive);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void setScore(int scoreX, int scoreO) {
        Log.d(TAG, "inside setScore");

        scoreForPlayer.setText(getString(R.string.playerX_score, scoreX));
        scoreForComputer.setText(getString(R.string.playerO_score, scoreO));
        Log.v(TAG, scoreX + "");
        Log.v(TAG, scoreO + "");
    }

    public void resetGame() {
        playAgain();

        playerScore = 0;
        computerScore = 0;

    }

    /**
     * Executes evaluation of computer move on a background thread
     *
     * @author Manuel Okeke
     * @date Apr 11, 2018
     */
    // can i make this static?
    private class EvaluateMovesTask extends AsyncTask<Void, Void, TicTacGameMove> {

        @Override
        protected void onPreExecute() {
            statusBar.setText(R.string.status_computer_thinking);
        }

        @Override
        protected TicTacGameMove doInBackground(Void... params) {
            TicTacGameMove oppMove = (TicTacGameMove) eval.bestMove(state, computer, human);
            oppMove.execute(state);

            return oppMove;
        }

        @Override
        protected void onPostExecute(TicTacGameMove result) {
            // find tile of this move
            final int id = result.getRow() + result.getColumn() * 3;
            Button oppView = (Button) findViewById(buttonId[id]);
            oppView.setText(R.string.o);

            statusBar.setText(R.string.status_your_move);

            checkForGameOver();
        }

    }


}