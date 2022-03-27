package vista;

import entities.*;

import java.util.HashMap;
import java.util.List;


public class View {

    public void showStock(List<Product> trees, List<Product> flowers, List<Product> decorations) { //Falta añadir los otros productos
        System.out.println("TREES:");
        trees.forEach(x -> {
            Tree tree = (Tree) x;
            System.out.println("Id: " + tree.getId() +
                    " Name: " + tree.getName() +
                    " Height: " + tree.getHeight() +
                    " Price: " + tree.getPrice() + "€");
        });
        System.out.println("FLOWERS:");
        flowers.forEach(x -> {
            Flower flower = (Flower) x;
            System.out.println("Id: " + flower.getId() +
                    " Name: " + flower.getName() +
                    " Color: " + flower.getcolor() +
                    " Price: " + flower.getPrice() + "€");
        });
        System.out.println("DECORATIONS:");
        decorations.forEach(x -> {
            Decor decor = (Decor) x;
            System.out.println("Id: " + decor.getId() +
                    " Name: " + decor.getName() +
                    " Material: " + decor.getMaterial() +
                    " Price: " + decor.getPrice() + "€");
        });
    }

    public void showTotalValueFlorist(double totalValue){

        System.out.println(totalValue);

    }

    public void showStockByProduct(HashMap<String, Integer> stockProducts){
        System.out.println("TOTAL STOCK:");
        System.out.println("TREES STOCK: " + stockProducts.get("Trees"));
        System.out.println("FLOWERS STOCK: " + stockProducts.get("Flowers"));
        System.out.println("DECOR STOCK: " + stockProducts.get("Decorations"));
    }

    public void showInfoTicket (Ticket ticket){

        System.out.println("Ticket number: " + ticket.getNumTicket() +
                "\nDate: " + ticket.getDate());

        for (Product product: ticket.getProducts()){

            if (product instanceof Tree){

                Tree tree = (Tree) product;

                System.out.println(tree.showInfo());

            } else if (product instanceof Flower){

                Flower flower = (Flower) product;

                System.out.println(flower.showInfo());
            }
        }

        System.out.println("Total:" + ticket.getTotal());

    }

    public void showOldTickets(List<Ticket> oldTickets){

        oldTickets.forEach(x -> showInfoTicket(x));

    }

    public static void showRemoveMessageConfirmation(boolean exist){
        if(exist){
            System.out.println("Producto borrado con éxito.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

}
