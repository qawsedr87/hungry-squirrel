package hungrysquirrelgame.helpers;


import hungrysquirrelgame.exception.ResourceException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author louise
 */
public class FileResource {
    private String path;
    private String source;
    
    public FileResource(String fname) {
        initRead(fname);
    }
    
    
    public String asString() {
        return source;
    }
    
    // create from the name of a File
    private void initRead(String fname) {
        try {
            path = fname;
            InputStream is = getClass().getClassLoader().getResourceAsStream(fname);
            if (is == null) {
                is = new FileInputStream(fname);
            }
            source = initFromStream(is);
        }
        catch (Exception e) {
            throw new ResourceException("FileResource: cannot access " + fname);
        }
    }
    
    // store data 
    private String initFromStream(InputStream stream) {
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
            StringBuilder contents = new StringBuilder();
            String line = null;
            while ((line = buff.readLine()) != null) {
                contents.append(line + "\n");
            }
            return contents.toString();
        }
        catch (Exception e) {
            throw new ResourceException("FileResource: error encountered reading " + path, e);
        }
        finally {
            try {
                if (buff != null) {
                    buff.close();
                }
            }
            catch (Exception e) {
                // should never happen
            }
        }
    }
    
}
