package ca.josephmendez.mode4201.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * TicTacToe:
 * Used advanced logic to develop a friendly two player game.
 * @author Joseph Mendez
 * @since 0.1
 * @version 0.1
 */
public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvOutPut = (TextView) findViewById(R.id.txtView);
        /**
         * Button: N
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnN = (Button) findViewById(R.id.btnN);
        btnN.setTextSize(1,55);
        /**
         * Button: NW
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnNW = (Button) findViewById(R.id.btnNW);
        btnNW.setTextSize(1,55);
        /**
         * Button: NE
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnNE = (Button) findViewById(R.id.btnNE);
        btnNE.setTextSize(1,55);
        /**
         * Button: S
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnS = (Button) findViewById(R.id.btnS);
        btnS.setTextSize(1,55);
        /**
         * Button: SW
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnSW = (Button) findViewById(R.id.btnSW);
        btnSW.setTextSize(1,55);
        /**
         * Button: SE
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnSE = (Button) findViewById(R.id.btnSE);
        btnSE.setTextSize(1,55);
        /**
         * Button: E
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnE = (Button) findViewById(R.id.btnE);
        btnE.setTextSize(1,55);
        /**
         * Button: W
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnW = (Button) findViewById(R.id.btnW);
        btnW.setTextSize(1,55);
        /**
         * Button: NESW
         * This is to find the ID created using activity_main.xml Design windpane properties window.
         */
        Button btnNESW = (Button) findViewById(R.id.btnNESW);
        btnNESW.setTextSize(1,55);

        btnN.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setN(true, v);
            }
        });
        btnE.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setE(true,v);
            }
        });
        btnNE.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setNE(true,v);
            }
        });
        btnNESW.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setNESW(true,v);
            }
        });
        btnNW.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setNW(true,v);
            }
        });
        btnS.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setS(true,v);
            }
        });
        btnSW.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSW(true,v);
            }
        });
        btnSE.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setSE(true,v);
            }
        });
        btnW.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setW(true,v);
            }
        });

        //https://www.youtube.com/watch?v=RCyuqMVGl4g
        tvOutPut.setText(currentTurnOrder() + " turn it is.");
    }

    /**
     * Indicator for top left button
     */
    private boolean NW = false;
    /**
     * indicator for top middle button
     */
    private boolean N = false;
    /**
     * indicator for top right button
     */
    private boolean NE = false;
    /**
     * indicator for right middle button
     */
    private boolean E = false;
    /**
     * indicator for bottom right button
     */
    private boolean SE = false;
    /**
     * indicator for bottom middle button
     */
    private boolean S = false;
    /**
     * indicator for bottom left button
     */
    private boolean SW = false;
    /**
     * indicator for left middle button
     */
    private boolean W = false;
    /**
     * indicator for absoulte middle button
     */
    private boolean NESW = false;
    /**
     * indicator of which turn order
     * True: indicates -X-
     * False: indicates -O-
     */
    private boolean theTurn = false;

    public static final String go = "#";


    public void setE(boolean e, View myButton) {
        E = e;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMyE(turnOrder());
        ((Button) myButton).setText(getMyE());
        checkGame();
    }

    public boolean isE() {
        return E;
    }

    public void setN(boolean n, View myButton) {
        N = n;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMyN(turnOrder());
        ((Button) myButton).setText(getMyN());
        checkGame();
    }

    public void setNE(boolean NE, View myButton) {
        this.NE = NE;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMyNE(turnOrder());
        ((Button) myButton).setText(getMyNE());
        checkGame();
    }

    public void setNESW(boolean NESW, View myButton) {
        this.NESW = NESW;
        Button button=(Button) myButton;
        if (button.getText().equals(go))
        {
            setDefaults();
        }
        else
        {
            button.setEnabled(false);
            setMyNESW(turnOrder());
            ((Button) myButton).setText(getMyNESW());
            checkGame();
        }
    }

    public void setNW(boolean NW, View myButton) {
        this.NW = NW;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMyNW(turnOrder());
        ((Button) myButton).setText(getMyNW());
        checkGame();
    }

    public void setS(boolean s, View myButton) {
        S = s;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMyS(turnOrder());
        ((Button) myButton).setText(getMyS());
        checkGame();
    }

    public void setSE(boolean SE, View myButton) {
        this.SE = SE;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMySE(turnOrder());
        ((Button) myButton).setText(getMySE());
        checkGame();
    }

    public void setSW(boolean SW, View myButton) {
        this.SW = SW;
        Button button = (Button) myButton;
        button.setEnabled(false);
        setMySW(turnOrder());
        ((Button) myButton).setText(getMySW());
        checkGame();
    }

    public void setW(boolean w, View myButton) {
        W = w;
        Button button=(Button) myButton;
        button.setEnabled(false);
        setMyW(turnOrder());
        ((Button) myButton).setText(getMyW());
        checkGame();
    }
    public void setW(boolean w) {
        W = w;
    }

    public void setE(boolean e) {
        E = e;
    }

    public void setN(boolean n) {
        N = n;
    }

    public void setS(boolean s) {
        S = s;
    }

    public void setNE(boolean NE) {
        this.NE = NE;
    }

    public void setNW(boolean NW) {
        this.NW = NW;
    }

    public void setSE(boolean SE) {
        this.SE = SE;
    }

    public void setSW(boolean SW) {
        this.SW = SW;
    }

    public void setNESW(boolean NESW) {
        this.NESW = NESW;
    }


    public boolean isN() {
        return N;
    }

    public boolean isNE() {
        return NE;
    }

    public boolean isNESW() {
        return NESW;
    }

    public boolean isNW() {
        return NW;
    }

    public boolean isS() {
        return S;
    }

    public boolean isSE() {
        return SE;
    }

    public boolean isSW() {
        return SW;
    }

    public boolean isW() {
        return W;
    }

    private String myNW = "";
    private String myNE = "";
    private String myN = "";
    private String myE = "";
    private String mySE = "";
    private String myS = "";
    private String mySW = "";
    private String myW = "";
    private String myNESW = "";

    public void setMyE(String myE) {
        this.myE = myE;
    }

    public void setMyN(String myN) {
        this.myN = myN;
    }

    public void setMyNE(String myNE) {
        this.myNE = myNE;
    }

    public void setMyNESW(String myNESW) {
        this.myNESW = myNESW;
    }

    public void setMyNW(String myNW) {
        this.myNW = myNW;
    }

    public void setMyS(String myS) {
        this.myS = myS;
    }

    public void setMySE(String mySE) {
        this.mySE = mySE;
    }

    public void setMySW(String mySW) {
        this.mySW = mySW;
    }

    public void setMyW(String myW) {
        this.myW = myW;
    }

    public String getMyE() {
        return myE;
    }

    public String getMyN() {
        return myN;
    }

    public String getMyNE() {
        return myNE;
    }

    public String getMyNESW() {
        return myNESW;
    }

    public String getMyNW() {
        return myNW;
    }

    public String getMyS() {
        return myS;
    }

    public String getMySE() {
        return mySE;
    }

    public String getMySW() {
        return mySW;
    }

    public String getMyW() {
        return myW;
    }

    private boolean checkPlayer(String type)
    {
        boolean isWon = false;
        switch (type)
        {
            case "Right":
                if (getMyE().equals(getMyNE()) && getMyE().equals(getMySE()))
                {
                    isWon = true;
                    gameWin(getMyE());
                    setWinner(getMyE());
                }
                break;
            case "Left":
                if (getMyW().equals(getMyNW()) && getMyW().equals(getMySW()))
                {
                    isWon = true;
                    gameWin(getMyW());
                    setWinner(getMyW());
                }
                break;
            case "Bottom":
                if (getMyS().equals(getMySE()) && getMyS().equals(getMySW()))
                {
                    isWon = true;
                    gameWin(getMyS());
                    setWinner(getMyS());
                }
                break;
            case "Top":
                if (getMyN().equals(getMyNE()) && getMyN().equals(getMyNW()))
                {
                    isWon = true;
                    gameWin(getMyN());
                    setWinner(getMyN());
                }
                break;
            case "Down":
                if (getMyNESW().equals(getMyN()) && getMyNESW().equals(getMyS()))
                {
                    isWon = true;
                    gameWin(getMyNESW());
                    setWinner(getMyNESW());
                }
                break;
            case "Forward":
                if (getMyNESW().equals(getMyE()) && getMyNESW().equals(getMyW()))
                {
                    isWon = true;
                    gameWin(getMyNESW());
                    setWinner(getMyNESW());
                }
                break;
            case "Slash":
                if (getMyNESW().equals(getMyNW()) && getMyNESW().equals(getMySE()))
                {
                    isWon = true;
                    gameWin(getMyNESW());
                    setWinner(getMyNESW());
                }
                break;
            case "Block":
                if (getMyNESW().equals(getMyNE()) && getMyNESW().equals(getMySW()))
                {
                    isWon = true;
                    gameWin(getMyNESW());
                    setWinner(getMyNESW());
                }
                break;
            default:
                isWon = false;
                break;
        }
        return isWon;
    }
    private void checkGame()
    {
        boolean isWon = false;
        if (isNE() && isN() && isNE() && !isWon)
        {
            isWon = checkPlayer("Top");
        }
        if (isNE() && isE() && isSE() && !isWon)
        {
            isWon = checkPlayer("Right");
        }
        if (isSE() && isS() && isSW() && !isWon)
        {
            isWon = checkPlayer("Bottom");
        }
        if (isW() && isSW() && isNW() && !isWon)
        {
            isWon = checkPlayer("Left");
        }
        if (isN() && isNESW() && isS() && !isWon)
        {
            isWon = checkPlayer("Down");
        }
        if (isW() && isNESW() && isE() && !isWon)
        {
            isWon = checkPlayer("Forward");
        }
        if (isNW() && isNESW() && isSE() && !isWon)
        {
            isWon = checkPlayer("Slash");
        }
        if (isNE() && isNESW() && isSW() && !isWon)
        {
            isWon = checkPlayer("Block");
        }

        if (!isWon)
        {
            resetGame();
        }
    }

    public boolean isTheTurn() {
        return theTurn;
    }

    public void setTheTurn(boolean theTurn) {
        this.theTurn = theTurn;
    }

    protected String currentTurnOrder()
    {
        String turn = "";

        if (isTheTurn())
        {
            turn = "0";
        }
        else
        {
            turn = "X";
        }
        return turn;
    }
    private String turnOrder()
    {
        String turn = "";

        if (isTheTurn())
        {
            turn = "X";
            setTheTurn(false);
        }
        else
        {
            turn = "O";
            setTheTurn(true);
        }
        return turn;
    }
    //https://www.youtube.com/watch?v=0RLWnSG5AkU
    public void gameWin(String winner)
    {
        final TextView txtWinner = (TextView) findViewById(R.id.txtView);
        txtWinner.setText("The last winner is: \t" + winner);
    }

    public void setDefaults()
    {
        Button btnN = (Button) findViewById(R.id.btnN);
        btnN.setEnabled(true);
        btnN.setText(" ");
        setN(false);
        setMyN("");
        Button btnNW = (Button) findViewById(R.id.btnNW);
        btnNW.setEnabled(true);
        btnNW.setText(" ");
        setNW(false);
        setMyNW("");
        Button btnNE = (Button) findViewById(R.id.btnNE);
        btnNE.setEnabled(true);
        btnNE.setText(" ");
        setNE(false);
        setMyNE("");
        Button btnS = (Button) findViewById(R.id.btnS);
        btnS.setEnabled(true);
        btnS.setText(" ");
        setS(false);
        setMyS("");
        Button btnSW = (Button) findViewById(R.id.btnSW);
        btnSW.setEnabled(true);
        btnSW.setText(" ");
        setSW(false);
        setMySW("");
        Button btnSE = (Button) findViewById(R.id.btnSE);
        btnSE.setEnabled(true);
        btnSE.setText(" ");
        setSE(false);
        setMySE("");
        Button btnE = (Button) findViewById(R.id.btnE);
        btnE.setEnabled(true);
        btnE.setText(" ");
        setE(false);
        setMyE("");
        Button btnW = (Button) findViewById(R.id.btnW);
        btnW.setEnabled(true);
        btnW.setText(" ");
        setW(false);
        setMyW("");
        Button btnNESW = (Button) findViewById(R.id.btnNESW);
        btnNESW.setEnabled(true);
        btnNESW.setText(" ");
        setNESW(false);
        setMyNESW("");
    }

    public void setWinner(String winner)
    {
        Button btnN = (Button) findViewById(R.id.btnN);
        btnN.setEnabled(false);
        btnN.setText(winner);
        setN(false);
        setMyN("");
        Button btnNW = (Button) findViewById(R.id.btnNW);
        btnNW.setEnabled(false);
        btnNW.setText(winner);
        setNW(false);
        setMyNW("");
        Button btnNE = (Button) findViewById(R.id.btnNE);
        btnNE.setEnabled(false);
        btnNE.setText(winner);
        setNE(false);
        setMyNE("");
        Button btnS = (Button) findViewById(R.id.btnS);
        btnS.setEnabled(false);
        btnS.setText(winner);
        setS(false);
        setMyS("");
        Button btnSW = (Button) findViewById(R.id.btnSW);
        btnSW.setEnabled(false);
        btnSW.setText(winner);
        setSW(false);
        setMySW(" ");
        Button btnSE = (Button) findViewById(R.id.btnSE);
        btnSE.setEnabled(false);
        btnSE.setText(winner);
        setSE(false);
        setMySE(" ");
        Button btnE = (Button) findViewById(R.id.btnE);
        btnE.setEnabled(false);
        btnE.setText(winner);
        setE(false);
        setMyE(" ");
        Button btnW = (Button) findViewById(R.id.btnW);
        btnW.setEnabled(false);
        btnW.setText(winner);
        setW(false);
        setMyW(" ");
        Button btnNESW = (Button) findViewById(R.id.btnNESW);
        btnNESW.setEnabled(true);
        btnNESW.setText(go);
        setNESW(false);
        setMyNESW(" ");
    }

    public void resetGame()
    {
        if (isNESW() && isNE() && isN() && isW() && isSE() &&
                isS() && isSW() && isNW() && isE())
        {
            gameDraw();
            setDefaults();
        }
    }

    public void gameDraw()
    {
        final TextView txtWinner = (TextView) findViewById(R.id.txtView);
        txtWinner.setText("The last game is Drawn!");
    }
}
