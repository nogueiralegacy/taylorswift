package com.github.nogueiralegacy.taylorswift.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Song {
    private String name;
    @JsonIgnore
    private String album;
    @JsonIgnore
    private String lyrics;

    public Song(String name, String album, String lyrics) {
        this.name = name;
        this.album = album;
        this.lyrics = lyrics;
    }
}
