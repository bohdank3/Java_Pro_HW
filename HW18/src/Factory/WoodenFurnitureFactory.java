package Factory;

public class WoodenFurnitureFactory implements FurnitureFactory{

    @Override
    public Furniture createFurniture() {
        return new Sofa();
    }
}
