package io.neilshirsat.components;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Select<T> extends JPanel {

    private JLabel SelectLabel;

    private JComboBox<T> SelectList;

    private DefaultComboBoxModel<T> Model;

    T[] Options;

    public Select( T[] Options ) {
        super();

        this.Options = Options;

        SelectLabel = new JLabel();
        SelectList = new JComboBox<>(Options);
        Model = new DefaultComboBoxModel<>();

        super.add( SelectLabel );
        super.add( SelectList );

        if ( super.getLayout() instanceof FlowLayout fl ) {
            fl.setAlignment( FlowLayout.LEFT );
        }

        super.setPreferredSize(new Dimension(250, 50));
        super.setMaximumSize(new Dimension(1000, 50));
    }

    public void setEditable(boolean editable) {
        this.SelectList.setEditable( editable );
    }

    public void setSelectOption( T[] Options ) {
        this.Options = Options;
        Model.addAll(Arrays.asList((Options)));
    }

    public void setLabel( String label ) {
        this.SelectLabel.setText(label);
    }

}
