package com.adityaprakash.githubrepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class GithubApi {

    private static final String url = "https://api.github.com/";

    public static PostService postService = null;

    public static PostService getPostService(){
        if(postService == null){

            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService = retrofit.create(PostService.class);
        }
        return postService;
    }


    public interface PostService{
        @GET("/users/{user}/repos")
        Call<List<Githubrepo>> getRepos(@Path("user") String user);
    }
}
