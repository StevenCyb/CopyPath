import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import helper.CopyPath;
import helper.Install;
import helper.Uninstall;

public class Main {
	private static String VERSION = "1.0";
	
	public static void main(String args[]) throws URISyntaxException, IOException, InterruptedException {
		String path = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath().replace("CopyPath.jar", "") ;
		if(args.length == 0 || args[0].equals("-h") || args[0].equals("-help")) {
			System.out.println("#######################");
			System.out.println("##  CopyPath: V" + VERSION + "   ##");
			System.out.println("#######################");
			System.out.println("##  -h | -help       ##");
			System.out.println("##  -v | -version    ##");
			System.out.println("##  -i | -install    ##");
			System.out.println("##  -u | -uninstall  ##");
			System.out.println("#######################");
		} else if(args[0].equals("-v") || args[0].equals("-version")) {
			System.out.println("LinkCopy: V" + VERSION);
		} else if(args[0].equals("-i") || args[0].equals("-install")) {
			Install.run(path);
		} else if(args[0].equals("-u") || args[0].equals("-uninstall")) {
			Uninstall.run(path);
		} else if(args[0].equals("-cl")) {
			CopyPath.run(args);
		} else {
			String argList = "";
			for(String arg : args) {
				argList += arg + ", ";
			}
			System.err.println("Unknown command [" + (argList.length() == 0 ? "" : argList.substring(0, argList.length() - 2)) + "]");
		}
	}
}
