
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Referencia implements Serializable{
    
    private String ref;
    
    public Referencia (String referencia){
    
         this.ref = referencia;

    }
    
    public static boolean comprobarReferencia(String referenciaIntroducida){
        
        Pattern p=Pattern.compile("[0-9]{8}");
        Matcher m=p.matcher(referenciaIntroducida);
        if(m.matches()) {
            return true;
        }else {

            return false;
        }
        
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return ref.substring(0,2) + "-" + ref.substring(2,4) + "-" + ref.substring(4,8);
    }
    
    
    
}
