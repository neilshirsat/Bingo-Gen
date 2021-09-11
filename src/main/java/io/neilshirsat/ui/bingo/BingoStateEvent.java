package io.neilshirsat.ui.bingo;

public class BingoStateEvent {

    private long BingoId;

    private BingoProperties PropertyChanged;

    public BingoStateEvent( long BingoId, BingoProperties PropertyChanged ) {
        this.BingoId = BingoId;
        this.PropertyChanged = PropertyChanged;
    }

    public long getBingoId() {
        return BingoId;
    }

    public void setBingoId(long bingoId) {
        BingoId = bingoId;
    }

    public BingoProperties getPropertyChanged() {
        return PropertyChanged;
    }

    public void setPropertyChanged(BingoProperties propertyChanged) {
        PropertyChanged = propertyChanged;
    }

}
