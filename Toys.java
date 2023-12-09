import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class Toys {
    private String id;
    private String name;
    private int frequency;

    public Toys(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }
    public static void main(String[] args) {

        Toys toy1 = new Toys("1", "Лего", 5);
        Toys toy2 = new Toys("2", "Три кота", 2);
        Toys toy3 = new Toys("3", "Эльза", 3);
        PriorityQueue<Toys> toyQueue = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);
        try {
            FileWriter writer = new FileWriter("play.txt");
            for(int i = 0; i < 10; i++){
                Toys toy = toyQueue.peek();
                if(toy != null){
                    writer.write(toy.id + " "+ toy.name + "\n");
                    toy.frequency--;
                    if(toy.frequency == 0){
                        toyQueue.remove(toy);
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
