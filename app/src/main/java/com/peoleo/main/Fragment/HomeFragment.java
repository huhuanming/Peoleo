package com.peoleo.main.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.JsonElement;
import com.peoleo.main.ApiManager.Request;
import com.peoleo.main.Model.User;
import com.peoleo.main.R;

import io.realm.Realm;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by hu on 14-11-4.
 */
public class HomeFragment extends Fragment {
    private View parentView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView = inflater.inflate(R.layout.fragment_home,container,false);
        //移除数据库文件
        Realm.deleteRealmFile(getActivity());
        new Request("a","a").adapter().create(User.Action.class).login("Ping","GetPing")
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<JsonElement>() {
            @Override
            public void onCompleted() {
//                Toast.makeText(getActivity(),"完成",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(getActivity(), "出错", Toast.LENGTH_SHORT).show();
                Log.e("ssss", e + "");
            }

            @Override
            public void onNext(JsonElement jsonElement) {
                Toast.makeText(getActivity(), "ne", Toast.LENGTH_SHORT).show();
                Log.e("ssss", jsonElement + "");
//                realm.beginTransaction();
//                try {
//                    User user = (User)Request.toObject(Request.getPackageName("User"), jsonElement, Realm.getInstance(PeoleoApplication.getAppContext()));
//                    Log.e("ssss",user.getPing());
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                }
//                realm.commitTransaction();
            }
        });
        return parentView;
    }
}
