package com.example.reda.categories;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.reda.categories.CategoriesFragment.categoryList;

public class VolleyHelper {

    private final static String API_URL = "http://192.168.1.17/ecommerce/public/api/";
    private final static String TYPE_LOGIN = "login";
    private final static String TYPE_REGISTER = "register";
    private final static String TYPE_UPDATE = "update";
    private final static String TYPE_CATEGORY = "categories";



    private static String requestType;
    private static String recentToken;


    private static RequestQueue requestQueue;
    private static JSONObject userObj;


    public VolleyHelper() {
        //Required Empty Constructor
    }


    public static void volleyInitialize(Context context) {
        requestQueue = Volley.newRequestQueue(context);

    }




    private static void setApiType(String type) {
        requestType = type;
    }


    private static String getApiUrl() {
        return API_URL + requestType;
    }

    public static void setExplicitApiType(String type)
    {
        requestType =type;
    }




    public static void loadCategories()
    {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiCategoryResponse", response.toString());

                Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return false;
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                }).create();

                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        CategoryModel model = gson.fromJson(jsonArray.get(i).toString(), CategoryModel.class);
                      categoryList.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                   Log.i("ApiCategoryResponse","Couldn't reach API");
            }
        });

        requestQueue.add(request);


    }


}

