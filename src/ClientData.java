public class ClientData {
    /*
    This class is a simplified version of the Ship class in the game client
    it will not contain SHIP_STATS records, or references to modules.
    to support PvP fights ther will be methods to pass weapons between clients.
    */
    private int x = 0, y = 0;
    private int health;
    private int currency;

    public void updatePosition(int newX, int newY)
    {
        this.x = newX;
        this.y = newY; 
    }

    public void updateHealth(int newHealth)
    {
        this.health = newHealth;
    }

    public void updateCurrency(int newCurrency)
    {
        this.currency = newCurrency;
    }
}
