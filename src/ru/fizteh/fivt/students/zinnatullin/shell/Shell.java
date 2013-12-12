package ru.fizteh.fivt.students.zinnatullin.shell;

import java.io.*;
import java.util.ArrayList;

public class Shell {
    
	protected static PrintStream outputStream = System.out;
	private ArrayList<ShellCommand> commands;
    
	public Shell() {
        commands = new ArrayList<>();
        commands.add(new CdCommand());
        commands.add(new CpCommand());
        commands.add(new DirCommand());
        commands.add(new ExitCommand());
        commands.add(new MkdirCommand());
        commands.add(new MvCommand());
        commands.add(new PwdCommand());
        commands.add(new RmCommand());
    }
	
    public static void main(String[] args) throws IOException {
        Shell shell = new Shell();
		
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
	
	public static void printMessage(final String message) {
        outputStream.println(message);
    }
    
	public static void printSuggestMessage() {
        outputStream.print(FileSystem.currentPath.getName() + File.separator + "$ ");
    }
}
