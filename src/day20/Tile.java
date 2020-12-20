package day20;

public class Tile {
    public static final int TILE_SIZE = 10;
    public static final int CROPPED_TILE_SIZE = 8;
    private final int id;
    private char[][] image;
    private Tile top;
    private Tile right;
    private Tile bottom;
    private Tile left;
    private boolean locked = false;

    public Tile(String input) {
        String[] lines = input.split("\n");
        id = Integer.parseInt(lines[0].substring(5, 9));

        image = new char[TILE_SIZE][TILE_SIZE];

        for (int row = 1; row < lines.length; row++) {
            image[row - 1] = lines[row].toCharArray();
        }
    }

    public void rotate() {
        if (locked) return;

        char[][] rotatedImage = new char[TILE_SIZE][TILE_SIZE];

        for (int row = 0; row < image.length; row++) {
            for (int column = 0; column < image[row].length; column++) {
                rotatedImage[column][image.length - row - 1] = image[row][column];
            }
        }

        image = rotatedImage;
    }

    public void flip() {
        if (locked) return;

        char[][] flippedImage = new char[TILE_SIZE][TILE_SIZE];

        for (int row = 0; row < image.length; row++) {
            flippedImage[image.length - row - 1] = image[row];
        }

        image = flippedImage;
    }

    public String getTopBorder() {
        return new String(image[0]);
    }

    public String getBottomBorder() {
        return new String(image[image.length - 1]);
    }

    public String getRightBorder() {
        StringBuilder stringBuilder = new StringBuilder();

        for (char[] row : image) {
            stringBuilder.append(row[row.length - 1]);
        }

        return stringBuilder.toString();
    }

    public String getLeftBorder() {
        StringBuilder stringBuilder = new StringBuilder();

        for (char[] row : image) {
            stringBuilder.append(row[0]);
        }

        return stringBuilder.toString();
    }

    public boolean isEdge() {
        int numberOfAdjacentTiles = 0;

        if (top != null) numberOfAdjacentTiles++;
        if (right != null) numberOfAdjacentTiles++;
        if (bottom != null) numberOfAdjacentTiles++;
        if (left != null) numberOfAdjacentTiles++;

        return numberOfAdjacentTiles == 2;
    }

    public char[][] getCroppedImage() {
        char[][] croppedImage = new char[CROPPED_TILE_SIZE][CROPPED_TILE_SIZE];

        for (int row = 0; row < croppedImage.length; row++) {
            for (int column = 0; column < croppedImage[row].length; column++) {
                croppedImage[row][column] = image[row + 1][column + 1];
            }
        }

        return croppedImage;
    }

    public int getId() {
        return id;
    }

    public Tile getTop() {
        return top;
    }

    public void setTop(Tile top) {
        this.top = top;
    }

    public Tile getRight() {
        return right;
    }

    public void setRight(Tile right) {
        this.right = right;
    }

    public Tile getBottom() {
        return bottom;
    }

    public void setBottom(Tile bottom) {
        this.bottom = bottom;
    }

    public Tile getLeft() {
        return left;
    }

    public void setLeft(Tile left) {
        this.left = left;
    }

    public void lock() {
        locked = true;
    }

    public boolean isLocked() {
        return locked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        return id == tile.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
