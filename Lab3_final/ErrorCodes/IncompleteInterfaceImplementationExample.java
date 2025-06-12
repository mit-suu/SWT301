import java.util.logging.Logger;

interface Shape {
    void draw();
    void resize();
}

class Square implements Shape {
    private static final Logger logger = Logger.getLogger(Square.class.getName());

    public void draw() {
        logger.info("Drawing square");
    }

    public void resize() {
        logger.info("Resizing square");
    }
}
