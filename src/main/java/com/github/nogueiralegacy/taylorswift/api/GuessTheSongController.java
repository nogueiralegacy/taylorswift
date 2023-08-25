package com.github.nogueiralegacy.taylorswift.api;

import com.github.nogueiralegacy.taylorswift.domain.GuessTheSong;
import com.github.nogueiralegacy.taylorswift.domain.Song;
import com.github.nogueiralegacy.taylorswift.utils.GuessRequestDTO;
import com.github.nogueiralegacy.taylorswift.utils.GuessResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/guess-the-song")
public class GuessTheSongController {
    private final GuessTheSong guessTheSong;

    public GuessTheSongController(GuessTheSong guessTheSong) {
        this.guessTheSong = guessTheSong;
    }

    @GetMapping("/all-songs")
    public Map<String, Song> allSongs() {
        return guessTheSong.getSongs();
    }

    @GetMapping("/score")
    public int score() {
        return guessTheSong.getScore();
    }

    @PostMapping("/guess")
    public ResponseEntity guess(@RequestBody GuessRequestDTO guessRequest) {
        if (guessRequest == null) {
            return ResponseEntity.badRequest().body("Song name is required");
        }
        if (guessRequest.songName() == null || guessRequest.songName().isEmpty()) {
            return ResponseEntity.badRequest().body("Song name is required");
        }

        String songName = guessRequest.songName();
        if (guessTheSong.isAlreadyGuessed(songName)) {
            return ResponseEntity.badRequest().body(songName + "already guessed");
        }

        String guessVerification = guessTheSong.guess(songName) ? "correct" : "incorrect";

        int remaining = guessTheSong.getSongs().size() - guessTheSong.getGuessedSongs().size();
        return ResponseEntity.ok(new GuessResponseDTO(guessVerification, guessTheSong.getScore(), guessTheSong.getGuessedSongs(), remaining));
    }
}
