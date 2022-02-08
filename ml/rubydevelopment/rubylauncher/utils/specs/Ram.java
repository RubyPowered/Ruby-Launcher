package ml.rubydevelopment.rubylauncher.utils.specs;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

public class Ram {

	private static long RAM;
	
	private static void setRam() {
	OperatingSystemMXBean bean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
		RAM = bean.getTotalPhysicalMemorySize() / 1024 / 1024 / 1024;
		System.out.println(RAM);
	}
	public static String getRam() {
		Ram.setRam();
		return String.valueOf(RAM);
	}
}
