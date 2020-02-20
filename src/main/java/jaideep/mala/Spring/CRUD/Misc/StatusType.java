package jaideep.mala.Spring.CRUD.Misc;


public enum StatusType {
    SUCCESS("success"),FAIL("fail");

    private String status;

    StatusType(String status)
    {
        this.status=status;
    }

    public String status()
    {
        return status;
    }
}
