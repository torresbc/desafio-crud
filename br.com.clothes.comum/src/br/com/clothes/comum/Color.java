package br.com.clothes.comum;

public enum Color {
    BLUE(0), GREEN(1), YELLOW(2), RED(3), PINK(4), PURPLE(5), BLACK(6),
    WHITE(7), GRAY(8), ORANGE(9), BROWN(10);

    int idColor;

    Color(int idColor) {
        this.idColor = idColor;
    }

    public static Color CaseColor(int id){
        Color color;
        switch (id) {
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.YELLOW;
                break;
            case 3:
                color = Color.RED;
                break;
            case 4:
                color = Color.PINK;
                break;
            case 5:
                color = Color.PURPLE;
                break;
            case 6:
                color = Color.BLACK;
                break;
            case 7:
                color = Color.WHITE;
                break;
            case 8:
                color = Color.GRAY;
                break;
            case 9:
                color = Color.ORANGE;
                break;
            case 10:
                color = Color.BROWN;
                break;
            default:
                color = null;
        }
        return color;
    }

    public int getColor() {
        return idColor;
    }

}
