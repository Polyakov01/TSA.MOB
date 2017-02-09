/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import DB.DBOperations;
import files.Uploader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author PK
 */
public class JDBCUtil 
{
    
    
    public DBOperations getDBOperations ()
    {
        String JNDINAME = "";
        try 
        {
            Context ctx = new InitialContext();
            Context env = (Context) ctx.lookup("java:comp/env");
            JNDINAME = (String) env.lookup("JNDI-NAME");
            return new DBOperations(ctx, JNDINAME);
        } 
        catch (NamingException ex) 
        {
            Logger.getLogger("LOG_DB_".concat(JNDINAME)).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public Uploader getFileOperations(String APP_NAME)
    {
        return new Uploader(APP_NAME);        
    }      
}
