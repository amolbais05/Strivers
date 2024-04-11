package java.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Generics
{
    /**
     * Covariance - accept subtypes
     * Contravariance - accept supertypes
     * */
    public static void main(String[] args)
    {
        List a = new ArrayList();

        List<?> b = new ArrayList<>();

        List<Object> c = new ArrayList<>();

        List<Integer> d = new ArrayList<>();
    }
}
