interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        // This method is intentionally left unimplemented for demo purposes
        throw new UnsupportedOperationException("Draw not implemented yet");
    }
}
