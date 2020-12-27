public class Acronym {
    private String word;
    public Acronym(String word) { this.word = word; }
    public String get() {
        String acr = "";
        word = word.replace("-", " ").replace("_", " ");
        while (word.contains("  ")) word = word.replace("  ", " ");
        String[] words = word.split(" ");
        for (int i = 0; i < words.length; i++) acr += words[i].trim().substring(0, 1).toUpperCase();
        return acr;
    }
}