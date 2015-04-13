import java.io.*;
import java.nio.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Gitlet {

	public static void main(String[] args) {
		GitSys gitlet;
		String gitCmd = args[0];
		//gitlet = new GitletSystem();
		if (gitCmd == "init") {
			gitlet = new GitSys();
			gitlet.initCommit();
		}
		else {
			gitlet = loadGitlet();

			switch (gitCmd) { 

			case "commit":
			if (args[1].length() == 0)
				System.out.println("Please enter a commit message.");
			else {
				gitlet.doCommit(args[1]);

				//gitlet.clearFiles();
			}

			break;

			case "add":
			gitlet.addFile(args[1]);
			break;

			case "log":
			//gitlet.printlog();
			break;

		}
		}
		
    }

/*    public void gitletAdd(String fileName) {
    	Set<String> storedFiles = new HashSet<String>();
    }*/

    public static GitSys loadGitlet() {
		GitSys gitlet = null;
		File gitletSer = new File("./.gitlet/gitlet.ser");

        //if myCatiFile already exists, executing the next line
        //如果cat不存在， 返回null

        if (gitletSer.exists()) {
            try {
                //这里是读取出之前保存的cat类
                FileInputStream fileIn = new FileInputStream(gitletSer);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                gitlet = (GitSys) objectIn.readObject();
                //System.out.println(myCatFile);
            } catch (IOException e) {
                String msg = "IOException while loading Gitlet.";
                //System.out.println(msg);
            } catch (ClassNotFoundException e) {
                String msg = "ClassNotFoundException while loading Gitlet.";
                //System.out.println(msg);
            }
        }
        return gitlet;
	}


}