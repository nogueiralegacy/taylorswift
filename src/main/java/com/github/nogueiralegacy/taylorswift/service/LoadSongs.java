package com.github.nogueiralegacy.taylorswift.service;

import com.github.nogueiralegacy.taylorswift.domain.Song;
import com.github.nogueiralegacy.taylorswift.utils.Utils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LoadSongs {
    private static Path songsPath;

    public LoadSongs(String fileSongsName) {
        songsPath = new Utils().getPath(fileSongsName);

    }

    public Map<String, Song> loadSongs() {
        Map<String, Song> songs = new HashMap<>();

        try (Reader reader = new FileReader(songsPath.toFile())) {
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord csvRecord : csvParser) {
                String songName = csvRecord.get(0).toLowerCase();

                songs.put(songName, new Song(songName, null, null));
            }
        } catch (IOException exp) {
            exp.printStackTrace();
        }

        return songs;
    }
}
