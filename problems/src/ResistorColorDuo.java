public class ResistorColorDuo {
    public int value(String[] arr) {
        return Integer.parseInt(color(arr[0]) + color(arr[1]));
    }
    String color(String color) {
        String colorVal = "";
        switch (color) {
            case "black": colorVal = "0"; break;
            case "brown": colorVal = "1"; break;
            case "red": colorVal = "2"; break;
            case "orange": colorVal = "3"; break;
            case "yellow": colorVal = "4"; break;
            case "green": colorVal = "5"; break;
            case "blue": colorVal = "6"; break;
            case "violet" : colorVal = "7"; break;
            case "grey": colorVal = "8"; break;
            case "white": throw new IllegalArgumentException("Invalid color");
            default:
        }
        return colorVal;
    }
}