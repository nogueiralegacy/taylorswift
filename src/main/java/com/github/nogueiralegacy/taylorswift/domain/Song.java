package com.github.nogueiralegacy.taylorswift.domain;

import lombok.Data;

@Data
public class Song {
    private String name;
    private String album;
    private String lyrics;

    public Song(String name, String album, String lyrics) {
        this.name = name;
        this.album = album;
        this.lyrics = lyrics;
    }
}
