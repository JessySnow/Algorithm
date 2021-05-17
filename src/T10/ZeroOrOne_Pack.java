package T10;

class GOODS{
    private int worth, weight;
    GOODS(int worth, int weight) { this.worth = worth; this.weight = weight; }
    public int getWorth() { return worth; }
    public int getWeight() { return weight; }
}

public class ZeroOrOne_Pack {

    //Capacity of Bag
    private static int Capacity = 300;
    private static int MAX_WORTH = 0, MAX_WEIGHT = 0;
    private static int Size = 10;

    public static void main(String[] args) {

        //Init a Goods array
        GOODS[] GoodsList = new GOODS[Size];
        GoodsList[0] = new GOODS(10, 10);
        GoodsList[1] = new GOODS(5, 10);
        GoodsList[2] = new GOODS(20, 15);
        GoodsList[3] = new GOODS(5, 10);
        GoodsList[4] = new GOODS(20, 40);
        GoodsList[5] = new GOODS(15, 40);
        GoodsList[6] = new GOODS(10, 30);
        GoodsList[7] = new GOODS(5, 15);
        GoodsList[8] = new GOODS(15, 40);
        GoodsList[9] = new GOODS(35, 10);

        //Bubble Sort the Array
        for (int i = Size - 1; i > 0; i --) {
            for (int j = 0; j < i ; j ++){
                if(GoodsList[j].getWorth() < GoodsList[j + 1].getWorth()){
                    GOODS temp;
                    temp = GoodsList[j];
                    GoodsList[j] = GoodsList[j + 1];
                    GoodsList[j + 1] = temp;
                }
                else if(GoodsList[j].getWorth() == GoodsList[j + 1].getWorth()){
                    if(GoodsList[j].getWeight() > GoodsList[j + 1].getWeight()){
                        GOODS temp;
                        temp = GoodsList[j];
                        GoodsList[j] = GoodsList[j + 1];
                        GoodsList[j + 1] = temp;
                    }
                }
            }
        }


        for (GOODS e : GoodsList){
            if (MAX_WORTH + e.getWeight() > Capacity)   break;
            MAX_WORTH += e.getWorth();
            System.out.println("Add: " + e.getWorth());
        }

        System.out.println("The MAX Worth: " + MAX_WORTH + "\n");
    }
}
