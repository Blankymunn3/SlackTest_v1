package test.soundlly.slacktest_v1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
            post(inputString);
        }else Toast.makeText(MainActivity.this, "Empty text field, nothing to post.", Toast.LENGTH_SHORT).show();
    }

    private void post(String inputString) {

        RequestQueue queue = Volley.newRequestQueue(this);
        String url =  "https://hooks.slack.com/services/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";

        //Create JSONObject here
        JSONObject jsonParam = new JSONObject();
        try {
            jsonParam.put("text", inputString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*
         *JSONObjectRequest using Android Volley lib
         */

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonParam, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                Toast.makeText(MainActivity.this,"test",Toast.LENGTH_SHORT).show();
                Log.d("Response: ", response.toString());
                Toast.makeText(MainActivity.this, "Posted Successfully", Toast.LENGTH_LONG).show();
                mEtInput.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace(); //print error response in logs
            }
        });

        //add to request queue, if queue is empty, will be executed immediately
        //otherwise synchronous behaviour portrayed
        queue.add(request);

    }

}
