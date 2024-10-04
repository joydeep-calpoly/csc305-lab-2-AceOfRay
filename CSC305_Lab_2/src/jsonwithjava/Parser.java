package jsonwithjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Parser {
    private final List<String> inputPaths = Arrays.asList("input1.json", "input2.json", "input3.json");
    private List<ImmortalizedHero> heroes;

    public void printHeros() {
        this.heroes = this.buildHeroList();
        this.heroes.forEach(hero -> hero.print());
    }


    /*
     * for each path in inputPaths add the result of the parseJsonFile method to a list and return that
     */

    private List<ImmortalizedHero> buildHeroList() {
        return this.inputPaths.stream()
            .map(this::parseJsonFile)
            .collect(Collectors.toList());
}

    /*
     * turn the given path into one big string using Paths and Files
     * pass that into the JSONObject constructor
     * pass the JSON Object into the constructor of the ImmortalizedHero 
     * return that ImmortalizedHero
     */

    private ImmortalizedHero parseJsonFile(String path) {
        try {
            return new ImmortalizedHero(new JSONObject(new String(Files.readAllBytes(Paths.get(path)))));
        
        } catch (InvalidPathException | IOException e) {
            System.err.println(e);
            return null;
        } 
    }
}
