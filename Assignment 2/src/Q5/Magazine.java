public class Magazine implements SaleableItem
{
    public Magazine()
    {

    }
    
    @Override
    public void sellCopy()
    {
        System.out.println("Selling a magazine.");
    }
}
