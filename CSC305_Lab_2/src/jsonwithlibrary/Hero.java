package jsonwithlibrary;

import java.util.List;
import com.fasterxml.jackson.annotation.*;

public class Hero {
    static class Award {
        // award members
        public String name;
        public int year;
    
        @JsonIgnore
        public void print() {
            StringBuilder s = new StringBuilder();
            s.append("\t").append(this.name).append(", ").append(this.year);
            System.out.println(s.toString());
        }
    
        @JsonCreator
        private Award(@JsonProperty("name")String name, @JsonProperty("year")int year) {
            this.name = name;
            this.year = year;
        }
    
    }
   
    public List<Award> awards;
    public List<String> knownFor;
    public String name;

    @JsonIgnore
    public void print() {
        System.out.println(this.name);
        System.out.println("Known For:");
        for (String attribute : this.knownFor) {
            System.out.println("\t" + attribute);
        }
        System.out.println("Awards:");
        for (Award award : this.awards) {
            award.print();
        }
        System.out.println("");
    }

    @JsonCreator
    private Hero(@JsonProperty("name") String name, @JsonProperty("knownFor") List<String> knownFor, @JsonProperty("awards") List<Award> awards) {
        this.awards = awards;
        this.name = name;
        this.knownFor = knownFor;
    }

}
