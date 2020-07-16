package com.accompnay.nginx;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1.获取 \\YANGSHUTAO\nginx_onesdkserver_accesslog\onesdkserver_pjalm_access.log 日志到本地
 * <p>
 * 2.分析日志，要求输出以下数据：
 * <p>
 * 2.1:每个请求（url）的调用次数，平均响应时间，响应成功率（非4xx，5xx）
 * 2.2:所有请求，每个客户端IP的调用总次数，每个host的调用总次数
 * 3. 以上结果输出到2个txt文件保存。
 * <p>
 * 每一行的数据，多个列之间，用\t分隔。
 * <p>
 * <p>
 * <p>
 * 日志格式解析举例：
 * <p>
 * 111.231.89.16 - - [07/Apr/2020:03:21:07 +0800] "POST /gameid/100040/risk/game/getRealNameInfo HTTP/1.1" 200 209 "-" x00 "111.231.89.16" x00 "Java/1.8.0_91" "0.002" "0.002" "oneserver.online.100bt.com" "10.105.195.230:8080"
 * <p>
 * 客户端IP：  111.231.89.16
 * <p>
 * 调用URL：  /gameid/100040/risk/game/getRealNameInfo
 * <p>
 * 响应httpstatus： 200
 * <p>
 * 响应时间：0.002s
 */
public class Test {
	private static final String ENCODING = "UTF-8";

	public static void main(String[] args) {
		String filePath = "C:\\Users\\yaoyuanxiong\\Desktop\\log.txt";
		String outputFile1 = "C:\\Users\\yaoyuanxiong\\Desktop\\outputFile1.txt";
		String outPutFile2 = "C:\\Users\\yaoyuanxiong\\Desktop\\outPutFile2.txt";
		Test test = new Test();
		test.analysisLog(filePath, outputFile1, outPutFile2);
	}

	public void analysisLog(String sourcePath, String filePath1, String filePath2) {
		List<LogEntity> list = parseLogFile(sourcePath);
		Map<String, UrlMessage> urlMessageMap = new HashMap<>(16);
		Map<String, Integer> clientsUseCountMap = new HashMap<>(16);
		Map<String, Integer> hostsUseCountMap = new HashMap<>(16);
		for (LogEntity logEntity : list) {
			//每个请求（url）的调用次数，平均响应时间，响应成功率（非4xx，5xx）
			UrlMessage urlMessage = urlMessageMap.getOrDefault(logEntity.getUrl(), new UrlMessage());
			Integer useCount = Objects.isNull(urlMessage.getUseCount()) ? 1 : urlMessage.getUseCount() + 1;
			Integer successfulTimes = Objects.isNull(urlMessage.getSuccessfulTimes()) ? 0 : urlMessage.getSuccessfulTimes();
			Double avgResponseTime = Objects.isNull(urlMessage.getAvgResponseTime()) ? logEntity.getResponseTime() : MathUtils.avg(logEntity.getResponseTime(), urlMessage.getAvgResponseTime());
			if (!Objects.isNull(logEntity.getResponseCode()) && logEntity.getResponseCode() <= 299) {
				successfulTimes++;
			}
			urlMessage.setUrl(logEntity.getUrl());
			urlMessage.setSuccessfulTimes(successfulTimes);
			urlMessage.setUseCount(useCount);
			urlMessage.setAvgResponseTime(avgResponseTime);
			urlMessage.setRateSuccess(MathUtils.div(successfulTimes, urlMessage.getUseCount()));
			urlMessageMap.put(urlMessage.getUrl(), urlMessage);
			//所有请求，每个客户端IP的调用总次数，每个host的调用总次数
			Integer clientUseCount = clientsUseCountMap.getOrDefault(logEntity.getIp(), 0);
			clientsUseCountMap.put(logEntity.getIp(), clientUseCount + 1);
			Integer hostUseCount = hostsUseCountMap.getOrDefault(logEntity.getHost(), 0);
			hostsUseCountMap.put(logEntity.getHost(), hostUseCount + 1);
		}
		writeUrlMessageMap(urlMessageMap, filePath1);
		writeUseCount(clientsUseCountMap,filePath2);
		writeUseCount(hostsUseCountMap,filePath2);
	}

