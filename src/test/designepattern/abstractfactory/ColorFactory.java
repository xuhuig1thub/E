package test.designepattern.abstractfactory;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 0:31
 */
public class ColorFactory extends AbstractFactory {

    @Override
    Shape getShape(String shape) {
        return null;
    }

    @Override
    Color getColor(String color) {
        if (color == null) {
            return null;
        }

        color = color.toLowerCase();
        switch (color) {
            case "red":
                return new Red();
            case "blue":
                return new Blue();
            case "green":
                return new Green();
            default:
                return null;
        }
    }

}
