package com.yaronxiong.seftest;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class BigDecimalUtils {
	private static final int COMMON_SCALE = 16;
	private static final int SHOW_SCALE_0 = 0;
	private static final int SHOW_SCALE_2 = 2;
	private static final int SHOW_SCALE_4 = 4;
	private static final int COMMON_ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
	private static final int DOWN_ROUNDING_MODE = BigDecimal.ROUND_DOWN;

	private static final MathContext COUNT_MATH_CONTEXT = new MathContext(COMMON_SCALE, RoundingMode.HALF_UP);

	/**
	 * 对两个值做除法，并四舍五入，精度: {@link BigDecimalUtils#COMMON_SCALE}
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static BigDecimal divide(BigDecimal a, BigDecimal b) {
		return a.divide(b, COMMON_SCALE, COMMON_ROUNDING_MODE);
	}

	/**
	 * 把分转换为元
	 * 
	 * @param a
	 * @return
	 */
	public static BigDecimal fen2Yuan(BigDecimal a) {
		return a.movePointLeft(2).setScale(COMMON_SCALE);
	}

	/**
	 * 把分为单位转换为元
	 *
	 * @param money
	 * @return
	 */
	public static BigDecimal fen2Yuan(long money) {
		return BigDecimal.valueOf(money, 2).setScale(COMMON_SCALE);
	}

	/**
	 * 把分为单位转换为元
	 *
	 * @param money
	 * @return
	 */
	public static BigDecimal fen2Yuan(int money) {
		return BigDecimal.valueOf(money, 2);
	}

	/**
	 * 把元为单位转换为分（四舍五入）
	 *
	 * @param money
	 * @return
	 */
	public static long yuan2Fen(BigDecimal money) {
		return money == null ? 0 : money.movePointRight(2).setScale(0, COMMON_ROUNDING_MODE).longValue();
	}

	/**
	 * 把元为单位转换为分（四舍五入）
	 *
	 * @param money
	 * @return
	 */
	public static int yuan2FenByInteger(BigDecimal money) {
		return money == null ? 0 : money.movePointRight(2).setScale(0, COMMON_ROUNDING_MODE).intValue();
	}

	/**
	 * 获取4位精度（四舍五入）
	 *
	 * @param money
	 * @return
	 */
	public static BigDecimal get4Scale(BigDecimal money) {
		return money == null ? null : money.setScale(SHOW_SCALE_4, COMMON_ROUNDING_MODE);
	}

	/**
	 * 获取2位精度（四舍五入）
	 *
	 * @param money
	 * @return
	 */
	public static BigDecimal get2Scale(BigDecimal money) {
		return money == null ? null : money.setScale(SHOW_SCALE_2, COMMON_ROUNDING_MODE);
	}

	/**
	 * 获取特殊结果
	 * 如果是整数，直接返回整数（不带小数点）
	 * 如果是有小数，则返回2位精度（带小数点）
	 * @param money
	 * @return
	 */
	public static String getSpecResult(BigDecimal money) {
		if(money.compareTo(new BigDecimal(money.intValue())) == 0) {
			return String.valueOf(money.intValue());
		}
		return String.valueOf(get2Scale(money).doubleValue());
	}

	/**
	 * 获取整数部分（直接去除小数部分）
	 * @return
	 */
	public static BigDecimal getInt(BigDecimal money){
		return money == null ? null : money.setScale(SHOW_SCALE_0, DOWN_ROUNDING_MODE);
	}

	/**
	 * 获取整数部分（四舍五入）
	 * @return
	 */
	public static BigDecimal getIntRounding(BigDecimal money){
		return money == null ? null : money.setScale(SHOW_SCALE_0, COMMON_ROUNDING_MODE);
	}

	public static BigDecimal add(BigDecimal d1, double d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.add(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal add(BigDecimal d1, int d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.add(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal add(BigDecimal d1, BigDecimal d2) {
		return d1.add(d2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal sub(BigDecimal d1, double d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.subtract(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal sub(BigDecimal d1, int d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.subtract(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal sub(BigDecimal d1, BigDecimal d2) {
		return d1.subtract(d2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal mul(BigDecimal d1, double d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.multiply(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal mul(BigDecimal d1, int d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.multiply(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal mul(List<BigDecimal> d1s) {
		if (CollectionUtils.isEmpty(d1s)) {
			return BigDecimal.valueOf(1);
		}
		BigDecimal tem = BigDecimal.valueOf(1);
		for (int i = 0; i < d1s.size(); i++) {
			tem = mul(tem, d1s.get(i));
		}
		return tem;
	}

	public static BigDecimal mul(BigDecimal d1, BigDecimal d2) {
		return d1.multiply(d2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal div(BigDecimal d1, double d2) {
		BigDecimal b2 = BigDecimal.valueOf(d2);
		return d1.divide(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal div(BigDecimal d1, int d2) {
		BigDecimal b2 = new BigDecimal(d2);
		return d1.divide(b2, COUNT_MATH_CONTEXT);
	}

	public static BigDecimal div(BigDecimal d1, BigDecimal d2) {
		return d1.divide(d2, COUNT_MATH_CONTEXT);
	}

}
