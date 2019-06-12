package helper;

import java.io.IOException;

public class Install {
	public static void run(String path) throws IOException, InterruptedException {
		System.out.println("Installing...");
		String javaPath = System.getProperty("java.home") + "\\bin\\javaw\\\" -jar ";
		String []installCommands = new String[] {
				"HKEY_CURRENT_USER\\Software\\Classes\\directory\\shell\\",
				"HKEY_CURRENT_USER\\Software\\Classes\\directory\\Background\\shell\\",
				"HKEY_CURRENT_USER\\Software\\Classes\\*\\shell\\",
		};
		for(String regPath : installCommands) {
			System.out.println("Installing [" + regPath + "]...");
			Process p1 = Runtime.getRuntime().exec("cmd /c " + regPath + "CopyPath /f");
			Thread.sleep(500);
			Process p2 = Runtime.getRuntime().exec("cmd /c REG Add " + regPath + "CopyPath\\command /f");
			Thread.sleep(500);
			Process p3 = Runtime.getRuntime().exec("cmd /c REG Add " + regPath + "CopyPath\\command /ve /d \"\\\"" + javaPath + "\\\"" + path + "CopyPath.jar\\\" -cl \\\"" + (regPath.contains("Background") ? "%V": "%1") + "\\\"\" /f");
			Thread.sleep(500);
			Process p4 = Runtime.getRuntime().exec("cmd /c REG Add " + regPath + "CopyPath /v Icon /t REG_SZ /d \"" + path + "icon.ico\" /f");
			Thread.sleep(500);
			p1.destroy();
			p2.destroy();
			p3.destroy();
			p4.destroy();
		}
		System.out.println("Ready!");
	}
}
