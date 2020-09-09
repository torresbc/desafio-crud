package br.com.clothes.comum;

public enum Size {
    P(0), M(1), G(2), GG(3);

    int idSize;

    Size(int idSize) {
        this.idSize = idSize;
    }

    /**
     *
     * @param id of the product Size, recorded in the repository
     * @return the size referring to the id
     */
    public static Size CaseSize(int id){
        Size size;
        switch (id) {
            case 0:
                size = Size.P;
                break;
            case 1:
                size = Size.M;
                break;
            case 2:
                size = Size.G;
                break;
            case 3:
                size = Size.GG;
                break;
            default:
                size = null;
        }
        return size;
    }

    public int getSize() {
        return idSize;
    }
}
