package control;

import model.Block;

public class DownCommand implements Comand {
    private final Block block;

    public DownCommand(Block block) {
        this.block = block;
    }

    @Override
    public void execute() {
        block.down();
    }
}
