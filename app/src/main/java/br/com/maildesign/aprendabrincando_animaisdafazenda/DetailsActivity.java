package br.com.maildesign.aprendabrincando_animaisdafazenda;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import br.com.maildesign.aprendabrincando_animaisdafazenda.models.Animal;


public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    static MediaPlayer mediaPlayer;
    private long lastClickTime = 0;

    private static final String IMAGE_PATH = "file:///android_asset/images/";

    public static Animal animalData;

    private String animalName;
    private String animalTextBR;
    private String animalTextEN;
    private String animalTextES;


    public void fillVarAnimal(){
        animalData = getIntent().getParcelableExtra("SendData");
        animalName = animalData.getaName();
        animalTextBR = animalData.getaTextBR();
        animalTextEN = animalData.getaTextEN();
        animalTextES = animalData.getaTextES();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        fillVarAnimal();

        Uri uri = Uri.parse(IMAGE_PATH.concat(animalName).concat(".jpg"));


        ImageView home = findViewById(R.id.homeButton);
        home.setOnClickListener(this);
        home.setSoundEffectsEnabled(false);
        home.bringToFront();

        ImageView sound = findViewById(R.id.animal_image);
        sound.setOnClickListener(this);
        sound.setSoundEffectsEnabled(false);
        Glide.with(this)
                .load(uri)
                .into(sound);

        ImageView spanish = findViewById(R.id.spanish);
        spanish.setOnClickListener(this);
        spanish.setSoundEffectsEnabled(false);

        ImageView english = findViewById(R.id.english);
        english.setOnClickListener(this);
        english.setSoundEffectsEnabled(false);

        ImageView portuguese = findViewById(R.id.portuguese);
        portuguese.setOnClickListener(this);
        portuguese.setSoundEffectsEnabled(false);

    }

    @Override
    public void onClick(View v) {

        if (SystemClock.elapsedRealtime() - lastClickTime < 1200) {
            return;
        }
        lastClickTime = SystemClock.elapsedRealtime();

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toastLayout));
        TextView toastText = layout.findViewById(R.id.toastText);

        switch (v.getId()) {
            case R.id.homeButton:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            case R.id.animal_image:
                stopSound();
                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(animalName.concat("_som"),"raw", getPackageName()));
                playSound();
                break;
            case R.id.spanish:
                stopSound();
                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(animalName.concat("_es"),"raw", getPackageName()));
                playSound();
                toastText.setText(animalTextES);
                Toast toastNameES = new Toast(getApplicationContext());
                toastNameES.setGravity(Gravity.CENTER, 0, 0);
                toastNameES.setDuration(Toast.LENGTH_SHORT);
                toastNameES.setView(layout);
                toastNameES.show();
                break;
            case R.id.portuguese:
                stopSound();
                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(animalName.concat("_br"),"raw", getPackageName()));
                mediaPlayer.start();
                toastText.setText(animalTextBR);
                Toast toastNameBR = new Toast(getApplicationContext());
                toastNameBR.setGravity(Gravity.CENTER, 0, 0);
                toastNameBR.setDuration(Toast.LENGTH_SHORT);
                toastNameBR.setView(layout);
                toastNameBR.show();
                break;
            case R.id.english:
                stopSound();
                mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(animalName.concat("_en"),"raw", getPackageName()));
                playSound();
                toastText.setText(animalTextEN);
                Toast toastNameEN = new Toast(getApplicationContext());
                toastNameEN.setGravity(Gravity.CENTER, 0, 0);
                toastNameEN.setDuration(Toast.LENGTH_SHORT);
                toastNameEN.setView(layout);
                toastNameEN.show();
                break;
        }
    }

    public void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();

        }
    }

    public void stopSound() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
