package jsonwithlibrary;

import java.util.List;

public class Hero {
    
    public Award[] awards;
    public List<String> knownFor;
    public String name;

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

}
