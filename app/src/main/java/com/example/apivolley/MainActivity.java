package com.example.apivolley;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.apivolley.model.Publicacion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter arrayAdapter;
    ArrayList<String> datos = new ArrayList<>();


    @SuppressWarnings("SyntaxError")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listViewNoticias);
        arrayAdapter=new ArrayAdapter( this, android.R.layout.simple_list_item_1,datos );
        listView.setAdapter(arrayAdapter);
        obtenerDatos();
    }
    private void obtenerDatos(){
        String url="https://fakestoreapi.com/products";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                 //recibirinformacion
                //pasa json a publicacion
                pasarJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // manejarerror

                Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        //en este punto pasamos la peticion del ws a la cola del volley
        Volley.newRequestQueue( this).add(jsonArrayRequest);



    }

    private void pasarJson(JSONArray array){

        for (int i=0; i<array.length(); i++){

            JSONObject json=null;
            Publicacion pub= new Publicacion();


            try {

                json = array.getJSONObject(i);



                //clase instanciada y seteada datos del ws
                //agrego los datos al arraylist enlazado con la lista
                pub.setId(json.getInt("id"));
                pub.setTitulo(json.getString("title"));
                pub.setDescripcion(json.getString("description"));
                pub.setCategoria(json.getString("category"));



               datos.add(pub.getTitulo());

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        arrayAdapter.notifyDataSetChanged();
    }



}