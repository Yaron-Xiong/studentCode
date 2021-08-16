package com.accompnay.myTest;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * 增强器
 */
public class MyTransformer implements ClassFileTransformer {
	@Override
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		if (!className.equals("java/util/concurrent/ScheduledThreadPoolExecutor")) {
			return null;
		}
		try {
			System.out.println("开始增强..."+className);
			ClassPool classPool = ClassPool.getDefault();
			CtClass ctClass = classPool.get("java.util.concurrent.ScheduledThreadPoolExecutor");
			if (ctClass.isFrozen()){
				return ctClass.toBytecode();
			}
			CtMethod method = CtMethod.make("protected void beforeExecute(Thread t, Runnable r) { System.out.println(\"定时任务初始化方法\"); }", ctClass);
			ctClass.addMethod(method);
			return ctClass.toBytecode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
