package br.com.maildesign.aprendabrincando_animaisdafazenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import br.com.maildesign.aprendabrincando_animaisdafazenda.adapters.RecyclerViewAdapter;
import br.com.maildesign.aprendabrincando_animaisdafazenda.interfaces.AnimalClickListener;
import br.com.maildesign.aprendabrincando_animaisdafazenda.models.Animal;

public class MainActivity extends AppCompatActivity implements AnimalClickListener {

    private static final String TAG = "MainActivity";
    private static final String IMAGE_PATH = "file:///android_asset/images/";
    private ArrayList<String> mImagesPath = new ArrayList<>();
    private ArrayList<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
        putData();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");
        mImagesPath.add(IMAGE_PATH.concat("abelha.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("burro.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("cabra.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("camundongo.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("cao.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("cavalo.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("cisne.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("coelho.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("coruja.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("furao.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("galinha.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("galinhadangola.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("galo.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("ganso.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("gato.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("jabuti.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("lhama.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("ovelha.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("pato.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("pavao.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("peru.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("pintinho.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("pombo.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("porco.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("porquinhodaindia.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("rato.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("sapo.jpg"));
        mImagesPath.add(IMAGE_PATH.concat("vaca.jpg"));

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mImagesPath, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    public void putData(){
        animalList.add(new Animal("abelha", "Abelha", "Bee", "Abeja"));
        animalList.add(new Animal("burro", "Burro", "Donkey", "Burro"));
        animalList.add(new Animal("cabra", "Cabra", "Goat", "Cabra"));
        animalList.add(new Animal("camundongo", "Camundongo", "Mouse", "Ratón"));
        animalList.add(new Animal("cao", "Cão", "Dog", "Perro"));
        animalList.add(new Animal("cavalo", "Cavalo", "Horse", "Caballo"));
        animalList.add(new Animal("cisne", "Cisne", "Swan", "Cisne"));
        animalList.add(new Animal("coelho", "Coelho", "Rabbit", "Conejo"));
        animalList.add(new Animal("coruja", "Coruja", "Owl","Búho"));
        animalList.add(new Animal("furao", "Furão", "Feret", "Hurón"));
        animalList.add(new Animal("galinha", "Galinha", "Chicken", "Pollo"));
        animalList.add(new Animal("galinhadangola", "Galinha D'angola", "Guinea Fowl", "Gallina de Guinea"));
        animalList.add(new Animal("galo", "Galo", "Rooster", "Galo"));
        animalList.add(new Animal("ganso", "Ganso", "Goose", "Ganso"));
        animalList.add(new Animal("gato", "Gato", "Cat", "Gato"));
        animalList.add(new Animal("jabuti","Jabuti", "Tortoise", "Tortuga"));
        animalList.add(new Animal("lhama", "Lhama", "Llama", "Llama"));
        animalList.add(new Animal("ovelha", "Ovelha", "Sheep", "Oveja"));
        animalList.add(new Animal("pato", "Pato", "Duck", "Pato"));
        animalList.add(new Animal("pavao", "Pavão","Peacock", "Pavo real"));
        animalList.add(new Animal("peru", "Peru", "Turkey", "Pavo"));
        animalList.add(new Animal("pintinho", "Pintinho", "Chick", "Pollito"));
        animalList.add(new Animal("pombo", "Pombo","Pigeon", "Paloma"));
        animalList.add(new Animal("porco", "Porco", "Pig", "Cerdo"));
        animalList.add(new Animal("porquinhodaindia", "Porquinho-da-índia", "Guinea pig", "Conejillo de indias"));
        animalList.add(new Animal("rato", "Rato", "Rat", "Rata"));
        animalList.add(new Animal("sapo", "Sapo", "Toad", "Sapo"));
        animalList.add(new Animal("vaca", "Vaca", "Cow", "Vaca"));
    }

    @Override
    public void onClickAnimal(int position) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("SendData", animalList.get(position));
        startActivity(intent);
        finish();
    }
}