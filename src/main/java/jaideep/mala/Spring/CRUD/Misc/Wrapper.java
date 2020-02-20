package jaideep.mala.Spring.CRUD.Misc;


import java.util.Random;

public class Wrapper {

    //private static final NissanLogger logger = NissanLogManager.getLogger(Helper.class);
    private static Random random = new Random();

    private Wrapper() {
    }
    public static boolean isValid(Object object) {
        boolean ret = false;
        if (object == null)
            return true;
        if (object.getClass().equals(String.class)) {
            ret = ((String) object).trim().isEmpty();
            return ret;
        }
        return ret;
    }
}