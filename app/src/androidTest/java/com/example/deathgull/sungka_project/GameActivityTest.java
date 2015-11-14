package com.example.deathgull.sungka_project;

import android.content.Intent;
import android.os.Bundle;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.util.Log;

import helpers.frontend.CupButton;

/**
 * Test the game activity.
 */
public class GameActivityTest extends ActivityInstrumentationTestCase2<GameActivity> {
    private GameActivity activity;
    private static final String TAG = "GameActivity";

    public GameActivityTest() {
        super(GameActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Bundle bundle = new Bundle();
        bundle.putString(GameActivity.PLAYER_ONE, "Player One");
        bundle.putString(GameActivity.PLAYER_TWO, "Player Two");
        bundle.putBoolean("is_test", true);

        Intent intent = new Intent();
        intent.putExtras(bundle);
        setActivityIntent(intent);

        setActivityInitialTouchMode(true);

        activity = getActivity();

        // TODO will need to change things when first player is no longer fixed
    }

    private void waitForAnimations() {
        boolean animationRunning = true;

        /*try {
            Thread.sleep(1000, 0);
        } catch (InterruptedException e) {
            Log.d(TAG, "thread failed to sleep");
        }*/

        while (animationRunning) {
            getInstrumentation().waitForIdleSync();
            if (activity.animationFinished()) {
                animationRunning = false;
            }
        }
    }

    /**
     * Make sure that the GameActivity is being created properly.
     */
    /*public void testActivityExists() {
        assertNotNull(activity);
    }

    *//**
     * Make sure that the CupButtons are being made properly.
     *//*
    public void testCupsExist() {
        CupButton cup1_1 = (CupButton) activity.findViewById(R.id.cup1_1);
        CupButton cup1_2 = (CupButton) activity.findViewById(R.id.cup1_2);
        CupButton cup1_3 = (CupButton) activity.findViewById(R.id.cup1_3);
        CupButton cup1_4 = (CupButton) activity.findViewById(R.id.cup1_4);
        CupButton cup1_5 = (CupButton) activity.findViewById(R.id.cup1_5);
        CupButton cup1_6 = (CupButton) activity.findViewById(R.id.cup1_6);
        CupButton cup1_7 = (CupButton) activity.findViewById(R.id.cup1_7);
        CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);
        CupButton cup2_1 = (CupButton) activity.findViewById(R.id.cup2_1);
        CupButton cup2_2 = (CupButton) activity.findViewById(R.id.cup2_2);
        CupButton cup2_3 = (CupButton) activity.findViewById(R.id.cup2_3);
        CupButton cup2_4 = (CupButton) activity.findViewById(R.id.cup2_4);
        CupButton cup2_5 = (CupButton) activity.findViewById(R.id.cup2_5);
        CupButton cup2_6 = (CupButton) activity.findViewById(R.id.cup2_6);
        CupButton cup2_7 = (CupButton) activity.findViewById(R.id.cup2_7);
        CupButton cup2_store = (CupButton) activity.findViewById(R.id.cup2_store);

        assertNotNull(cup1_store);
        assertNotNull(cup2_store);
        assertNotNull(cup1_1);
        assertNotNull(cup1_2);
        assertNotNull(cup1_3);
        assertNotNull(cup1_4);
        assertNotNull(cup1_5);
        assertNotNull(cup1_6);
        assertNotNull(cup1_7);
        assertNotNull(cup2_1);
        assertNotNull(cup2_2);
        assertNotNull(cup2_3);
        assertNotNull(cup2_4);
        assertNotNull(cup2_5);
        assertNotNull(cup2_6);
        assertNotNull(cup2_7);
    }

    *//**
     * Make sure that stores are initiated with 0 shells inside.
     *//*
    public void testStoreInit() {
        CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);
        CupButton cup2_store = (CupButton) activity.findViewById(R.id.cup2_store);

        assertEquals("0", cup1_store.getText().toString());
        assertEquals("0", cup2_store.getText().toString());
    }

    *//**
     * Make sure that ShellCups are being initiated with the correct number of shells inside.
     *//*
    public void testCupInit() {
        CupButton cup1_1 = (CupButton) activity.findViewById(R.id.cup1_1);
        CupButton cup1_7 = (CupButton) activity.findViewById(R.id.cup1_7);
        CupButton cup2_1 = (CupButton) activity.findViewById(R.id.cup2_1);
        CupButton cup2_7 = (CupButton) activity.findViewById(R.id.cup2_7);

        // testing every cup is overkill. They're made in a loop so let's just check
        // the first and last ones to be made
        assertEquals("7", cup1_1.getText().toString());
        assertEquals("7", cup1_7.getText().toString());
        assertEquals("7", cup2_1.getText().toString());
        assertEquals("7", cup2_7.getText().toString());
    }*/

    /**
     * Make sure that regular move behaviour is working properly - i.e. does the selected cup
     * end up being empty, and have a number of cups equal to the number of shells picked up
     * had their shell count incremented by 1?
     */
    public void testCupMove() {
        CupButton cup1_4 = (CupButton) activity.findViewById(R.id.cup1_4);
        CupButton cup1_5 = (CupButton) activity.findViewById(R.id.cup1_5);
        CupButton cup1_6 = (CupButton) activity.findViewById(R.id.cup1_6);
        CupButton cup1_7 = (CupButton) activity.findViewById(R.id.cup1_7);
        CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);
        CupButton cup2_1 = (CupButton) activity.findViewById(R.id.cup2_1);
        CupButton cup2_2 = (CupButton) activity.findViewById(R.id.cup2_2);
        CupButton cup2_3 = (CupButton) activity.findViewById(R.id.cup2_3);
        CupButton cup2_4 = (CupButton) activity.findViewById(R.id.cup2_4);

        TouchUtils.clickView(this, cup1_4);

        waitForAnimations();
//        getInstrumentation().waitForIdleSync();

        assertEquals("0", cup1_4.getText().toString());
        assertEquals("8", cup1_5.getText().toString());
        assertEquals("8", cup1_6.getText().toString());
        assertEquals("8", cup1_7.getText().toString());
        assertEquals("1", cup1_store.getText().toString());
        assertEquals("8", cup2_1.getText().toString());
        assertEquals("8", cup2_2.getText().toString());
        assertEquals("8", cup2_3.getText().toString());
        assertEquals("7", cup2_4.getText().toString());
    }

