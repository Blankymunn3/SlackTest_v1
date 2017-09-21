package test.soundlly.slacktest_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.EtInput)
    EditText mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);
    }

    @OnClick(R.id.SendButton)
    public void OnSend(){
        String inputString = mEtInput.getText().toString();
        if (!inputString.isEmpty()){
            Post.post(inputString, MainActivity.this);
        }else Toast.makeText(MainActivity.this, "Empty text field, nothing to post.", Toast.LENGTH_SHORT).show();
    }


}
