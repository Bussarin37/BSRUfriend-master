package appewtc.masterung.bsrufriend;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Process;
import android.speech.tts.Voice;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by Administrator on 10/2/2560.
 */

public class AddValueToUser extends AsyncTask<String,Void,String> {
    //Explicit
    private Context context;
    private String nameString,userString,passString,imageString,AvataString;
    private ProgressDialog progressDialog;

    public AddValueToUser(Context context,
                          String avataString,
                          String nameString,
                          String userString,
                          String passString,
                          String imageString) {
        this.context = context;
        this.AvataString = avataString;
        this.nameString = nameString;
        this.userString = userString;
        this.passString = passString;
        this.imageString = imageString;

    } //Constru

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = progressDialog.show(context,"Upload Value",
                "Please Wait Few Minus...");
    }

    @Override
    protected String doInBackground(String... params) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd","true")
                    .add("Name",nameString)
                    .add("User",userString)
                    .add("Password",passString)
                    .add("Image",imageString)
                    .add("Avata", AvataString)
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(params[0]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        }catch (Exception e){
            Log.d("10fabV2","e doin ==>"+e.toString());
        }

        return null;
    }
} //Main Class
