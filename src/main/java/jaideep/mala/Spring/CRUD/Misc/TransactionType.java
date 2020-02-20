package jaideep.mala.Spring.CRUD.Misc;


public enum TransactionType {

    DEBIT(1), CREDIT(2);
    int id;

    private TransactionType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }



}