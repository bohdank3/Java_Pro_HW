package Factory;

public class FurnitureMaker {
    public static void main(String[] args) {
        FurnitureFactory woodenFurnitureFactory = new WoodenFurnitureFactory();
        Furniture sofa = woodenFurnitureFactory.createFurniture();
        sofa.use();
        
        FurnitureFactory metalFurnitureFactory = new MetalFurnitureFactory();
        Furniture chair = metalFurnitureFactory.createFurniture();
        chair.use();
    }
}
