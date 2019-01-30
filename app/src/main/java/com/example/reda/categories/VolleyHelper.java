package com.example.reda.categories;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.example.reda.categories.CategoriesFragment.adapter;
import static com.example.reda.categories.CategoriesFragment.categoryList;

public class VolleyHelper {

    private final static String API_URL = "http://192.168.1.17/ecommerce/public/api/";
    private final static String TYPE_LOGIN = "login";
    private final static String TYPE_REGISTER = "register";
    private final static String TYPE_UPDATE = "update";
    private final static String TYPE_CATEGORY = "categories";
    private final static String TYPE_SUBCATEGORY = "categories/subcategory/";
    private final static String TYPE_COMPANY = "categories/get-com-shop/4";


    private static String requestType;
    private static String recentToken;
    private static String elementId;


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

    public static void preparePath(String type) {
        requestType = type;
    }

    public static void preparePath(String id, String type) {
        switch (type) {
            case "SUBCATEGORY":
                setApiType(TYPE_SUBCATEGORY);
                break;
            default:
                setApiType(TYPE_SUBCATEGORY);
                break;

        }

        elementId = id;
    }

    private static String getPath() {
        Log.i("ApiSubCategoryResponse", elementId);

        return getApiUrl() + elementId;
    }


    //set Body for performQuestionAns
    public static void setQuestionAnswer(QuestionAnswerModel data) {
        userObj = new JSONObject();
        try {
            userObj.put("question_id", data.getQuestion_id());
            userObj.put("choice_id", new JSONArray(data.getQuestionChoices_arr()));

            Log.i("ApiQuestionAnswers", String.valueOf(data.getQuestion_id()));
            Log.i("ApiQuestionAnswers", String.valueOf(data.getQuestionChoices_arr()[3]));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        preparePath("products/question-answer");

    }


    //set Body for requestFollowUnFollow
    public static void setFollowUnFollow(FollowUnFollowModel data) {
        userObj = new JSONObject();
        try {
            userObj.put("user_id", data.getUser_id());
            userObj.put("follow_id", data.getFollow_id());
            userObj.put("type", data.getType());
            userObj.put("send_type", data.getSend_type());


        } catch (JSONException e) {
            e.printStackTrace();
        }

        preparePath("follows/follow-unfollow");

    }


    public static void loadCategories() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiCategoryResponse ", response.toString());


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
                        Log.i("ApiCategoryResponse ", model.getName_ar());
                        Log.i("ApiCategoryResponse ", String.valueOf(model.getId()));

                        categoryList.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiCategoryResponse ", "Couldn't reach API");
                Log.i("ApiCategoryResponse", String.valueOf(error));
                Log.i("ApiCategoryResponse", getApiUrl());


            }
        });

        requestQueue.add(request);


    }

    public static void loadSubCategories() {
        Log.i("ApiSubCategoryResponse", "called");
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getPath(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiSubCategoryResponse", response.toString());


                Gson gson = new Gson();

                JSONArray jsonArray = null;
                try {
                    jsonArray = response.getJSONArray("success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < jsonArray.length(); i++) {
                    try {
                        CategoryModel model = gson.fromJson(jsonArray.get(i).toString(), CategoryModel.class);
                        Log.i("ApiSubCategoryResponse", String.valueOf(model.getId()));
                        categoryList.add(model);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiSubCategoryResponse", "Couldn't reach API");
                Log.i("ApiSubCategoryResponse", getApiUrl());
                Log.i("ApiSubCategoryResponse ", String.valueOf(error));


            }
        });

        requestQueue.add(request);


    }

    public static void loadCompany() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiCompanyResponse ", response.toString());


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
                        CompanyModel model = gson.fromJson(jsonArray.get(i).toString(), CompanyModel.class);
                        Log.i("ApiCompanyResponse ", model.getName_ar());
                        Log.i("ApiCompanyResponse  ", String.valueOf(model.getId()));
                        ShopModel arr[] = model.getShops();

                        for (int j = 0; j < model.getShops().length; j++) {

                            Log.i("ApiCompanyResponse ", model.getShops()[j].getPhone());
                            Log.i("ApiCompanyResponse ", arr[j].getName_ar());
                            Log.i("ApiCompanyResponse ", arr[j].getImage());
                            Log.i("ApiCompanyResponse ", arr[j].getPhone());
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiCompanyResponse  ", "Couldn't reach API");
                Log.i("ApiCompanyResponse ", String.valueOf(error));
                Log.i("ApiCompanyResponse ", getApiUrl());


            }
        });

        requestQueue.add(request);


    }

    public static void loadProduct() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiProductResponse ", response.toString());


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
                        ProductModel model = gson.fromJson(jsonArray.get(i).toString(), ProductModel.class);
                        Log.i("ApiProductResponse ", model.getName_ar());
                        Log.i("ApiProductResponse  ", String.valueOf(model.getId()));
                        Log.i("ApiProductResponse  ", String.valueOf(model.getPrice()));
                        Log.i("ApiProductResponse ", String.valueOf(model.getHas_offer()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiProductResponse  ", "Couldn't reach API");
                Log.i("ApiProductResponse ", String.valueOf(error));
                Log.i("ApiProductResponse", getApiUrl());


            }
        });

        requestQueue.add(request);


    }

    public static void loadQuestion() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //   Log.i("ApiQuestionResponse ", response.toString());


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
                        QuestionModel model = gson.fromJson(jsonArray.get(i).toString(), QuestionModel.class);
                        Log.i("ApiQuestionResponse ", model.getDescription_ar());
                        Log.i("ApiQuestionResponse  ", String.valueOf(model.getId()));
                        QuestionChoiceModel arr[] = model.getQuestion_choice();

                        for (int j = 0; j < model.getQuestion_choice().length; j++) {

                            Log.i("ApiQuestionResponse ", arr[j].getChoice());
                            Log.i("ApiQuestionResponse ", String.valueOf(arr[j].getQuestion_id()));
                            Log.i("ApiQuestionResponse ", String.valueOf(arr[j].getId()));
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiQuestionResponse ", "Couldn't reach API");
                Log.i("ApiQuestionResponse", String.valueOf(error));
                Log.i("ApiQuestionResponse", getApiUrl());


            }
        });

        requestQueue.add(request);


    }


    public static void loadProductDetails() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //   Log.i("ApiProductDetailsRes", response.toString());
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

                try {
                    JSONObject jsonObject = response.getJSONObject("success");

                    ProductDetailsModel model = gson.fromJson(jsonObject.toString(), ProductDetailsModel.class);
                    Log.i("ApiProductDetailsRes", model.getDescription_ar());
                    Log.i("ApiProductDetailsRes", String.valueOf(model.getId()));

                    ImageModel[] imageModels = model.getImage();
                    for (int j = 0; j < imageModels.length; j++) {
                        Log.i("ApiProductDetailsRes ", imageModels[j].getImage());
                    }


                    ShopsModel[] shopsModels = model.getShops();
                    for (int j = 0; j < shopsModels.length; j++) {
                        Log.i("ApiProductDetailsRes ", String.valueOf(shopsModels[j].getId()));
                        Log.i("ApiProductDetailsRes ", shopsModels[j].getShop().getPhone());
                    }


                    ColorSizeModel[] colorSizeModels = model.getColor_size();
                    for (int j = 0; j < colorSizeModels.length; j++) {
                        Log.i("ApiProductDetailsRes ", String.valueOf(colorSizeModels[j].getId()));

                        Log.i("ApiProductDetailsRes ", colorSizeModels[j].getColor().getColor());

                        Log.i("ApiProductDetailsRes ", colorSizeModels[j].getSize().getSize());
                    }


                    ProductOfferModel[] productOfferModels = model.getProductoffer();
                    for (int j = 0; j < productOfferModels.length; j++) {

                        Log.i("ApiProductDetailsRes ", String.valueOf(productOfferModels[j].getId()));

                        Log.i("ApiProductDetailsRes ", String.valueOf(productOfferModels[j].getOffer().getDiscount()));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiProductDetailsRes ", "Couldn't reach API");
                Log.i("ApiProductDetailsRes ", String.valueOf(error));
                Log.i("ApiProductDetailsRes", getApiUrl());


            }
        });

        requestQueue.add(request);


    }

    public static void performQuestionAns() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, getApiUrl(), userObj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {


                    String result = response.getString("success");

                    Log.i("ApiQuestionAnswers", result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.i("ApiQuestionAnswers ", "Couldn't reach API");
                Log.i("ApiQuestionAnswers ", String.valueOf(error));
                Log.i("ApiQuestionAnswers", getApiUrl());


            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");

                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        requestQueue.add(request);


    }

    public static void requestFollowUnFollow() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, getApiUrl(), userObj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    //Log.i("ApiFollowUnFollowReq", response.toString());

                    String result = response.getString("success");

                    Log.i("ApiFollowUnFollowReq", result);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Log.i("ApiFollowUnFollowReq", "Couldn't reach API");
                Log.i("ApiFollowUnFollowReq", String.valueOf(error));
                Log.i("ApiFollowUnFollowReq", getApiUrl());


            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                headers.put("Accept", "application/json");

                return headers;
            }

            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }
        };

        requestQueue.add(request);

    }

    public static void requestFollowedCompanyList() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

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
                        FollowedCompanyModel model = gson.fromJson(jsonArray.get(i).toString(), FollowedCompanyModel.class);
                        Log.i("ApiFollowedCompanyList ", model.getName_ar());
                        Log.i("ApiFollowedCompanyList ", String.valueOf(model.getId()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiFollowedCompanyList ", "Couldn't reach API");
                Log.i("ApiFollowedCompanyList ", String.valueOf(error));
                Log.i("ApiFollowedCompanyList ", getApiUrl());


            }
        });

        requestQueue.add(request);
    }

    public static void requestFollowedUsersList() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

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
                        FollowedUserModel model = gson.fromJson(jsonArray.get(i).toString(), FollowedUserModel.class);
                        Log.i("ApiFollowedUsersList ", model.getName_ar());
                        Log.i("ApiFollowedUsersList ", String.valueOf(model.getId()));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiFollowedUsersList ", "Couldn't reach API");
                Log.i("ApiFollowedUsersList ", String.valueOf(error));
                Log.i("ApiFollowedUsersList ", getApiUrl());


            }
        });

        requestQueue.add(request);
    }


    public static void loadRecommendsFromUsers() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiRecommendsFromUsers ", response.toString());


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
                        RecommendsFromModel model = gson.fromJson(jsonArray.get(i).toString(), RecommendsFromModel.class);
                        Log.i("ApiRecommendsFromUsers ", model.getMessage());
                        Log.i("ApiRecommendsFromUsers ", String.valueOf(model.getId()));

                        Log.i("ApiRecommendsFromUsers ", model.getRecommend_from().getName_ar());
                        Log.i("ApiRecommendsFromUsers ", model.getRecommend_product().getName_ar());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiRecommendsFromUsers ", "Couldn't reach API");
                Log.i("ApiRecommendsFromUsers ", String.valueOf(error));
                Log.i("ApiRecommendsFromUsers ", getApiUrl());


            }
        });

        requestQueue.add(request);
    }

    public static void LoadRecommendsToUsers() {
        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, getApiUrl(), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("ApiRecommendsToUsers ", response.toString());


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
                        RecommendsToModel model = gson.fromJson(jsonArray.get(i).toString(), RecommendsToModel.class);
                        Log.i("ApiRecommendsToUsers ", model.getMessage());
                        Log.i("ApiRecommendsToUsers ", String.valueOf(model.getId()));

                        Log.i("ApiRecommendsToUsers ", model.getRecommend_from().getName_ar());
                        Log.i("ApiRecommendsToUsers ", model.getRecommend_product().getName_ar());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("ApiRecommendsToUsers ", "Couldn't reach API");
                Log.i("ApiRecommendsToUsers ", String.valueOf(error));
                Log.i("ApiRecommendsToUsers ", getApiUrl());


            }
        });

        requestQueue.add(request);
    }


}

