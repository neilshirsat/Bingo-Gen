package io.neilshirsat.ui.customize;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;

public class CustomizePanel extends JPanel {

    private GroupLayout CustomizePanelLayout;

    private CustomizeGrid CustomizeGrid;

    private BingoState State;

    public CustomizePanel(BingoState State) {
        super();
        this.State = State;

        CustomizePanelLayout = new GroupLayout(this);
        super.setLayout(CustomizePanelLayout);

        CustomizeGrid = new CustomizeGrid(State);

        CustomizePanelLayout.setHorizontalGroup(
                CustomizePanelLayout.createSequentialGroup()
                .addComponent(CustomizeGrid)
        );
        CustomizePanelLayout.setVerticalGroup(
                CustomizePanelLayout.createParallelGroup()
                        .addComponent(CustomizeGrid)
        );

    }

    public GroupLayout getCustomizePanelLayout() {
        return CustomizePanelLayout;
    }

    public void setCustomizePanelLayout(GroupLayout customizePanelLayout) {
        CustomizePanelLayout = customizePanelLayout;
    }

}