    /**
     * As above, but in this case we are interested in whether the opponent's store was
     * skipped over when dropping shells.
     */
    /*public void testCupMove2() {
        final CupButton cup1_7 = (CupButton) activity.findViewById(R.id.cup1_7);
        CupButton cup2_store = (CupButton) activity.findViewById(R.id.cup2_store);
        CupButton cup1_1 = (CupButton) activity.findViewById(R.id.cup1_1);
        CupButton cup1_2 = (CupButton) activity.findViewById(R.id.cup1_2);

        // set cup1_7 to have 9 shells
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_7.addShellImages(activity, 2);
            }
        });
        getInstrumentation().waitForIdleSync();

        TouchUtils.clickView(this, cup1_7);

        waitForAnimations();

        assertEquals("0", cup2_store.getText().toString());
        assertEquals("8", cup1_1.getText().toString());
        assertEquals("7", cup1_2.getText().toString());
    }

    *//**
     * Make sure that when the last shell drops in the player's store, the opponent cannot
     * make a move, but the original player can.
     *//*
    public void testPlayerGetsAnotherMove() {
        CupButton cup1_1 = (CupButton) activity.findViewById(R.id.cup1_1);
        CupButton cup2_3 = (CupButton) activity.findViewById(R.id.cup2_3);
        CupButton cup1_4 = (CupButton) activity.findViewById(R.id.cup1_4);

        TouchUtils.clickView(this, cup1_1);
        waitForAnimations();

        // no move should happen
        TouchUtils.clickView(this, cup2_3);
        waitForAnimations();

        assertEquals("7", cup2_3.getText().toString());

        TouchUtils.clickView(this, cup1_4);
        waitForAnimations();

        assertEquals("0", cup1_4.getText().toString());
    }

    *//**
     * Make sure that when the last shell drops in an empty cup belonging to the player, that
     * shell plus the shells in the cup opposite are transferred into the store.
     *//*
    public void testRobOpponent() {
        final CupButton cup1_3 = (CupButton) activity.findViewById(R.id.cup1_3);
        final CupButton cup1_5 = (CupButton) activity.findViewById(R.id.cup1_5);
        CupButton cup2_3 = (CupButton) activity.findViewById(R.id.cup2_5);
        CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);

        // set cup1_3 to have 2 shells
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_3.removeAllShells();
            }
        });
        getInstrumentation().waitForIdleSync();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_3.addShellImages(activity, 2);
            }
        });
        getInstrumentation().waitForIdleSync();

        // set cup1_5 to be empty
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_5.removeAllShells();
            }
        });
        getInstrumentation().waitForIdleSync();

        TouchUtils.clickView(this, cup1_3);
        waitForAnimations();

        assertEquals("8", cup1_store.getText().toString());
        assertEquals("0", cup1_5.getText().toString());
        assertEquals("0", cup2_3.getText().toString());
    }

    *//**
     * As above, but the initiating and ending cup are the same.
     *//*
    public void testRobOpponent2() {
        final CupButton cup1_3 = (CupButton) activity.findViewById(R.id.cup1_3);
        CupButton cup2_5 = (CupButton) activity.findViewById(R.id.cup2_5);
        CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);

        // set cup1_3 to have 15 shells
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_3.addShellImages(activity, 8);
            }
        });
        getInstrumentation().waitForIdleSync();

        TouchUtils.clickView(this, cup1_3);
        waitForAnimations();
//        getInstrumentation().waitForIdleSync();

        assertEquals("0", cup2_5.getText().toString());
        assertEquals("0", cup1_3.getText().toString());
        assertEquals("10", cup1_store.getText().toString());
    }

    *//**
     * Make sure that when all of the shell cups belonging to one player are empty, the other
     * player can keep moving.
     *//*
    public void testCupsEmptyExtraMove() {
        final CupButton cup1_1 = (CupButton) activity.findViewById(R.id.cup1_1);
        final CupButton cup1_2 = (CupButton) activity.findViewById(R.id.cup1_2);
        final CupButton cup1_3 = (CupButton) activity.findViewById(R.id.cup1_3);
        final CupButton cup1_7 = (CupButton) activity.findViewById(R.id.cup1_7);
        final CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);
        final CupButton cup2_1 = (CupButton) activity.findViewById(R.id.cup2_1);
        final CupButton cup2_2 = (CupButton) activity.findViewById(R.id.cup2_2);
        final CupButton cup2_3 = (CupButton) activity.findViewById(R.id.cup2_3);
        final CupButton cup2_4 = (CupButton) activity.findViewById(R.id.cup2_4);
        final CupButton cup2_5 = (CupButton) activity.findViewById(R.id.cup2_5);
        final CupButton cup2_6 = (CupButton) activity.findViewById(R.id.cup2_6);
        final CupButton cup2_7 = (CupButton) activity.findViewById(R.id.cup2_7);
        final CupButton cup2_store = (CupButton) activity.findViewById(R.id.cup2_store);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup2_1.removeAllShells();
                cup2_2.removeAllShells();
                cup2_3.removeAllShells();
                cup2_4.removeAllShells();
                cup2_5.removeAllShells();
                cup2_6.removeAllShells();
                cup2_7.removeAllShells();
                cup2_store.addShellImages(activity, 20);
                cup1_store.addShellImages(activity, 20);
                cup1_1.removeAllShells();
                cup1_2.removeAllShells();
                cup1_3.removeAllShells();
            }
        });
        getInstrumentation().waitForIdleSync();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_1.addShellImages(activity, 6);
                cup1_2.addShellImages(activity, 4);
                cup1_3.addShellImages(activity, 2);
            }
        });
        getInstrumentation().waitForIdleSync();

        TouchUtils.clickView(this, cup1_1);
        waitForAnimations();

        TouchUtils.clickView(this, cup1_2);
        waitForAnimations();

        TouchUtils.clickView(this, cup1_3);
        waitForAnimations();

        assertEquals("0", cup1_1.getText().toString());
        assertEquals("0", cup1_2.getText().toString());
        assertEquals("0", cup1_3.getText().toString());
        assertEquals("10", cup1_7.getText().toString());
    }

    *//**
     * Make sure that when a move that ends in a store (normally giving that player another turn)
     * leaves all other shell cups empty, the turn transfers to the other player.
     *//*
    public void testCupsEmptyNoExtraMove() {
        final CupButton cup1_1 = (CupButton) activity.findViewById(R.id.cup1_1);
        final CupButton cup1_2 = (CupButton) activity.findViewById(R.id.cup1_2);
        final CupButton cup1_3 = (CupButton) activity.findViewById(R.id.cup1_3);
        final CupButton cup1_4 = (CupButton) activity.findViewById(R.id.cup1_4);
        final CupButton cup1_5 = (CupButton) activity.findViewById(R.id.cup1_5);
        final CupButton cup1_6 = (CupButton) activity.findViewById(R.id.cup1_6);
        final CupButton cup1_7 = (CupButton) activity.findViewById(R.id.cup1_7);
        final CupButton cup1_store = (CupButton) activity.findViewById(R.id.cup1_store);
        final CupButton cup2_store = (CupButton) activity.findViewById(R.id.cup2_store);
        CupButton cup2_1 = (CupButton) activity.findViewById(R.id.cup2_1);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup2_store.addShellImages(activity, 20);
                cup1_store.addShellImages(activity, 20);
                cup1_1.removeAllShells();
                cup1_2.removeAllShells();
                cup1_3.removeAllShells();
                cup1_4.removeAllShells();
                cup1_5.removeAllShells();
                cup1_6.removeAllShells();
                cup1_7.removeAllShells();
            }
        });
        getInstrumentation().waitForIdleSync();

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cup1_7.addShellImages(activity, 1);
            }
        });
        getInstrumentation().waitForIdleSync();

        TouchUtils.clickView(this, cup1_7);
        waitForAnimations();

        TouchUtils.clickView(this, cup2_1);
        waitForAnimations();

        assertEquals("0", cup2_1.getText().toString());
    }*/

    // TODO: game over
}
