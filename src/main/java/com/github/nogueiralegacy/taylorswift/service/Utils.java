package com.github.nogueiralegacy.taylorswift.service;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    /**
     * Retorna caminho de um arquivo no diretório resources.
     *
     * @param fileName O nome do arquivo desejado no resources.
     *
     * @return Retorna o caminho para o arquivo no diretório resources.
     */
    public Path getPath(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        URI uri = null;

        try {
            uri = resource.toURI();
        } catch (Exception exp) {
            return null;
        }

        return Paths.get(uri);
    }
}
