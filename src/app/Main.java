package app;

import control.*;
import model.Block;
import view.BlockDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;



public class Main extends JFrame {


    private HashMap<String,Comand> commands;
    private BlockPresenter blockPresenter;

    public static void main(String[] agrv){
        new Main().executed();
    }

    private static final int SIZE = 100;
    private Block block;
    private BlockDisplay blockDiplay;

    public Main(){
        this.setTitle("Block shifter");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700,762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().add(blockPanel());
        this.add(toolBar(),BorderLayout.SOUTH);
    }



    private void executed() {
        this.block = new Block(4,4);
        this.blockPresenter = new BlockPresenter(SIZE,block, blockDiplay);
        this.commands = createComands();
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel blockPanel = new BlockPanel(Block.MAX,SIZE);
        this.blockDiplay = blockPanel;
        return blockPanel;
    }

    private HashMap<String,Comand> createComands(){
        HashMap<String,Comand>  commands = new HashMap<String,Comand>() ;
        commands.put("L",new LeftComand(block));
        commands.put("R",new RightCommand(block));
        commands.put("U",new UpCommand(block));
        commands.put("D", new DownCommand(block));
        return commands;
    }

    private Component toolBar() {
        JMenuBar jMenuBar= new JMenuBar();
        jMenuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        jMenuBar.add(button("L"));
        jMenuBar.add(button("R"));
        jMenuBar.add(button("U"));
        jMenuBar.add(button("D"));
        return jMenuBar;
    }

    private JButton button(String title) {
        JButton jButton= new JButton(title);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(title).execute();
            }
        });
        return jButton;
    }
}
