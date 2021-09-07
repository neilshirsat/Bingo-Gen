package io.neilshirsat.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class FolderChooser extends TextField {

    public JFileChooser filechooser;

    public JFrame FolderChooserWindow;

    public FolderChooser( String name ) {
        super();

        super.label.setText(name);

        filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        FolderChooserWindow = new JFrame();

        this.textField.setColumns(50);
        this.textField.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int option = FolderChooser.this.filechooser.showOpenDialog(
                                FolderChooser.this.FolderChooserWindow);
                        if(option == JFileChooser.APPROVE_OPTION){
                            File file = FolderChooser.this.filechooser.getSelectedFile();
                            FolderChooser.this.textField.setText(file.getAbsolutePath());
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                }
        );

    }

}
