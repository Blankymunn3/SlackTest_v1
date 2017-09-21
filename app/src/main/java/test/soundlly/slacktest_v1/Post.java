package test.soundlly.slacktest_v1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by soundlly on 2017. 9. 21..
 */

public class Post extends AppCompatActivity {

    public static void post(String inputString, Context context) {

        RequestQueue queue = Volley.newRequestQueue(context);
        String url =  "https://hooks.slack.com/services/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";

        JSONObject jsonParam = new JSONObject();
        try {
            jsonParam.put("username","통인동커피공방");
            jsonParam.put("text", inputString);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, jsonParam, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.d("Response: ", response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(request);

    }

}
