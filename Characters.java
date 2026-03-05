class Characters {
    protected static int money;
    protected static int points;

    Characters(int money, int points) {
        Characters.money = money;
        Characters.points = 0;

    }
}

class Enemies {
    static int money;
    static int points;
    static String name;
    Enemies(String name, int money, int points) {


        Enemies.money = money;
        Enemies.points = 0;
        Enemies.name = name;

    }
    public String stats() {
        return """
                %s |Money: %d
                Your money: %d
                """.formatted(Enemies.name, Enemies.money, Characters.money);
    }
}



