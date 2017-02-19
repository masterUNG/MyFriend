package appewtc.masterung.myfriend;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by masterUNG on 2/19/2017 AD.
 */

public class AddNewUser extends AsyncTask<Void, Void, String>{

    private Context context;
    private static final String urlPHP = "http://swiftcodingthai.com/19feb/addUserMaster.php";
    private String nameString, userString, passwordString, imageString;

    public AddNewUser(Context context,
                      String nameString,
                      String userString,
                      String passwordString,
                      String imageString) {
        this.context = context;
        this.nameString = nameString;
        this.userString = userString;
        this.passwordString = passwordString;
        this.imageString = imageString;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", nameString)
                    .add("User", userString)
                    .add("Password", passwordString)
                    .add("Image", imageString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            Log.d("19febV1", "e doin ==> " + e.toString());
            return null;
        }


    }
}   // Main Class
