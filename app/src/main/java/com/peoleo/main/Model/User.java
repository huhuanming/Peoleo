package com.peoleo.main.Model;

import com.google.gson.JsonElement;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by hu on 14/10/29.
 */
public class User extends RealmObject{
    private String ping;


    @Ignore
    private String authorization;

//    public static boolean isLogin(){
//        return Realm.getInstance(ApplicationRunTime.getAppContext()).where(AccessToken.class).count() != 1 ;
//    }

//    public String getAuthorization(){
//        return this.access_token.getToken() + this.access_token.getKey();
//    }
    public interface Action {
        @FormUrlEncoded
        @POST("/client/api.php")
        Observable<JsonElement> login(@Field("path")String path,@Field("action") String action);
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping;
    }
}
