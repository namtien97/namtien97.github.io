public class RectangleCompare {
    public static String rectangleCompare(Rectangle r1, Rectangle r2) {
        if ((Math.abs(r1.getX() - r2.getX()) <= Math.abs(r1.getWidth() - r2.getWidth()) / 2)
                && (Math.abs(r1.getY() - r2.getY()) <= Math.abs(r1.getHeight() - r2.getHeight()) / 2)
        ) {
            return "Nam trong nhau";
        } else if ((Math.abs(r1.getX() - r2.getX())
                <= Math.abs(r1.getWidth() + r2.getWidth()) / 2)
                && (Math.abs(r1.getY() - r2.getY())
                <= Math.abs(r1.getHeight() + r2.getHeight()) / 2)) {
            return "Giao nhau";
        } else {
            return "Nam ngoai nhau";
        }
    }
}
