package com.github.nogueiralegacy.taylorswift.utils;

import com.github.nogueiralegacy.taylorswift.domain.Song;
import java.util.Map;

public record GuessResponseDTO(String guessVerification, int score, Map<String, Song> guessedSongs, int remaining){}