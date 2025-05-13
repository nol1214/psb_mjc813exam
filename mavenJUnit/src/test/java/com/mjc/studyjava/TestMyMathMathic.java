package com.mjc.studyjava;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestMyMathMathic {
        @Test
        public void testMyTestArray() {
            MyMathMathic mmm = new MyMathMathic();

            assertThat(mmm.getBigDecimal(3643, 5630932)).isEqualTo(new BigDecimal("3643.5630932"));
            assertThat(mmm.getBigDecimal(-741874895, 1004780065)).isEqualTo(new BigDecimal("-741874895.1004780065"));
            assertThat(mmm.getBigDecimal(0, 0)).isEqualTo(new BigDecimal(0));
            assertThat(mmm.getIntegerArray(new int[] {7, 89, 201, 31})).isEqualTo(new Integer[] {7, 89, 201, 31});
            assertThat(mmm.getIntegerArray(new int[] {-201, 89, 5, 2, 17, -32029})).isEqualTo(new Integer[] {-201, 89, 5, 2, 17, -32029});
            assertThat(mmm.getIntegerArray(null)).isEqualTo(null);
            int[] randomArray = mmm.makeRandomIntArray(5);
            assertThat(randomArray).isNotNull();
            assertThat(randomArray.length).isEqualTo(5);
            String sEnc1 = mmm.makeEncryptString("mjc813", 5);
            String sEnc2 = mmm.makeEncryptString("LeeSunSin", 5);
            assertThat(sEnc1.length()).isEqualTo(31);
            assertThat(sEnc2.length()).isEqualTo(46);
            assertThat(mmm.makeEncryptString(null, 5)).isEqualTo("");
            String sOrg1 = mmm.makeDecryptString(sEnc1, 5);
            String sOrg2 = mmm.makeDecryptString(sEnc2, 5);
            assertThat(sOrg1).isEqualTo("mjc813");
            assertThat(sOrg1.length()).isEqualTo(6);
            assertThat(sOrg2).isEqualTo("LeeSunSin");
            assertThat(sOrg2.length()).isEqualTo(9);
            assertThat(mmm.makeDecryptString(null, 5)).isEqualTo("");
        }
    }