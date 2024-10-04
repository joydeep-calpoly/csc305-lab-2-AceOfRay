package jsonwithjava;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class ImmortalizedHero {
    // nested class: award
    private class Award {
        // award members
        private final String name;
        private final int year;

        Award(JSONObject award) {
            this.name = award.getString("name");
            this.year = award.getInt("year");
        }

        private void print() {
            StringBuilder s = new StringBuilder();
            s.append("\t").append(this.name).append(", ").append(this.year);
            System.out.println(s.toString());
        }
    }

    // immortalized hero members
    private final List<Award> awards;
    private final List<String> knownFors;
    private final String name;

    ImmortalizedHero(JSONObject json) {
        this.awards = this.parseAwards(json);
        this.knownFors = this.parseKnownFors(json);
        this.name = json.getString("name");
    }

    private List<Award> parseAwards(JSONObject json) {
        List<Award> result = new ArrayList<>();
        json.getJSONArray("awards").forEach(award -> result.add(new Award((JSONObject)award)));
        return result;
    }

    private List<String> parseKnownFors(JSONObject json) {
        List<String> result = new ArrayList<>();
        json.getJSONArray("knownFor").forEach(action -> result.add((String) action));    
        return result;
    }

    public void print() {
        System.out.println(this.name);
        System.out.println("Known For:");
        for (String attribute : this.knownFors) {
            System.out.println("\t" + attribute);
        }
        System.out.println("Awards:");
        for (Award award : this.awards) {
            award.print();
        }
        System.out.println("");
    }

    
}
