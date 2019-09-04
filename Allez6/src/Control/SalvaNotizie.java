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

import Beans.Notizia;
import Beans.Prodotto;
import Model.ModelNotizia;

/**
 * Servlet implementation class SalvaNotizie
 */
@WebServlet("/SalvaNotizie")
public class SalvaNotizie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	   private String filePath;
	   private int maxFileSize = 500 * 1024;
	   private int maxMemSize = 4 * 1024;
	   private File file ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvaNotizie() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init( ){
	      // Get the file location where it would be stored.
	     //filePath = getServletContext().getInitParameter("file-upload"); 
	//	filePath = "C:\\Users\\ozne2\\TSW\\Allez5\\WebContent\\images\\";
	//	filePath = "/Users/lorenzofasolino/Desktop/TSW/Allez6/WebContent/images/"; //Lorenzo
		//filePath ="\\Allez6.0\\WebContent\\images\\";
	   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//SE ESEGUITO CON TOMCAT
		filePath = request.getServletContext().getRealPath("")+"/images/";
		
		ModelNotizia model = new ModelNotizia();
		
	     Notizia notizia = new Notizia();
		
	 	boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		//this will help you identify request is of type multipart or not.
		
		
		 
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
              
                if(fieldname.equalsIgnoreCase("titolo")) {
                	notizia.setTitolo(fieldvalue);
                	
                }
                if(fieldname.equalsIgnoreCase("notizia")) {
                	notizia.setNotizia(fieldvalue);
                }
               
               
                	System.out.println(fieldname + ""+ fieldvalue);
               
            } else {
                // Process form file field (input type="file").
                String fieldname = item.getFieldName();
                String filename = FilenameUtils.getName(item.getName());
                //String filename = "prova";
                FileItem filecontent = item;
                String fieldvalue = filename;
                System.out.println(fieldvalue);
                System.out.println(filePath);
                notizia.setImmagine("./images/"+fieldvalue);
               
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
			model.doSave(notizia);
			System.out.println("ciao");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect(request.getContextPath() + "/RegistrazioneProdotto.jsp");
		}
	


	}
	     
	     
	     
		
		
		
}


