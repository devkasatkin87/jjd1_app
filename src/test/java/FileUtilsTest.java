import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.ArrayComparisonFailure;
import utils.FileUtils;


public class FileUtilsTest {
    FileUtils fileUtils;
    @Test
    public void testReadDataFromFile() {
        fileUtils = new FileUtils("src/main/java/blacklist.txt");
        String[] testArray = {
                "178.14.179.226",
                "88.3.116.225",
                "68.132.255.187",
                "7.148.21.141",
                "106.74.190.9",
                "175.179.106.141",
                "243.22.145.52",
                "196.117.5.251",
                "201.192.3.140",
                "40.106.214.62",
        };
        Assert.assertArrayEquals(testArray, fileUtils.ReadDataFromFile().toArray());
    }

    @Test(expected = ArrayComparisonFailure.class)
    public void testReadDataFromFile_exceptionACF() {
         fileUtils = new FileUtils("blacklist.txt");
        String[] testArray = {
                "178.14.179.226",
                "88.3.116.225",
                "68.132.255.187",
                "7.148.21.141",
                "106.74.190.9",
                "175.179.106.141",
                "243.22.145.52",
                "196.117.5.251",
                "201.192.3.140",
                "40.106.214.62",
        };
        Assert.assertArrayEquals(testArray, fileUtils.ReadDataFromFile().toArray());
    }
}
