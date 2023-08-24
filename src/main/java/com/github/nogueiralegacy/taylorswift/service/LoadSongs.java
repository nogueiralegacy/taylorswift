package com.github.nogueiralegacy.taylorswift.service;

import com.github.nogueiralegacy.taylorswift.domain.Song;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LoadSongs {
    private static Path songsPath;

    public LoadSongs(String fileSongsName) {
        songsPath = new Utils().getPath(fileSongsName);

    }

    public Set<Song> loadSongs() {
        Set<Song> songs = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(songsPath.toFile()))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] songData = line.split(";");
                songs.add(new Song(songData[0], songData[1], songData[2]));
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        return songs;
    }
}
