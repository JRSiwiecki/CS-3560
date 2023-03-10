import java.util.ArrayList;

public class Dog 
{
    private String breed;
    private String name;
    public ArrayList<Paw> paws;

    public Dog()
    {
        breed = null;
        name = null;
        paws = new ArrayList<Paw>();

        paws.add(new Paw(1, this));
        paws.add(new Paw(2, this));
        paws.add(new Paw(3, this));
        paws.add(new Paw(4, this));
    }
}
