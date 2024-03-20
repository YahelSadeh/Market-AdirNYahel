package com.example.myfragments3.mainactivity;


public class DataModel {
    private String name;
    private int image;
    private int price;
    private String amount;
    private int calcPrice;

    public String getCalcPrice() {
        return String.valueOf(this.calcPrice);
    }
    public String getAmount() {
        return amount;
    }
    public DataModel(String name, int image, String amount ) {
        this.name = name;
        this.image = image;
        this.amount=amount;
    }
    public DataModel(String name, int image, String amount, int price ) {
        this.name = name;
        this.image = image;
        this.amount = amount;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public int getImage() {
        return image;
    }
    public String getPrice(){return String.valueOf(this.price);}
    public void addAmount(int position) {
        // Parse the string to an integer
        int currentAmount = Integer.parseInt(MyData.amount[position]);

        // Increment the amount by one
        currentAmount++;
        this.amount=String.valueOf(currentAmount);

        // Convert the incremented amount back to a string
        MyData.amount[position] = String.valueOf(currentAmount);
    }
    public void subAmount(int position) {
        // Parse the string to an integer
        int currentAmount = Integer.parseInt(MyData.amount[position]);

        if (currentAmount > 0) {
            currentAmount--;
            this.amount = String.valueOf(currentAmount);
            // Convert the incremented amount back to a string
            MyData.amount[position] = String.valueOf(currentAmount);
        }
    }
    void calcPricee(int position){
        int currentAmount = Integer.parseInt(MyData.amount[position]);

        this.calcPrice = currentAmount * MyData.price[position];
    }
    String updatedAmount(int position){

        int currentAmount = Integer.parseInt(MyData.amount[position]);
        int updatedAmount = currentAmount*this.price;
        this.calcPrice = updatedAmount;
        return String.valueOf(this.calcPrice);
    }

}

