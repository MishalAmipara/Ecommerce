package com.example.ecommerceapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewData_Activity extends AppCompatActivity {

    ListView listView;
    ArrayList<DataModel> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        listView=findViewById(R.id.recyclerView);

        apiCalling();
        System.out.println("size of data="+arrayList.size());
        DataAdapter dataAdapter=new DataAdapter(this,arrayList);
        listView.setAdapter(dataAdapter);

    }

    private void apiCalling()
    {
        Log.d("API","API Called");

        String url="https://jsonplaceholder.typicode.com/users";
        RequestQueue requestQueue= Volley.newRequestQueue(ViewData_Activity.this);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Response=",response.toString());
                        try {
                            JSONArray jsonArray= new JSONArray(response);
                            for (int i=0;i<jsonArray.length();i++)
                            {

                                JSONObject jsonObject=jsonArray.getJSONObject(i);
                                int id=jsonObject.getInt("id");
                                String name=jsonObject.getString("name");
                                String uname=jsonObject.getString("username");
                                String email=jsonObject.getString("email");
                                DataModel dataModel=new DataModel(id,name,uname,email);
//                                dataModel.setId(id);
//                                dataModel.setName(name);
//                                dataModel.setUname(uname);
//                                dataModel.setEmail(email);
                                arrayList.add(dataModel);

                                Log.d("AAA","Size"+arrayList.size());

                            }
                            Log.d("BBB","data="+arrayList);


                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //textView.setText("That didn't work!");
                        Log.e("errors=",error.toString());
                    }
                });

        // Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }
}