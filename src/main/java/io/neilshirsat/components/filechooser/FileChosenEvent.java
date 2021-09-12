package io.neilshirsat.components.filechooser;

import java.io.File;

public class FileChosenEvent {

    private java.io.File File;

    public FileChosenEvent(File File) {
        this.File = File;
    }

    public java.io.File getFile() {
        return File;
    }

    public void setFile(java.io.File file) {
        File = file;
    }

}
