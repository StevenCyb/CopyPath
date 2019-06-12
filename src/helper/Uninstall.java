package helper;

import java.io.IOException;

public class Uninstall {
	public static void run(String path) throws IOException, InterruptedException {
		System.out.println("Uninstalling...");
		String []installCommands = new String[] {
				"HKEY_CURRENT_USER\\Software\\Classes\\directory\\shell\\",
				"HKEY_CURRENT_USER\\Software\\Classes\\directory\\Background\\shell\\",
				"HKEY_CURRENT_USER\\Software\\Classes\\*\\shell\\",
		};
		for(String regPath : installCommands) {
			System.out.println("Uninstall [" + regPath + "]...");
			Process p = Runtime.getRuntime().exec("cmd /c REG DELETE " + regPath + "\\CopyPath /f");
			Thread.sleep(500);
			p.destroy();
		}
		System.out.println("Ready!");
	}
}
