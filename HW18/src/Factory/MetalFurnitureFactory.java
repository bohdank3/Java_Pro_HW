package Factory;

public class MetalFurnitureFactory implements FurnitureFactory{
    @Override
    public Furniture createFurniture(){
        return new Chair();
    }
}
