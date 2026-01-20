public class Train {
    private String name, product, origin, destination;
    private int weight, miles;

    public Train(String n, String p, String o, String d, int w, int m){
        name = n;
        product = p;
        origin = o;
        destination = d;
        weight = w;
        miles = m;
    }

    public String getName(){
        return name;
    }

    public String getProduct(){
        return product;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public int getWeight(){
        return weight;
    }

    public int getMiles(){
        return miles;
    }

    public void resetMiles(){
        miles = 100;
    }

    public void printCar(){
        System.out.println("Car Name: " + name + ", Product: " + product + ", Origin: " + origin + ", Destination: " + destination + ", Weight: " + weight + ", Miles: " + miles);
        

    }

}
