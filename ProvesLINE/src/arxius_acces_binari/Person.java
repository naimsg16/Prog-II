package arxius_acces_binari;
import utils.PackUtils;

public class Person {

    private final long id;
    private final String name;
    private final int age;
    private final boolean married;
    private static final int NAME_LIMIT = 20;
    private static final int SIZE = 8 + 2 * NAME_LIMIT + 4 + 1;


    public Person (long id, String name, int age, boolean married){
        this.id = id;
        this.name = name;
        this.age = age;
        this.married = married;
    }

    public byte[] toBytes(){
        byte[] record = new byte[SIZE];
        int offset = 0;
        PackUtils.packLong(this.id,record,offset);
        offset += 8;
        PackUtils.packLimitedString(this.name,NAME_LIMIT,record,offset);
        offset += 2 * NAME_LIMIT;
        PackUtils.packInt(this.age,record,offset);
        offset += 4;
        PackUtils.packBoolean(this.married,record,offset);
        return record;
    }

    public static Person fromBytes(byte[] record){
        int offset = 0;
        long id =  PackUtils.unpackLong(record,offset);
        offset += 8;
        String name = PackUtils.unpackLimitedString(NAME_LIMIT,record,offset);
        offset += 2 * NAME_LIMIT;
        int age = PackUtils.unpackInt(record,offset);
        offset += 4;
        boolean married = PackUtils.unpackBoolean(record,offset);
        return new Person(id,name,age,married);
    }

}
