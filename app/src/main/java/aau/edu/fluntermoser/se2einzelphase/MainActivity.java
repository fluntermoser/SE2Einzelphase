package aau.edu.fluntermoser.se2einzelphase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPalindrom(View view) {
        EditText editText = (EditText) findViewById(R.id.palindromeText);
        String text = editText.getText().toString();

        if(text.isEmpty() || text.length() == 0 || text == null) {
            writeMessage(R.string.errorEmptyString);
        } else if (text.length() < 5) {
            writeMessage(R.string.errorStringToShort);
        }
        else if(isPalindrome(text)) {
            writeMessage(R.string.stringsIsPalindrome);
        } else {
            writeMessage(R.string.stringIsNotPalindrome);
        }

    }

    public void writeMessage(int resourceId) {
        String message = getResources().getText(resourceId).toString();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast.makeText(context, message, duration).show();
        TextView resultView = findViewById(R.id.resultText);
        resultView.setText(message);
    }

    public static boolean isPalindrome(String str)	{
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
