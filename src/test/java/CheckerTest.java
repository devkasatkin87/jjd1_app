import org.junit.Assert;
import org.junit.Test;
import utils.Checker;

import java.util.LinkedList;

public class CheckerTest {

    Checker checker = new Checker();

    @Test
    public void testValidateIP_rightIP() {
        Assert.assertTrue(checker.validateIp("192.168.10.10"));
    }

    @Test
    public void testValidateIP_withZero() {
        Assert.assertTrue(checker.validateIp("0.0.0.0"));
    }

    @Test
    public void testValidateIP_characters() {
        Assert.assertFalse(checker.validateIp("asdasdasd"));
    }

    @Test
    public void testValidateIP_symbols() {
        Assert.assertFalse(checker.validateIp("**.00.11....!!"));
    }

    @Test
    public void testValidateIP_space() {
        Assert.assertFalse(checker.validateIp("  168.192.10.10  "));
    }

    @Test
    public void testValidateIP_innerSpace() {
        Assert.assertFalse(checker.validateIp("168. 192.10.10"));
    }

    @Test
    public void testCheckFromBL_IPinBL() {
        LinkedList<String> list = new LinkedList<>();

        list.add("192.168.10.10");
        list.add("192.112.10.101");
        list.add("0.112.0.12");
        list.add("001.111.10.56");

        Assert.assertFalse(checker.checkFromBL("192.168.10.10", list));
        Assert.assertFalse(checker.checkFromBL("192.112.10.101", list));
        Assert.assertFalse(checker.checkFromBL("0.112.0.12", list));
    }

    @Test
    public void testCheckFromBL_IPNotInBL() {
        LinkedList<String> list = new LinkedList<>();

        list.add("192.168.10.10");
        list.add("192.112.10.101");
        list.add("0.112.0.12");
        list.add("001.111.10.56");

        Assert.assertTrue(checker.checkFromBL("101.10.10.10", list));
        Assert.assertTrue(checker.checkFromBL("128.10.10.192", list));
    }
}
