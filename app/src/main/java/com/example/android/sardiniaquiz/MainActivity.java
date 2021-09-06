package com.example.android.sardiniaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int totalCorrectAnswer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void submit(View v) {
        Button submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(view -> {
            checkAllAnswers();
            displayToast(totalCorrectAnswer);
        });

    }


    /**
     * Check the answer on casu martzu
     */

    private void checkAnswerRadioButtonCasuMartzu() {
        RadioButton typicalCheese = findViewById(R.id.radio_casu_martzu_one);
        boolean isTypicalCheese = typicalCheese.isChecked();

        if (isTypicalCheese) {
            totalCorrectAnswer ++;
        }

    }

    /**
     * Check the answer on the nuraghe
     */

    private void checkAnswerRadioButtonNuraghe() {
        RadioButton nuraghe = findViewById(R.id.radio_nuraghe_three);
        boolean isNuraghe = nuraghe.isChecked();

        if (isNuraghe) {
            totalCorrectAnswer ++;
        }
    }

    /**
     * Check the answer on the flag
     */

    private void checkAnswerRadioButtonFlag() {
        RadioButton flag = findViewById(R.id.radio_flag_four_moors);
        boolean isFlag = flag.isChecked();

        if (isFlag) {
            totalCorrectAnswer ++;
        }
    }


    /**
     * Checks all answers in the CheckBox
     */
    private void checkAnswersCheckBox() {
        CheckBox crystalSea = findViewById(R.id.checkbox_visit_one);
        CheckBox tradition = findViewById(R.id.checkbox_visit_two);
        CheckBox food = findViewById(R.id.checkbox_visit_three);
        CheckBox women = findViewById(R.id.checkbox_visit_four);
        CheckBox porceddu = findViewById(R.id.checkbox_sardinia_dishes_porceddu);
        CheckBox bottarga = findViewById(R.id.checkbox_sardinia_dishes_bottarga);
        CheckBox carasau = findViewById(R.id.checkbox_sardinia_dishes_carasau);
        CheckBox lasagne = findViewById(R.id.checkbox_sardinia_dishes_lasagne);
        CheckBox culungiones = findViewById(R.id.checkbox_sardinia_dishes_culungiones);
        CheckBox mirto = findViewById(R.id.checkbox_sardinia_dishes_mirto);
        CheckBox pizza = findViewById(R.id.checkbox_sardinia_dishes_pizza);
        boolean isCrystalSea = crystalSea.isChecked();
        boolean isTradition = tradition.isChecked();
        boolean isFood = food.isChecked();
        boolean isWomen = women.isChecked();
        boolean isPorceddu = porceddu.isChecked();
        boolean isBottarga = bottarga.isChecked();
        boolean isCarasau = carasau.isChecked();
        boolean isLasagne = lasagne.isChecked();
        boolean isCulungiones = culungiones.isChecked();
        boolean isMirto = mirto.isChecked();
        boolean isPizza = pizza.isChecked();

        if (isCrystalSea && isTradition && isFood && !isWomen) {
            totalCorrectAnswer ++;
        }
        if (isPorceddu && isBottarga && isCarasau && !isLasagne && isCulungiones && isMirto && !isPizza) {
            totalCorrectAnswer ++;
        }
    }

    /**
     * Check the answer to the question if sardinia is an island
     */
    private void checkAnswerEditText() {
        EditText sardiniaIsland = findViewById(R.id.sardinia_island);
        String answerInTextString = sardiniaIsland.getText().toString();

        if (answerInTextString.trim().equalsIgnoreCase("Yes")) {
            totalCorrectAnswer ++;
        }

    }

    /**
     * Groups all checking's methods
     */

    private void checkAllAnswers() {
        checkAnswerRadioButtonCasuMartzu();
        checkAnswerRadioButtonNuraghe();
        checkAnswerRadioButtonFlag();
        checkAnswersCheckBox();
        checkAnswerEditText();
    }

    private void resetCounter() {
        totalCorrectAnswer = 0;
    }

    /**
     * Creates the text to be displayed according to the score obtained
     *
     * @param totalCorrectAnswer the total number of accumulated points.
     */
    private void displayToast(int totalCorrectAnswer) {
        int duration = Toast.LENGTH_LONG;
        String message = "Your score: " + totalCorrectAnswer + "/6";

        if (totalCorrectAnswer == 0) {
            message += "\nCome on, you can do it!\nDon't give up!";
        } else if (totalCorrectAnswer == 1) {
            message += "\nWell begun is half done!";
        } else if (totalCorrectAnswer == 2) {
            message += "\nI'm cheering for you";
        } else if (totalCorrectAnswer == 3) {
            message += "\nNot bad but you can improve";
        } else if (totalCorrectAnswer == 4) {
            message += "\nAlmost done!";
        } else if (totalCorrectAnswer == 5) {
            message += "\nYou are almost at the finish line";
        } else if (totalCorrectAnswer == 6) {
            message += "\nAwesome\nYou have a Sardinia soul!";
        }

        Toast.makeText(MainActivity.this, message, duration).show();
        resetCounter();

    }


}