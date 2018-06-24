package com.woodpecker;

import com.woodpecker.entity.ComicEntity;
import com.woodpecker.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final int RANGE = 1000;
    @Autowired
    private ComicService comicService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args){
        int countComic=0;
        int falseAttempt=0;

        while (countComic<10 && falseAttempt<100){
            int randomNum = (int) (Math.random() * RANGE);
            JsonObject comic = getComic(randomNum);
            if(comic != null){
                saveComic(comic);
                countComic++;
            }
            else{
                falseAttempt++;
            }
        }
    }

    private JsonObject getComic(int number){
        String url = "https://xkcd.com/" + number + "/info.0.json";
        JsonReader jsonReader = null;

        try {
            URL obj = new URL(url);
            HttpURLConnection con;
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            InputStream is = con.getInputStream();
            jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();

            return jsonObject;
        }
        catch (IOException  e) {
            e.printStackTrace();
            return null;
        }
        finally {
            if(jsonReader!=null) {
                jsonReader.close();
            }
        }
    }

    private void saveComic(JsonObject comicJson) {
        ComicEntity comicEntity = new ComicEntity();
        comicEntity.setNum(comicJson.getInt("num"));
        comicEntity.setImg(comicJson.getString("img"));
        comicEntity.setTitle(comicJson.getString("title"));
        comicEntity.setTranscript(comicJson.getString("transcript"));
        comicService.save(comicEntity);
    }
}