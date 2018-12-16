class ProcessManager {

    static void execProcess(String command){
        final Runtime r = Runtime.getRuntime();
        Process p;
        try {
            
            p = r.exec(command.toString());
            p.waitFor();
            System.out.println("Runnable JAR executable created!");
        } catch (Exception e) {
            
            System.out.println("Error while creating the JAR, retry.");
        }
        
    }


}