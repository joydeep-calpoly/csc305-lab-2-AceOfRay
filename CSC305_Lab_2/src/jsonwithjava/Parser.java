package jsonwithjava;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Parser {
    private final String[] inputPaths = {"input1.json", "input2.json", "input3.json"};
    
    public void parseHeros() {
        for(ImmortalizedHero h : this.buildHeroList()) {
            System.out.println(h);
        }
    }

    private List<ImmortalizedHero> buildHeroList() {
        List<ImmortalizedHero> result = new ArrayList<>();

        for (String path : this.inputPaths) {
            result.add(this.parseJsonFile(path));
        }

        return result;
    }

    private ImmortalizedHero parseJsonFile(String path) {
        try {
            // turn file into one big string
            // pass that into the JSONObject constructor
            // pass the JSON Object into the constructor of the ImmortalizedHero
            // return that ImmortalizedHero
            return new ImmortalizedHero(new JSONObject(new String(Files.readAllBytes(Paths.get("input.json")))));
        
            
        } catch (InvalidPathException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
