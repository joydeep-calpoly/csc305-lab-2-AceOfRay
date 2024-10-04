package jsonwithlibrary;

public class Award {
    // award members
    public String name;
    public int year;

    public void print() {
        StringBuilder s = new StringBuilder();
        s.append("\t").append(this.name).append(", ").append(this.year);
        System.out.println(s.toString());
    }

}
