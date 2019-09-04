package Control;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.output.*;

import Beans.Falesia;
import Beans.Prodotto;
import Model.ModelFalesia;

/**
 * Servlet implementation class RegFalesiaServlet
 */
@WebServlet("/RegFalesiaServlet")
public class RegFalesiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ModelFalesia model = new ModelFalesia();
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 500 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegFalesiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ){
	      // Get the file location where it would be stored.
	     //filePath = getServletContext().getInitParameter("file-upload"); 
    	//filePath = "/Users/lorenzofasolino/Desktop/TSW/Allez6/WebContent/images/falesia"; //Lorenzo
		//filePath = "C:\\Users\\ozne2\\TSW\\Allez6.0\\WebContent\\images\\";
		//filePath ="\\Allez6.0\\WebContent\\images\\";
	   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//SE ESEGUITO CON TOMCAT
		filePath = request.getServletContext().getRealPath("")+"/images/falesia";
		
		Falesia falesia = new Falesia();
		

		boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		//this will help you identify request is of type multipart or not.
		  Falesia f = new Falesia();
		
		 
		ArrayList<FileItem> items = null;
		try {
			items = (ArrayList<FileItem>) new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (FileItem item : items) {
            if (item.isFormField() ) {
                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
                String fieldname = item.getFieldName();
                String fieldvalue = item.getString();  
              
                if(fieldname.equalsIgnoreCase("indice")) {
                	int value = Integer.parseInt(fieldvalue);
                	f.setIndice(value);
                }
                if(fieldname.equalsIgnoreCase("nome")) {
                	f.setNome(fieldvalue);
                }
                if(fieldname.equalsIgnoreCase("regione")) {
                	f.setRegione(fieldvalue);
                }
                if(fieldname.equalsIgnoreCase("descrizione")) {
                	f.setDescrizione(fieldvalue);
                }
                if(fieldname.equalsIgnoreCase("posizione")) {
                	f.setPosizione(fieldvalue);
                }
               
               
                	System.out.println(fieldname + ""+ fieldvalue);
               
            } else {
                // Process form file field (input type="file").
                String fieldname = item.getFieldName();
                String filename = FilenameUtils.getName(item.getName());
                FileItem filecontent = item;
                String fieldvalue =  filename;
                System.out.println(fieldvalue);
                System.out.println(filePath);
                f.setImmagine("./images/falesia/"+fieldvalue);
               
                // ... (do your job here)
              if( filename.lastIndexOf("/") >= 0 ) {
	                  file = new File( filePath + filename.substring( filename.lastIndexOf("/"))) ;
	               } else {
	                  file = new File( filePath + filename.substring(filename.lastIndexOf("/")+1)) ;
	               }
	               try {
	            	
					item.write(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	               System.out.println("Uploaded Filename: " + filename + "<br>");
                
            }        
            
        }
        try {
        	System.out.println("ciao");
			model.doSave(f);
			System.out.println("ciao");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath() + "/registrazioneFalesia.jsp");
		}
	}

}
