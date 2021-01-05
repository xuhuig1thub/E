package test.designepattern.abstractfactory;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:30
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }

        shape = shape.toLowerCase();

        switch (shape) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }

    }

    @Override
    Color getColor(String color) {
        return null;
    }

}
