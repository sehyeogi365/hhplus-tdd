package io.hhplus.tdd.point;

public record PointHistory(
        long id,
        long userId,
        long amount,
        TransactionType type,
        long updateMillis
) {

    public PointHistory(long id, long userId, long amount, TransactionType type, long updateMillis) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.updateMillis = updateMillis;
    }
}
