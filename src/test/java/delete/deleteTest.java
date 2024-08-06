package delete;

import org.junit.Assert;
import org.junit.Test;

public class deleteTest {

    @Test
    public void sthTest(){
        Delete delete = new Delete();
        Assert.assertEquals(8,
                delete.sth(3,5)
        );
    }
}
