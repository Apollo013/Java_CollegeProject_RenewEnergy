/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package OtherTesting;

import Models.Abstract.ErrorBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul Millar <D00152098>
 */
public class ErrorModel extends ErrorBase{
    
    //********************************
    // ----- @RequiredValidator ------
    //********************************

    // STRINGS
    @RequiredValidator()
    private String string1ShouldFail = "    ";

    @RequiredValidator()
    private String string2_SHOULD_FAIL;
    
    @RequiredValidator()
    private String string3_SHOULD_FAIL = " ";    
    
    @RequiredValidator()
    private String string4 = "hello";    

    
    // CHARS
    @RequiredValidator()
    private char char1_SHOULD_FAIL;
    
    @RequiredValidator()
    private char char2_SHOULD_FAIL = ' ';
    
    @RequiredValidator()
    private char char3 = 's';
    
    @RequiredValidator()
    private char char4 = '4';
    
    @RequiredValidator()
    private char char5 = '%';
    
    
    // ARRAYS & COLLECTIONS -- OBJECTS
    @RequiredValidator()
    private String[] strings_SHOULD_FAIL;
    
    @RequiredValidator()
    private String[] strings2 = new String[4];
    
    @RequiredValidator()
    private int[] nums_SHOULD_FAIL;
    
    @RequiredValidator()
    private int[] nums2 = new int[2];
    
    @RequiredValidator()
    private List<String> lists_SHOULD_FAIL;
        
    @RequiredValidator()
    private List<String> lists2 = new ArrayList<String>();
    
    
    // BOOLEAN
    @RequiredValidator()
    private boolean boolean1;
    
    @RequiredValidator()
    private boolean boolean2 = false;
    
    @RequiredValidator()
    private boolean boolean3 = true;
    
    

    //********************************
    // ----- @RangeValidator ------
    //********************************
    
    // INT
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private int int1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private int int1_1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private int int1_2_SHOULD_FAIL = -1;
    
    @RangeValidator(minValue = 0.99,maxValue = 99.9)
    private int int1_3 = 1;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private int int2 = 99;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private int int2_1_SHOULD_FAIL = 100;
    
    @RangeValidator(minValue = 0,maxValue = 100)
    private int int3 = 50;    
    
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private int int4;
    
    @RangeValidator(minValue = 1,maxValue = 99.9)
    private int int4_1_SHOULD_FAIL;
    
    
    // BYTE
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private byte byte1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private byte byte1_1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private byte byte1_2_SHOULD_FAIL = -1;
    
    @RangeValidator(minValue = 0.99,maxValue = 99.9)
    private byte byte1_3 = 1;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private byte byte2 = 99;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private byte byte2_1_SHOULD_FAIL = 100;
    
    @RangeValidator(minValue = 0,maxValue = 100)
    private byte byte3 = 50;    
    
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private byte byte4;
    
    @RangeValidator(minValue = 1,maxValue = 99.9)
    private byte byte4_1_SHOULD_FAIL;
    
    
    //SHORT
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private short short1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private short short1_1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private short short1_2_SHOULD_FAIL = -1;
    
    @RangeValidator(minValue = 0.99,maxValue = 99.9)
    private short short1_3 = 1;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private short short2 = 99;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private short short2_1_SHOULD_FAIL = 100;
    
    @RangeValidator(minValue = 0,maxValue = 100)
    private short short3 = 50;    
    
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private short short4;
    
    @RangeValidator(minValue = 1,maxValue = 99.9)
    private short short4_1_SHOULD_FAIL;
    
    
    // LONG
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private long long1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private long long1_1 = 0;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private long long1_2_SHOULD_FAIL = -1;
    
    @RangeValidator(minValue = 0.99,maxValue = 99.9)
    private long long1_3 = 1;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private long long2 = 99;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private long long2_1_SHOULD_FAIL = 100;
    
    @RangeValidator(minValue = 0,maxValue = 100)
    private long long3 = 50;    
    
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private long long4;
    
    @RangeValidator(minValue = 1,maxValue = 99.9)
    private long long4_1_SHOULD_FAIL;
    
    
    // FLOAT
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private float float1 = 0.1f;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private float float1_1 = 0.0f;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private float float1_2_SHOULD_FAIL = -.1f;
    
    @RangeValidator(minValue = 0.99,maxValue = 99.9)
    private float float1_3 = 1.0f;
    
    @RangeValidator(minValue = 0.00,maxValue = 99.9)
    private float float2 = 99.9f;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private float float2_1_SHOULD_FAIL = 100.0f;
    
    @RangeValidator(minValue = 0,maxValue = 100)
    private float float3 = 50.1f;    
    
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private float float4;
    
    @RangeValidator(minValue = 1,maxValue = 99.9)
    private float float4_1_SHOULD_FAIL;
    
    
    // DOUBLE
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private double double1 = 0.00;
    
    @RangeValidator(minValue = 0.00,maxValue = 99.9)
    private double double1_1 = 0.00;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private double double1_2_SHOULD_FAIL = -1;
    
    @RangeValidator(minValue = 0.99,maxValue = 99.9)
    private double double1_3 = 1.00;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private double double2 = 99.9;
    
    @RangeValidator(minValue = 0,maxValue = 99.9)
    private double double2_1_SHOULD_FAIL = 100;
    
    @RangeValidator(minValue = 0,maxValue = 100)
    private double double3 = 50;    
    
    @RangeValidator(minValue = -.001,maxValue = 99.9)
    private double double4;
    
    @RangeValidator(minValue = 1,maxValue = 99.9)
    private double double4_1_SHOULD_FAIL;    
    
    public ErrorModel(){};
     
}
