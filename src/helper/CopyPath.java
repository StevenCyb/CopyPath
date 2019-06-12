package helper;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class CopyPath {
	public static void run(String[] args) {
		String argList = "";
		for(String arg : args) {
			if(!arg.equals("-cl")) {
				argList += arg + " ";
			}
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();
		clipboard.setContents(new StringSelection(argList.substring(0, argList.length() - 1)), null);
	}
}
