package io.neilshirsat.components.filechooser;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class FileChooser extends io.neilshirsat.components.textfield.TextField {

    private JFileChooser FileSelect;

    private JFrame FolderChooserWindow;

    private int Files;

    private FileActionListener ActionListener;

    public FileChooser(String name, int Files, FileFilter FileFilter) {
        super();

        super.setLabelText(name);

        this.Files = Files;

        FolderChooserWindow = new JFrame();

        this.setInputColumns(40);
        this.getTextField().addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        FileSelect = new JFileChooser();
                        FileSelect.setFileSelectionMode(Files);
                        FileSelect.setFileFilter(FileFilter);
                        int option = FileChooser.this.FileSelect.showOpenDialog(
                                FileChooser.this.FolderChooserWindow);
                        FileSelect.updateUI();
                        if(option == JFileChooser.APPROVE_OPTION){
                            File file = FileChooser.this.FileSelect.getSelectedFile();
                            FileChooser.this.getTextField().setText(file.getAbsolutePath());
                            ActionListener.FileChosen(new FileChosenEvent(file));
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

    public JFileChooser getFileSelect() {
        return FileSelect;
    }

    public void setFileSelect(JFileChooser fileSelect) {
        FileSelect = fileSelect;
    }

    public JFrame getFolderChooserWindow() {
        return FolderChooserWindow;
    }

    public void setFolderChooserWindow(JFrame folderChooserWindow) {
        FolderChooserWindow = folderChooserWindow;
    }

    public int getFiles() {
        return Files;
    }

    public void setFiles(int files) {
        Files = files;
    }

    public FileActionListener getActionListener() {
        return ActionListener;
    }

    public void setActionListener(FileActionListener actionListener) {
        ActionListener = actionListener;
    }

}
