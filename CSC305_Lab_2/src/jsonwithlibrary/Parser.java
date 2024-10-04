package jsonwithlibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.json.JSONException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser {
    private static final List<String> inputPaths = Arrays.asList("input1.json", "input2.json", "input3.json");
    private final List<Hero> heroes = new ArrayList<>();

    public void printHeroes() {
        this.buildHeroes();
        this.heroes.forEach(hero -> {hero.print();});
    }

    private void buildHeroes() {
        ObjectMapper mapper = new ObjectMapper();
        inputPaths.forEach(path -> {
            try {
                Hero h = mapper.readValue(new File(path), Hero.class);
                this.heroes.add(h);
            } catch (JSONException | IOException e) {
                System.err.print(e);
            }

        });
    }
}
