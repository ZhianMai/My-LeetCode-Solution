package string.decode;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JunitTest {
  private StringDecode stringDecode;
  private StringBuilder sb;

  @BeforeEach
  public void setUp() {
    stringDecode = new StringDecode();
    sb = new StringBuilder();
  }

  @Test
  @Order(1)
  @DisplayName("Test Junit functionality.")
  public void demoTestMethod() {
    assertTrue(true);
    assertTrue((stringDecode != null) && (sb != null), "Test object init.");
  }

  @Test
  @DisplayName("Case one single char.")
  public void testCaseOneSingle() {
    String result = stringDecode.decode("1");
    String solution = "a";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case one multiple char.")
  public void testCaseOneMultiple() {
    String result = stringDecode.decode("123456789");
    String solution = "abcdefghi";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case two single char.")
  public void testCaseTwoSingle() {
    String result = stringDecode.decode("11#12#13#14#15#");
    String solution = "klmno";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case two multiple char.")
  public void testCaseTwoMultiple() {
    String result = stringDecode.decode("123456789");
    String solution = "abcdefghi";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case three single char.")
  public void testCaseThreeSingle() {
    String result = stringDecode.decode("1(11)");
    String solution = "aaaaaaaaaaa";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case four single char.")
  public void testCaseFourSingle() {
    String result = stringDecode.decode("26#(11)");
    String solution = "zzzzzzzzzzz";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case four multiple char.")
  public void testCaseFourMultiple() {
    String result = stringDecode.decode("26#(11)25#(11)24#(11)");
    String solution = "zzzzzzzzzzz" + "yyyyyyyyyyy" + "xxxxxxxxxxx";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case three & four long char.")
  public void testCaseThreeFourSingleLong() {
    String result = stringDecode.decode("26#(111)1(1111)");
    sb.setLength(0);
    buildString(sb, 111, 'z');
    buildString(sb, 1111, 'a');

    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Case one & two part A.")
  public void testCaseOneTwoA() {
    String result = stringDecode.decode("12324#25#26#123");
    String solution = "abcxyzabc";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case one & two part B.")
  public void testCaseOneTwoB() {
    String result = stringDecode.decode("24#125#226#3" + "24#125#226#3");
    String solution = "xaybzc" + "xaybzc";
    assertTrue(result.equals(solution), "Output should be equal.");
  }

  @Test
  @DisplayName("Case three & Four part A.")
  public void testCaseThreeFourA() {
    String result = stringDecode.decode("1(11)2(11)" + "25#(11)26#(11)" + "1(11)2(11)");
    sb.setLength(0);
    buildString(sb, 11, 'a');
    buildString(sb, 11, 'b');
    buildString(sb, 11, 'y');
    buildString(sb, 11, 'z');
    buildString(sb, 11, 'a');
    buildString(sb, 11, 'b');

    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Case three & Four part B.")
  public void testCaseThreeFourB() {
    String result = stringDecode.decode("25#(11)26#(11)" + "1(11)2(11)" + "25#(11)26#(11)");
    sb.setLength(0);
    buildString(sb, 11, 'y');
    buildString(sb, 11, 'z');
    buildString(sb, 11, 'a');
    buildString(sb, 11, 'b');
    buildString(sb, 11, 'y');
    buildString(sb, 11, 'z');

    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Case One & Three part A.")
  public void testCaseOneThreeA() {
    String result = stringDecode.decode("1(11)" + "123");
    sb.setLength(0);
    buildString(sb, 11, 'a');
    sb.append("abc");

    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Case One & Three part B.")
  public void testCaseOneThreeB() {
    String result = stringDecode.decode("123" + "1(11)2(11)" + "123");
    sb.setLength(0);
    sb.append("abc");
    buildString(sb, 11, 'a');
    buildString(sb, 11, 'b');
    sb.append("abc");

    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Case mixed part A.")
  public void testAllCaseA() {
    String result = stringDecode.decode("12324#25#26#1(11)2(11)3(11)24#(11)25#(11)26#(11)");
    sb.setLength(0);
    sb.append("abcxyz");
    buildString(sb, 11, 'a');
    buildString(sb, 11, 'b');
    buildString(sb, 11, 'c');
    buildString(sb, 11, 'x');
    buildString(sb, 11, 'y');
    buildString(sb, 11, 'z');


    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Case mixed part B.")
  public void testAllCaseB() {
    String result = stringDecode.decode("24#(11)1231(11)25#26#2(11)");
    sb.setLength(0);
    buildString(sb, 11, 'x');
    sb.append("abc");
    buildString(sb, 11, 'a');
    sb.append("yz");
    buildString(sb, 11, 'b');

    assertTrue(result.equals(sb.toString()), "Output should be equal.");
  }

  @Test
  @DisplayName("Empty String test.")
  public void emptyString() {
    String result = stringDecode.decode("");

    assertTrue(result.equals(""), "Output should be equal.");
  }

  private void buildString(StringBuilder sb, int count, char ch) {
    while (count-- > 0) {
      sb.append(ch);
    }
  }
}
