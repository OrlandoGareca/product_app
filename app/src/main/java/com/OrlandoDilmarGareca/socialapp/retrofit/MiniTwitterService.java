package com.OrlandoDilmarGareca.socialapp.retrofit;

import com.OrlandoDilmarGareca.socialapp.retrofit.Request.RequestLogin;
import com.OrlandoDilmarGareca.socialapp.retrofit.Request.RequestSignup;
import com.OrlandoDilmarGareca.socialapp.retrofit.Response.ResponseAuth;
import com.OrlandoDilmarGareca.socialapp.retrofit.Response.ResponseLogin;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MiniTwitterService {

    @POST("login/")
    Call<ResponseLogin> doLogin(@Body RequestLogin requestLogin);

//    @POST("auth/signup")
//    Call<ResponseAuth> doSignUp(@Body RequestSignup requestSignup);

    @POST("usuario/")
    Call<ResponseAuth> doSignUp(@Body RequestSignup requestSignup);

}
