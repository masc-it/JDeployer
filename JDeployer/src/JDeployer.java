import java.io.FileNotFoundException;

class JDeployer {

    public static void main(String[] args) {
        
        if ( args.length == 0){

            System.out.println(
                "HELP, HOW TO USE\n\n1 - Output JAR name\n" +
                "2 - Main class (always) and other classes (separated by comma, or use *.class to get them all)\n" +
                "3 - External JARS dependencies (separated by comma).\n\n" +
                "EXAMPLE: java -jar JDeployer.jar RunnableJar.jar Main.class,AnotherClass.class SomeDependency.jar,Anotherone.jar\n\n");
            return;
        }
        
        // setup args
        Names setup = new Names();
        if ( args.length == 3 )
            setup.setNames(args[0], args[1], args[2]);
        else
            setup.setNames(args[0], args[1], null);
       
        try {
            ManifestBuilder.createManifest(setup.getClassNames()[0], setup.getDeps());

        } catch (FileNotFoundException e) {
            
            System.out.println("Couldn't create MANIFEST.md");
		}
        
        StringBuilder command = new StringBuilder(); 
        command.append("jar -cmf MANIFEST.mf " + setup.getJarName() );

        for ( int i = 0; i < setup.getClassNames().length; i++){
            command.append(" " + setup.getClassNames()[i]);
        }

        ProcessManager.execProcess(command.toString());

    }


    static private class Names {

        private String jarName = null;
        private String[] classes = null;
        private String[] deps = null;

        private void setJarName(String name){
            jarName = name;
        }

        private void setClassNames(String[] classes){
            this.classes = classes;
        }

        private void setDepsNames(String[] jars){
            deps = jars;
        }

        void setNames(String jarName, String classes, String dependencies){

            setJarName(jarName);
            setClassNames(classes.split(","));
            if ( dependencies != null )
                setDepsNames(dependencies.split(","));
        }

        String getJarName(){
            return jarName;
        }

        String[] getClassNames(){
            return classes;
        }

        String[] getDeps(){
            return deps;
        }
    }
}