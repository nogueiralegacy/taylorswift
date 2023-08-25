package com.github.nogueiralegacy.taylorswift.domain;

import com.github.nogueiralegacy.taylorswift.service.LoadSongs;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class GuessTheSong {
    private final Map<String, Song> songs;
    // One point for each correct guess
    private int score;
    private Map<String, Song> guessedSongs;

    public GuessTheSong() {
        this.songs = new LoadSongs("taylorSongs.csv").loadSongs();
        this.score = 0;
        this.guessedSongs = new HashMap<>();
    }
    public boolean guess(String songName) throws IllegalArgumentException {
        if (isCorrectGuess(songName)) {
            score++;
            guessedSongs.put(songName.toLowerCase(), songs.get(songName.toLowerCase()));
            return true;
        }

        return false;
    }

    public boolean isAlreadyGuessed(String songName) {
        return guessedSongs.containsKey(songName.toLowerCase());
    }

    private boolean isCorrectGuess(String songName) {
        return songs.containsKey(songName.toLowerCase());
    }
}
