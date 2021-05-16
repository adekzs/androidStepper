package com.example.materialstepperexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.materialstepperexample.model.ResponseResult;
import com.example.materialstepperexample.model.User;
import com.example.materialstepperexample.retrofit.FormService;
import com.example.materialstepperexample.retrofit.RetrofitClientClass;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepstone.stepper.BlockingStep;
import com.stepstone.stepper.StepperLayout;
import com.stepstone.stepper.VerificationError;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.app.Activity.RESULT_OK;

public class ThirdFragment extends Fragment implements BlockingStep, ProcessResult {
    private static final String TAG = "ThirdFragment";
    private Uri imageUri;
    private File imageFile;

    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        CircleImageView image = v.findViewById(R.id.profile_image);
        image.setOnClickListener(view -> {
            CropImage.activity()
                    .setAspectRatio(1,2)
                    .start(getContext(), ThirdFragment.this);
        });
        return v;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            imageUri = result.getUri();
            setUpUserFile();
        } else {
            Toast.makeText(getContext(), "Error, Try Again Later", Toast.LENGTH_SHORT).show();
        }
    }

    private void setUpUserFile() {
        if (imageUri != null) {
            imageFile = new File(imageUri.getPath());
        } else {
            Toast.makeText(getContext(), "Choose another Image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNextClicked(StepperLayout.OnNextClickedCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.goToNextStep();
            }
        }, 1000L);
    }

    @Override
    public void onCompleteClicked(StepperLayout.OnCompleteClickedCallback callback) {
        User user = new User("Michael", "Adeks", "0908", "123456", "123456", "abcdef", "1", "2", imageFile, "abia"
                , "adeks@gmail", "descrip", "1200", "1", "abia", "1", "123445678", "skill full", "Male", "individual", "https://web.whatsapp.com/");
        if (user.getImage() != null) {
            performSendRequest(user, this);
        } else {
            Toast.makeText(getContext(), "The image does not exist, try to choose another image", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackClicked(StepperLayout.OnBackClickedCallback callback) {
        Toast.makeText(this.getContext(), "Your custom back action. Here you should cancel currently running operations", Toast.LENGTH_SHORT).show();
        callback.goToPrevStep();
    }

    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    private void performSendRequest(User user, ProcessResult processResult) {
        Retrofit retrofit = RetrofitClientClass.getRetrofitInstance();
        FormService form = retrofit.create(FormService.class);

        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("address", user.getAddress());
        builder.addFormDataPart("availability", user.getAvailability());
        builder.addFormDataPart("description", user.getDescription());
        builder.addFormDataPart("duration", user.getDuration());
        builder.addFormDataPart("email", user.getEmail());
        builder.addFormDataPart("first_name", user.getFirst_name());
        RequestBody requestBody = RequestBody.create(user.getImage(), MediaType.parse("multipart/form-data"));
        builder.addFormDataPart("image", user.getImage().getName(), requestBody);
        builder.addFormDataPart("last_name", user.getLast_name());
        builder.addFormDataPart("lga", user.getLga());
        builder.addFormDataPart("location", user.getLocation());
        builder.addFormDataPart("password", user.getPassword());
        builder.addFormDataPart("password_confirmation", user.getPassword_confirmation());
        builder.addFormDataPart("phone", user.getPhone());
        builder.addFormDataPart("price", user.getPrice());
        builder.addFormDataPart("service", user.getService());
        builder.addFormDataPart("state", user.getState());
        builder.addFormDataPart("nin", user.getNin());
        builder.addFormDataPart("skill_description", user.getSkill_description());
        builder.addFormDataPart("gender", user.getGender());
        builder.addFormDataPart("company_type", user.getCompany_type());
        builder.addFormDataPart("portfolio_link", user.getPortfolio_link());


        RequestBody finalRb = builder.build();


        Call<ResponseResult> upload = form.createUser(finalRb);
        upload.enqueue(new Callback<ResponseResult>() {
            @Override
            public void onResponse(Call<ResponseResult> call, Response<ResponseResult> response) {
                if (response.isSuccessful()) {
                    if (response.code() == 200) {
                        Log.d(TAG, "onResponse: Response result " + response.body().toString());
                        ResponseResult resp = response.body();
                        String token = resp.getToken();
                        String workerId = resp.getWorker().getWorkerId();
                        Log.d(TAG, "onResponse: TOKEN:" + token + "WORKER_ID: " + workerId);
                        processResult.onProcessCompleted();
                    }
                } else {
                    if (response.errorBody() != null) {
                        try {
                            String errorMessage = response.errorBody().string();
                            JsonParser parser = new JsonParser();
                            Object obj = parser.parse(errorMessage);
                            JsonObject message = (JsonObject) obj;
                            JsonObject error = message.getAsJsonObject("errors");
                            Log.d(TAG, "onResponse: Errors av" + error.toString());
                            outputErrorOnEachField(error);
                            Log.d(TAG, "onResponse: Message" + errorMessage);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    processResult.onProcessFailed("Error");
                }
                Log.d(TAG, "onResponse: SUCCESSFUL" + response.body());
            }


            @Override
            public void onFailure(Call<ResponseResult> call, Throwable t) {
                processResult.onProcessFailed(t.toString());
                Log.d(TAG, "onFailure: FAILED" + t.toString());
            }
        });
        showLoadingIcon();
    }

    private void showLoadingIcon() {

    }

    private void outputErrorOnEachField(JsonObject error) {
    }

    @Override
    public void onProcessCompleted() {

    }

    @Override
    public void onProcessFailed(String t) {

    }
}