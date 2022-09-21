package Strategy;

public enum PieceType {
    KINGBLACK("KingBlack", "KingBlack.jpg"),
    QUEENBLACK("QueenBlack", "QueenBlack.jpg"),
    CARBLACK("CarBlack", "CarBlack.jpg"),
    HORSEBLACK("HorseBlack", "HorseBlack.jpg"),
    SOLDIERBLACK("SoldierBlack", "SoldierBlack.jpg"),
    KNIGHTBLACK("KnightBlack", "KnightBlack.jpg"),

    KINGWHITE("KingWhite", "KingWhite.jpg"),
    QUEENWHITE("QueenWhite", "QueenWhite.jpg"),
    CARWHITE("CarWhite", "CarWhite.jpg"),
    HORSEWHITE("HorseWhite", "HorseWhite.jpg"),
    SOLDIERWHITE("SoldierWhite", "SoldierWhite.jpg"),
    KNIGHTWHITE("KnightWhite", "KnightWhite.jpg");


    private String desc;
    private PieceType(String desc,String url ){
        this.desc = desc;
        this.url = url;
    }

    private String url;

    public String getDesc(){
        return desc;
    }

    public String getUrl() {
        return url;
    }
}