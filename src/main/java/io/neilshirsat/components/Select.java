package io.neilshirsat.components;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Select<T> extends JPanel {

    /**
     * The Label of the Select Box
     */
    private JLabel SelectLabel;

    /**
     * The ComboBox the of the Select Box
     */
    private JComboBox<T> SelectList;

    /**
     * The ComboBox Model of the Select Box
     */
    private DefaultComboBoxModel<T> Model;

    /**
     * The Options of the Select
     */
    private T[] Options;

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

    public JLabel getSelectLabel() {
        return SelectLabel;
    }

    public void setSelectLabel(JLabel selectLabel) {
        SelectLabel = selectLabel;
    }

    public JComboBox<T> getSelectList() {
        return SelectList;
    }

    public void setSelectList(JComboBox<T> selectList) {
        SelectList = selectList;
    }

    public DefaultComboBoxModel<T> getModel() {
        return Model;
    }

    public void setModel(DefaultComboBoxModel<T> model) {
        Model = model;
    }

    public T[] getOptions() {
        return Options;
    }

    public void setOptions(T[] options) {
        Options = options;
    }

    public void setEditable(boolean editable) {
        this.SelectList.setEditable( editable );
    }

    public boolean getEditable(boolean editable) {
        return this.SelectList.isEditable();
    }

    public void setSelectOption( T[] Options ) {
        this.Options = Options;
        Model.addAll(Arrays.asList((Options)));
    }

    public T[] getSelectOptions( T[] Options ) {
        return Options;
    }

    public void setLabel( String label ) {
        this.SelectLabel.setText(label);
    }

    public String getLabel() {
        return SelectLabel.getText();
    }

}
