package ru.fizteh.fivt.students.zinnatullin.junit;

public class ExitCommand implements ShellCommand {
    
	@Override
	public boolean execute(String args[]) {
        assert (args.length != 0);
        if (args.length > 1) {
            System.out.println(args[0] + ": invalid number of arguments in the \'" + args[0] + "\' command");
            return false;
        }
		if(Shell.getInstance().table != null && Shell.getInstance().table.getOperations() > 0){
			Shell.printMessage(Shell.getInstance().table.getOperations() + " unsaved changes");
			return false;
		}
		System.out.println("exit");
		return true;
    }
    
	@Override
	public String getName() {
        return "exit";
    }

}
