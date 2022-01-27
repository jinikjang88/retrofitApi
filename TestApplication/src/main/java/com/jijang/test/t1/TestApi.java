package com.jijang.test.t1;

import com.jijang.test.retrofit.RetrofitClient;
import com.jijang.test.t1.service.TestDto;
import com.jijang.test.t1.service.TestApiService;
import com.jijang.test.t1.service.TestParameter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Objects;

public class TestApi {
    private final TestApiService apiService;

    public TestApi() {
        this.apiService = RetrofitClient.getApiService();
    }

    public void postTest(String test) {
        TestParameter testParameter = TestParameter.of(test);

        Call<TestDto> post = apiService.createTest(testParameter);
        try {
            Response<TestDto> res = post.execute();
            // 성공 처리
            int code = res.code();
            if (res.isSuccessful()) {
                // 성공 처리
                TestDto savedTest = res.body();
                System.out.println("## success " + code + " : " + savedTest);
            } else {
                // 실패 처리
                ResponseBody responseBody = res.errorBody();
                System.out.println("## fail " + code + " : " + Objects.requireNonNull(responseBody).string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
