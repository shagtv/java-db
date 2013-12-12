package ru.fizteh.fivt.students.zinnatullin.junit;

public class CommitCommand implements ShellCommand {

	@Override
    public boolean execute(String args[]) {
        assert (args.length != 0);
        if (args.length != 1) {
            Shell.printMessage(args[0] + ": invalid number of arguments in the \'" + args[0] + "\' command");
            return false;
        }

		if(Shell.getInstance().table == null){
			Shell.printMessage("empty table");
			return false;
		}
		
		int operations = 0;
		operations = Shell.getInstance().table.commit();
		Shell.printMessage("operations: " + operations);
        return true;
    }
	
	@Override
    public String getName() {
        return "commit";
    }
}
