package ru.fizteh.fivt.students.zinnatullin.junit;

public class GetCommand implements ShellCommand {

	@Override
    public boolean execute(String args[]) {
        assert (args.length != 0);
        if (args.length != 2 ) {
            Shell.printMessage(args[0] + ": invalid number of arguments in the \'" + args[0] + "\' command");
            return false;
        }
		
		if(Shell.getInstance().table == null){
			Shell.printMessage("empty table");
			return false;
		}
		
		String value = null;
		value = Shell.getInstance().table.get(args[1]);
		if(value != null){
			System.out.println("found");
			System.out.println(value);
		} else {
			System.out.println("not found");
		}
        return true;
    }
	
	@Override
    public String getName() {
        return "get";
    }
}
