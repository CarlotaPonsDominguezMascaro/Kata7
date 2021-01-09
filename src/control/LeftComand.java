package control;

import model.Block;

public class LeftComand implements Comand {
    private final Block block;

    public LeftComand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        block.left();
    }
}
