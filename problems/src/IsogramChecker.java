public class IsogramChecker {
    boolean isIsogram(String word) {
        word = word.toUpperCase();
        String cleared = "", isogram = "";
        for (int i = 0; i < word.length(); i++) {
            if (" -".contains(word.substring(i, i + 1))) continue;
            else cleared += word.substring(i, i + 1);
        }
        for (int i = 0; i < cleared.length(); i++) {
            if (isogram.contains(cleared.substring(i, i + 1))) return false;
            else isogram += cleared.substring(i, i + 1);
        }
        return true;
    }
}
