package xyz.enhorse.codeeval.moderate;

import junit.framework.TestCase;

/**
 * 02.12.2015.
 */
public class ColorCodeConverterTest extends TestCase {

    public void testCMYKMinValues() throws Exception {
        assertEquals("RGB(255,255,255)", ColorCodeConverter.convert("(0.00, 0.00, 0.00, 0.00)"));
    }

    public void testCMYKMaxValues() throws Exception {
        assertEquals("RGB(0,0,0)", ColorCodeConverter.convert("(1.00, 1.00, 1.00, 1.00)"));
    }

    public void testCMYKSimpleValues() throws Exception {
        assertEquals("RGB(110,15,197)", ColorCodeConverter.convert("(0.56, 0.94, 0.21, 0.02)"));
    }



    public void testHEXMinValues() throws Exception {
        assertEquals("RGB(0,0,0)", ColorCodeConverter.convert("#000000"));
    }

    public void testHEXMaxValues() throws Exception {
        assertEquals("RGB(255,255,255)", ColorCodeConverter.convert("#FFFFFF"));
    }

    public void testHEXSimpleValuesLowCase() throws Exception {
        assertEquals("RGB(207,169,196)", ColorCodeConverter.convert("#cfa9c4"));
    }

    public void testHEXSimpleValuesUpCase() throws Exception {
        assertEquals("RGB(207,169,196)", ColorCodeConverter.convert("#CFA9C4"));
    }



    public void testHSLMinValues() throws Exception {
        assertEquals("RGB(0,0,0)", ColorCodeConverter.convert("HSL(0, 0, 0)"));
    }

    public void testHSLMaxValues() throws Exception {
        assertEquals("RGB(255,255,255)", ColorCodeConverter.convert("HSL(359, 100, 100)"));
    }

    public void testHSLSimpleValues() throws Exception {
        assertEquals("RGB(64,191,64)", ColorCodeConverter.convert("HSL(120, 50, 50)"));
    }



    public void testHSVMinValues() throws Exception {
        assertEquals("RGB(0,0,0)", ColorCodeConverter.convert("HSV(0, 0, 0)"));
    }

    public void testHSVMaxValues() throws Exception {
        assertEquals("RGB(255,0,4)", ColorCodeConverter.convert("HSV(359, 100, 100)"));
    }

    public void testHSVSimpleValues() throws Exception {
        assertEquals("RGB(15,12,18)", ColorCodeConverter.convert("HSV(276, 33, 7)"));
    }
}