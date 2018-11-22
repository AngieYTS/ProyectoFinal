package com.koddev.chatapp.Fragments;

import com.koddev.chatapp.Notifications.MyResponse;
import com.koddev.chatapp.Notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAAXDgzRdc:APA91bFJ8tOwpStnLJ9O6Sk-17vUqi0JNTL_8FK78Q9ScDDPUvr8OUo7cbWd7206PjXIX-QYFzYxFSRUsuqJFq5Tp85molcKFpyg8RXlLHlc1JeLuHuHxUUrIxbUwZ4G8Yqx89sL49Sz"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body);
}
