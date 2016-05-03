package ir.mbaas.acratest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.acra.ACRA;
import org.acra.config.ACRAConfiguration;
import org.acra.config.ConfigurationBuilder;

import java.io.IOException;
import java.io.InvalidClassException;
import java.util.InputMismatchException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText uriET;
    EditText idET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.exc_btn1);
        Button btn2 = (Button) findViewById(R.id.exc_btn2);
        Button btn3 = (Button) findViewById(R.id.exc_btn3);
        Button btn4 = (Button) findViewById(R.id.exc_btn4);
        Button btn5 = (Button) findViewById(R.id.exc_btn5);
        Button btn6 = (Button) findViewById(R.id.exc_btn6);
        Button btn7 = (Button) findViewById(R.id.exc_btn7);
        Button btn8 = (Button) findViewById(R.id.exc_btn8);

        uriET = (EditText) findViewById(R.id.et_uri);
        idET  = (EditText) findViewById(R.id.et_id);
        idET.setText(PrefUtil.getString(this, PrefUtil.ACRA_MBAAS_ID, ""));

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String acraID = idET.getText().toString();

        if (acraID.isEmpty()) {
            String title = getResources().getString(R.string.error_title);
            String msg = getResources().getString(R.string.invalid_id_msg);
            CustomDialogs.showErrorAlert(this, title, msg);
            return;
        }

        String formUri = uriET.getText().toString() + "/" + acraID;

        PrefUtil.putString(this, PrefUtil.ACRA_MBAAS_ID, acraID);

        ACRAConfiguration config = new ConfigurationBuilder(getApplication()).setFormUri(formUri).build();
        ACRA.init(getApplication(), config);

        switch (v.getId()) {
            case R.id.exc_btn1:
                throw new NullPointerException();
            case R.id.exc_btn2:
                throw new IndexOutOfBoundsException();
            case R.id.exc_btn3:
                throw new InputMismatchException();
            case R.id.exc_btn4:
                throw new IllegalStateException();
            case R.id.exc_btn5:
                throw new IllegalThreadStateException();
            case R.id.exc_btn6:
                throw new InputMismatchException("Input Mismatch");
            case R.id.exc_btn7:
                throw new ArithmeticException();
            case R.id.exc_btn8:
                throw new RuntimeException();
        }
    }
}
