package database;

import entities.*;
import vista.View;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Product> trees;
    private List<Product> flowers;
    private List<Product> decorations;
    private List<Ticket> tickets;

    public Database() {

        trees = new ArrayList<>();
        flowers = new ArrayList<>();
        decorations = new ArrayList<>();
        tickets = new ArrayList<>();

    }

    public List<Product> getTrees() {
        return trees;
    }
    public List<Product> getFlowers(){ return flowers; }
    public List<Product> getDecorations(){ return decorations; }
    public List<Ticket> getTickets() {
        return tickets;
    }


    public void setTrees(List<Product> trees) {
        this.trees = trees;
    }
    public void setFlowers(List<Product> flowers) { this.flowers = flowers; }
    public void setDecorations(List<Product> decorations) { this.decorations = decorations; }
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    // Métodos de escritura y lectura de archivos.

    public void writeDataToFiles() {
        ObjectOutputStream writeFile = null;
        try {
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(Path.of("database/trees_db.txt"))));
            writeFile.writeObject(this.trees);
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(Path.of("database/flowers_db.txt"))));
            writeFile.writeObject(this.flowers);
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(Path.of("database/decor_db.txt"))));
            writeFile.writeObject(this.decorations);
            writeFile = new ObjectOutputStream(new FileOutputStream(String.valueOf(Path.of("database/tickets_db.txt"))));
            writeFile.writeObject(this.tickets);
            writeFile.close();
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND.");
            e.printStackTrace();
        }
    }

    public void readDataFromFiles() {
        ObjectInputStream readFile = null;
        try {
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(Path.of("database/trees_db.txt"))));
            List<Product> newListTreesTest = (ArrayList<Product>) readFile.readObject(); // Hacemos cast porque readFile devuelve un Object.
            newListTreesTest.forEach(x -> {
                Tree tree = (Tree) x;
                System.out.println(tree.showInfo());
            });
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(Path.of("database/flowers_db.txt"))));
            List<Product> newListFlowersTest = (ArrayList<Product>) readFile.readObject();
            newListFlowersTest.forEach(x -> {
                Flower flower = (Flower) x;
                System.out.println(flower.showInfo());
            });
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(Path.of("database/decor_db.txt"))));
            List<Product> newListDecorTest = (ArrayList<Product>) readFile.readObject();
            newListDecorTest.forEach(x -> {
                Decor decor = (Decor) x;
                System.out.println(decor.showInfo());
            });
            readFile = new ObjectInputStream(new FileInputStream(String.valueOf(Path.of("database/tickets_db.txt"))));
            List<Ticket> newListTicketTest = (ArrayList<Ticket>) readFile.readObject();
            newListTicketTest.forEach(x -> View.showInfoTicket(x));
            readFile.close();
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("FILE NOT FOUND.");
            e.printStackTrace();
        }

    }

}
