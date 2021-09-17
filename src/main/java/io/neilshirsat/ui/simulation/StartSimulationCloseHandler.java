package io.neilshirsat.ui.simulation;

public interface StartSimulationCloseHandler {
    void handle(
            int board,
            int days,
            int seed,
            int winners
    );
}
