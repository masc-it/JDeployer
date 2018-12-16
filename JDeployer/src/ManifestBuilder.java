import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class ManifestBuilder{


    static void createManifest(String mainClass, String[] externalJars) throws FileNotFoundException {
        StringBuilder manifestOutput = new StringBuilder();
        
        manifestOutput .append("Manifest-Version: 1.0"). 
        append(System.getProperty("line.separator")).
        append( "Main-Class: " + mainClass.replace(".class", "")).
        append(System.getProperty("line.separator"));
        
            if ( externalJars != null){
                manifestOutput.append("Class-Path:");
                for ( int i = 0; i < externalJars.length; i++){
                    manifestOutput.append(" " + externalJars[i]);
                }
                manifestOutput.append(System.getProperty("line.separator"));
            }

        saveManifest(manifestOutput.toString());

    }


    private static void saveManifest(String content) throws FileNotFoundException {
        PrintWriter pw = null;
        
        pw = new PrintWriter(new File("MANIFEST.mf"));
        pw.write(content);
        pw.flush();
        
        if ( pw != null) pw.close();
        


    }

}