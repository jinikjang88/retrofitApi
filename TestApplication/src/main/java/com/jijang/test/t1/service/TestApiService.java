package com.jijang.test.t1.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TestApiService {

    @Headers({"Authorization: Bearer 1234"})
    @POST("/test")
    Call<TestDto> createTest(@Body TestParameter parameter);
}
