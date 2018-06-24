package com.woodpecker.entity;

import javax.persistence.*;

@Entity
@Table(name="comic")
public class ComicEntity {
    @Id
    private int num;
    private String title;
    @Column(length=5000)
    private String transcript;
    private String img;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTranscript() {
        return transcript;
    }

    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
