package geneticAlgorithm;

public class Collision 
{
    private int row;
    private int column;
    private boolean[][] collisionTable = new boolean[34][7];

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColumn() {
        return column;
    }

    public void setCollisonTable(boolean[][] collisionTable){
        this.collisionTable = collisionTable;
    }

    public boolean[][] getCollisionTable() {
        return collisionTable;
    }
}