	private void writeUseCount(Map<String, Integer> map, String filePath) {
		BufferedWriter writer = null;
		String errorMes;
		try {
			File file = new File(filePath);
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file,true));
			for (String key : map.keySet()) {
				Integer useCount = map.get(key);
				writer.write(key+"\t"+useCount);
				writer.newLine();
				writer.flush();
			}
		} catch (Exception e) {
			errorMes = "写文件失败";
			throw new RuntimeException(errorMes);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				errorMes = "写资源释放失败";
			}
		}
	}

	private void writeUrlMessageMap(Map<String, UrlMessage> map, String filePath) {
		BufferedWriter writer = null;
		String errorMes;
		try {
			File file = new File(filePath);
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			for (String key : map.keySet()) {
				UrlMessage urlMessage = map.get(key);
				writer.write(urlMessage.getUrl() + "\t");
				writer.write(urlMessage.getUseCount() + "\t");
				writer.write(String.format("%.3f", urlMessage.getAvgResponseTime()) + "\t");
				writer.write(urlMessage.getRateSuccess().toString());
				writer.newLine();
				writer.flush();
			}
		} catch (Exception e) {
			errorMes = "写文件失败";
			throw new RuntimeException(errorMes);
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				errorMes = "写资源释放失败";
			}
		}
	}

	private List<LogEntity> parseLogFile(String filePath) {
		InputStreamReader reader = null;
		BufferedReader bufferedReader = null;
		String errorMes = "";
		List<LogEntity> parseResult = new ArrayList<>();
		try {
			File file = new File(filePath);
			if (file.isFile() && file.exists()) {
				reader = new InputStreamReader(new FileInputStream(file), Test.ENCODING);
				bufferedReader = new BufferedReader(reader);
				String text = null;
				while ((text = bufferedReader.readLine()) != null) {
					LogEntity logEntity = parseTest(text);
					parseResult.add(logEntity);
				}
				return parseResult;
			} else {
				throw new RuntimeException("文件不存在");
			}

		} catch (Exception e) {
			throw new RuntimeException(errorMes);
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (Exception e) {
				errorMes = "释放资源失败";
			}
		}

	}

	private LogEntity parseTest(String text) {
		String parent = "(?<ip>\\d+\\.\\d+\\d+\\.\\d+\\.\\d+)( - - \\[)" +
				"(?<time>[\\s\\S]+)(\\][\\s\"]+)" +
				"(?<request>[A-Z]+) (?<url>\\S+) " +
				"(?<protocol>\\S+)[\"] (?<responseCode>\\d+) " +
				"(?<sendBytes>\\d+) [\"]" +
				"(?<refferer>[\\S]*)[\"] x00 [\"]" +
				"(?<XforwardedFor>\\d+\\.\\d+\\d+\\.\\d+\\.\\d+)[\"] x00 [\"]" +
				"(?<userAgent>\\S+)[\"] [\"]" +
				"(?<requestTime>\\d+(\\.\\d+)?)[\"] [\"]" +
				"(?<responseTime>\\d+(\\.\\d+)?)[\"] [\"]" +
				"(?<host>(\\w+\\.)*(com|cn))[\"] [\"]" +
				"(?<upstreamAddr>(\\d+\\.\\d+\\d+\\.\\d+\\.\\d+)(:\\d+)?)[\"]";
		Pattern r = Pattern.compile(parent);
		Matcher m = r.matcher(text);
		boolean b = m.find();
		if (!b) {
			throw new RuntimeException("解析出错");
		}
		LogEntity entity = new LogEntity();
		entity.setIp(m.group("ip"));
		entity.setRequest(m.group("request"));
		entity.setUrl(m.group("url"));
		entity.setResponseTime(Double.valueOf(m.group("responseTime")));
		entity.setResponseCode(Integer.valueOf(m.group("responseCode")));
		entity.setHost(m.group("host"));
		return entity;
		/*System.out.println(m.group("ip"));
		System.out.println(m.group("time"));
		System.out.println(m.group("request"));
		System.out.println(m.group("url"));
		System.out.println(m.group("protocol"));
		System.out.println(m.group("responseCode"));
		System.out.println(m.group("sendBytes"));
		System.out.println(m.group("refferer"));
		System.out.println(m.group("XforwardedFor"));
		System.out.println(m.group("userAgent"));
		System.out.println(m.group("requestTime"));
		System.out.println(m.group("responseTime"));
		System.out.println(m.group("host"));
		System.out.println(m.group("upstreamAddr"));*/
	}


}
