package com.jijang.test.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jijang.test.config.*;
import com.jijang.test.t1.service.TestApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class RetrofitClient {
        private static final String BASE_URL = "http://localhost:8080";

    public static TestApiService getApiService() {
        return getInstance().create(TestApiService.class);
    }

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder()
                .setLenient()  // Gson은 JSON에 대해 엄격함. 해당 옵션으로 parser가 허용하는 항목에 대해 자유로움.
                .registerTypeAdapter(LocalDate.class, new LocalDateSerializer()) // 날짜관련된
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer())
                .setPrettyPrinting()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
}
