import static org.junit.Assert.*;
import org.junit.Test;

public class BaitTest {
 
 @Test
 public void printInt() {
  byte[] bs = {
   (byte)0x00,
   (byte)0x00,
   (byte)0x00,
   (byte)0x16,
   (byte)0x04
  };

  int address = (bs[0] << 32) | (bs[1] << 24) | 
                (bs[2] << 16) | (bs[3] << 8) | bs[4];

  System.out.println("address (int) = [" + address + "]");
  System.out.printf("address (hex) = [%X]\n", address);

  assertTrue(5636 == address);
 }
}