package ru.fizteh.fivt.students.zinnatullin.filemap;

import java.io.*;
import java.util.ArrayList;

public class Shell {
	
	private final ArrayList<ShellCommand> commands;
    protected static PrintStream outputStream = System.out;
	protected static File currentPath = new File("").getAbsoluteFile();
	
	private Database db;
	
	private static Shell shell;	
	
	private Shell() {
        commands = new ArrayList<>();
        commands.add(new PutCommand());
        commands.add(new GetCommand());
        commands.add(new RemoveCommand());
        commands.add(new ExitCommand());
    }
	
	public static Shell getInstance(){
		if(shell == null){
			shell = new Shell();
		}
		return shell;
	}
	
	public static void main(String[] args) throws IOException{
				
		Shell.getInstance().setDB();
		
		if (args.length == 0) {
            shell.exec(System.in, false);
        } else {
            StringBuilder builder = new StringBuilder();
            for (String arg : args) {
                builder.append(arg);
                builder.append(" ");
            }
            String string = builder.toString().replaceAll(";", "\n");
            byte[] bytes = string.getBytes("UTF-8");
            InputStream inputStream = new ByteArrayInputStream(bytes);
            if (!shell.exec(inputStream, true)) {
                System.exit(1);
            }
        }
	}
	
	private boolean exec(InputStream input, boolean isPackage) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        while (true) {
            if (!isPackage) {
                printSuggestMessage();
            }
            String commandName = reader.readLine();
            if (commandName == null) {
                break;
            }
            String tokens[] = commandName.split("[\\s]");
            boolean status = false;
            boolean exists = false;
            for (ShellCommand command : commands) {
                if (command.getName().equals(tokens[0])) {
                    status = command.execute(tokens);
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                printMessage(tokens[0] + ": command not found");
            }
            if (!status && isPackage) {
                return false;
            }
            if (tokens[0].equals("exit")) {
                return true;
            }
        }
        return true;
    }
	
	public void setDB(){
		System.setProperty("fizteh.db.dir", "/home/timur/java/work/db/");
		String dir = System.getProperty("fizteh.db.dir");
		
		File file =  new File(dir);
		if(!file.isDirectory()){
			printMessage("Incorrect db path");
			System.exit(1);
		}
		db = new Database(dir, "db.dat");
	}
	
	public Database getDB(){
		return db;
	}
	
	public static void printMessage(final String message) {
        outputStream.println(message);
    }
	
    public static void printSuggestMessage() {
        outputStream.print(currentPath.getName() + File.separator + "$ ");
    }
}
