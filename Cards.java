class Card {
    String suit, rank; int value;

    Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.value = 0;

        switch (rank) {
            case "A" -> this.value = 14;
            case "K" -> this.value = 13;
            case "Q" -> this.value = 12;
            case "J" -> this.value = 11;
            default -> this.value = Integer.parseInt(rank);

        }
    }
    @Override
    public String toString() {
        return rank + suit;
    }
}