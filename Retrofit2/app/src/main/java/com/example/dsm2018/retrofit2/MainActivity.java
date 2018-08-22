package com.example.dsm2018.retrofit2;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "MainActivity";
    TextView bodyResultTextView;
    TextView codeResultTextView;
    TextView idResultTextView;
    TextView useridResultTextView;
    TextView titleResultTextView;

    Button get1;
    Button get2;
    Button post;
    Button put;
    Button patch;
    Button delete;

    RetroClient retroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bodyResultTextView = findViewById (R.id.body_result);
        codeResultTextView = findViewById (R.id.code_result);
        idResultTextView = findViewById (R.id.id_result);
        useridResultTextView = findViewById(R.id.userid_result);
        titleResultTextView = findViewById(R.id.title_result);
        get1 = findViewById(R.id.get1);
        get2 = findViewById(R.id.get2);
        post = findViewById(R.id.post);
        put = findViewById(R.id.put);
        patch = findViewById(R.id.patch);
        delete = findViewById(R.id.delete);

        retroClient = RetroClient.getInstance(this).createBaseApi();

        init();
    }

    private void init() {
        get1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "GET 1 Clicked", Toast.LENGTH_SHORT).show();
                retroClient.getFirst("1", new RetroCallback() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(LOG, t.toString());
                        codeResultTextView.setText("Error");
                        idResultTextView.setText("Error");
                        titleResultTextView.setText("Error");
                        useridResultTextView.setText("Error");
                        bodyResultTextView.setText("Error");
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        ResponseGet data = (ResponseGet) receivedData;
                        codeResultTextView.setText(String.valueOf(code));
                        idResultTextView.setText(String.valueOf(data.id));
                        titleResultTextView.setText(data.title);
                        useridResultTextView.setText(String.valueOf(data.userId));
                        bodyResultTextView.setText(data.body);
                    }

                    @Override
                    public void onFailure(int code) {
                        codeResultTextView.setText(code);
                        idResultTextView.setText("Failure");
                        titleResultTextView.setText("Failure");
                        useridResultTextView.setText("Failure");
                        bodyResultTextView.setText("Failure");
                    }
                });
            }
        });

        get2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "GET 2 Clicked", Toast.LENGTH_SHORT).show();
                retroClient.getSecond("1", new RetroCallback() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(LOG, t.toString());
                        codeResultTextView.setText("Error");
                        idResultTextView.setText("Error");
                        titleResultTextView.setText("Error");
                        useridResultTextView.setText("Error");
                        bodyResultTextView.setText("Error");
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        List<ResponseGet> data = (List<ResponseGet>) receivedData;
                        codeResultTextView.setText(String.valueOf(code));
                        if (!data.isEmpty()) {
                            idResultTextView.setText(String.valueOf(data.get(0).id));
                            titleResultTextView.setText(data.get(0).title);
                            useridResultTextView.setText(String.valueOf(data.get(0).userId));
                            bodyResultTextView.setText(data.get(0).body);
                        } else {
                            idResultTextView.setText("Empty");
                            titleResultTextView.setText("Empty");
                            useridResultTextView.setText("Empty");
                            bodyResultTextView.setText("Empty");
                        }
                    }

                    @Override
                    public void onFailure(int code) {
                        codeResultTextView.setText(code);
                        idResultTextView.setText("Failure");
                        titleResultTextView.setText("Failure");
                        useridResultTextView.setText("Failure");
                        bodyResultTextView.setText("Failure");
                    }
                });
            }
        });

        post.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "POST Clicked", Toast.LENGTH_SHORT).show();

                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("title", "foo");
                parameters.put("body", "bar");
                parameters.put("userId", 1);

                retroClient.postFirst(parameters, new RetroCallback() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(LOG, t.toString());
                        codeResultTextView.setText("Error");
                        idResultTextView.setText("Error");
                        titleResultTextView.setText("Error");
                        useridResultTextView.setText("Error");
                        bodyResultTextView.setText("Error");
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        ResponseGet data = (ResponseGet) receivedData;
                        codeResultTextView.setText(String.valueOf(code));
                        idResultTextView.setText(String.valueOf(data.id));
                        titleResultTextView.setText(data.title);
                        useridResultTextView.setText(String.valueOf(data.userId));
                        bodyResultTextView.setText(data.body);
                    }

                    @Override
                    public void onFailure(int code) {
                        codeResultTextView.setText(code);
                        idResultTextView.setText("Failure");
                        titleResultTextView.setText("Failure");
                        useridResultTextView.setText("Failure");
                        bodyResultTextView.setText("Failure");
                    }
                });
            }
        });

        put.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "PUT Clicked", Toast.LENGTH_SHORT).show();

                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("title", "foo");
                parameters.put("body", "bar");
                parameters.put("userId", 1);
                parameters.put("id", 1);

                retroClient.putFirst(parameters, new RetroCallback() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(LOG, t.toString());
                        codeResultTextView.setText("Error");
                        idResultTextView.setText("Error");
                        titleResultTextView.setText("Error");
                        useridResultTextView.setText("Error");
                        bodyResultTextView.setText("Error");
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        ResponseGet data = (ResponseGet) receivedData;
                        codeResultTextView.setText(String.valueOf(code));
                        idResultTextView.setText(String.valueOf(data.id));
                        titleResultTextView.setText(data.title);
                        useridResultTextView.setText(String.valueOf(data.userId));
                        bodyResultTextView.setText(data.body);
                    }

                    @Override
                    public void onFailure(int code) {
                        codeResultTextView.setText(code);
                        idResultTextView.setText("Failure");
                        titleResultTextView.setText("Failure");
                        useridResultTextView.setText("Failure");
                        bodyResultTextView.setText("Failure");
                    }
                });
            }
        });

        patch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "PATCH Clicked", Toast.LENGTH_SHORT).show();

                retroClient.createBaseApi().patchFirst("foo", new RetroCallback() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(LOG, t.toString());
                        codeResultTextView.setText("Error");
                        idResultTextView.setText("Error");
                        titleResultTextView.setText("Error");
                        useridResultTextView.setText("Error");
                        bodyResultTextView.setText("Error");
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        ResponseGet data = (ResponseGet) receivedData;
                        codeResultTextView.setText(String.valueOf(code));
                        idResultTextView.setText(String.valueOf(data.id));
                        titleResultTextView.setText(data.title);
                        useridResultTextView.setText(String.valueOf(data.userId));
                        bodyResultTextView.setText(data.body);
                    }

                    @Override
                    public void onFailure(int code) {
                        codeResultTextView.setText(code);
                        idResultTextView.setText("Failure");
                        titleResultTextView.setText("Failure");
                        useridResultTextView.setText("Failure");
                        bodyResultTextView.setText("Failure");
                    }
                });
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "DELETE Clicked", Toast.LENGTH_SHORT).show();

                retroClient.deleteFirst(new RetroCallback() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e(LOG, t.toString());
                        codeResultTextView.setText("Error");
                        idResultTextView.setText("Error");
                        titleResultTextView.setText("Error");
                        useridResultTextView.setText("Error");
                        bodyResultTextView.setText("Error");
                    }

                    @Override
                    public void onSuccess(int code, Object receivedData) {
                        codeResultTextView.setText(String.valueOf(code));
                        idResultTextView.setText("");
                        titleResultTextView.setText("");
                        useridResultTextView.setText("");
                        bodyResultTextView.setText("");
                    }

                    @Override
                    public void onFailure(int code) {
                        codeResultTextView.setText(code);
                        idResultTextView.setText("Failure");
                        titleResultTextView.setText("Failure");
                        useridResultTextView.setText("Failure");
                        bodyResultTextView.setText("Failure");
                    }
                });
            }
        });
    }
}
