package com.epam.design_patterns;


abstract class Logger {  
    public static int OUTPUTINFO=1;  
    public static int ERRORINFO=2;  
    public static int DEBUGINFO=3;  
    protected int levels;  
    protected Logger nextLevelLogger;  
    public void setNextLevelLogger(Logger nextLevelLogger) {  
        this.nextLevelLogger = nextLevelLogger;  
    }  
        public void logMessage(int levels, String msg){  
        if(this.levels<=levels){  
            displayLogInfo(msg);  
        }  
        if (nextLevelLogger!=null) {  
            nextLevelLogger.logMessage(levels, msg);  
        }  
    }  
    protected abstract void displayLogInfo(String msg);  
}  

interface Iterator {  
    public boolean hasNext();  
    public Object next();  
}  

interface Container {  
    public Iterator getIterator();  
}

class CollectionofNames implements Container {  
public String name[]={"Ashwani Rajput", "Soono Jaiswal","Rishi Kumar","Rahul Mehta","Hemant Mishra"};   
      
@Override  
    public Iterator getIterator() {  
        return new CollectionofNamesIterate() ;  
    }  
    private class CollectionofNamesIterate implements Iterator{  
        int i;  
        @Override  
        public boolean hasNext() {  
            if (i<name.length){  
                return true;  
            }  
            return false;  
        }  
        @Override  
        public Object next() {  
            if(this.hasNext()){  
                return name[i++];  
            }  
            return null;      
        }  
    }  
}   


class ConsoleBasedLogger extends Logger {  
    public ConsoleBasedLogger(int levels) {  
        this.levels=levels;  
    }  
    @Override  
    protected void displayLogInfo(String msg) {  
        System.out.println("CONSOLE LOGGER INFO: "+msg);  
    }  
}  

class DebugBasedLogger extends Logger {  
    public DebugBasedLogger(int levels) {  
        this.levels=levels;  
    }  
    @Override  
    protected void displayLogInfo(String msg) {  
        System.out.println("DEBUG LOGGER INFO: "+msg);  
    }  
}

class ErrorBasedLogger extends Logger {  
    public ErrorBasedLogger(int levels) {  
        this.levels=levels;  
    }  
    @Override  
    protected void displayLogInfo(String msg) {  
        System.out.println("ERROR LOGGER INFO: "+msg);  
    }  
}


public class Behavioral {
	
	private static Logger doChaining(){  
        Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);  
          
        Logger errorLogger = new ErrorBasedLogger(Logger.ERRORINFO);  
        consoleLogger.setNextLevelLogger(errorLogger);  
          
        Logger debugLogger = new DebugBasedLogger(Logger.DEBUGINFO);  
        errorLogger.setNextLevelLogger(debugLogger);  
          
        return consoleLogger;   
        }  
	public void bakaittop() throws Exception{
		  
		System.out.println("Chain of Responsibility:");
		Logger chainLogger= doChaining();  
        chainLogger.logMessage(Logger.OUTPUTINFO, "Enter the sequence of values ");  
        chainLogger.logMessage(Logger.ERRORINFO, "An error is occured now");  
        chainLogger.logMessage(Logger.DEBUGINFO, "This was the error now debugging is compeled"); 
        System.out.println("\nIterator Pattern:");
        CollectionofNames cmpnyRepository = new CollectionofNames();  
        
        for(Iterator iter = cmpnyRepository.getIterator(); iter.hasNext();){  
            String name = (String)iter.next();  
            System.out.println("Name : " + name);  
         }      
	}
}
